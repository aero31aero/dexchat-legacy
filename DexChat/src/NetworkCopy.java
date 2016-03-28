/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rohitt
 */
public class NetworkCopy extends Thread{
    @Override
    public void run(){
        try {
            Server.opcheck=true;
            ServerSocket ss = new ServerSocket(1233);

            Socket s = ss.accept();
            System.out.println("Connection established!");
  


            
            Scanner in = new Scanner(s.getInputStream());

                
            OutputStream out = s.getOutputStream();
            boolean q=copy(Default.Var.file1,out);
            Server.opcheck=q;
            if(!q){
                Server.chat=Server.chat+"\n>>NETFILESERVICE: File copying failed. Please check the file name and path and try again.\n";        
            }
        } catch (IOException ex) {
            Logger.getLogger(NetworkCopy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static boolean copy(String src,OutputStream dst){
        InputStream inStream;
	OutputStream outStream = dst;
        boolean c=false;
    	try{
            
    	    File a =new File(src);
            //long len = a.length();
    	    
            if(a.exists()){
            
    	    inStream = new FileInputStream(a);
    	    
 
    	    byte[] buffer = new byte[1024];
            //long i=0;
    	    int length;
    	    //copy the file content in bytes 
    	    while ((length = inStream.read(buffer)) > 0){
                //i++;                
    	    	outStream.write(buffer, 0, length);
                //Server.opstatus=(int) ((i*1024*100)/len);
    	    }            
                                {
                                    Server.chat=Server.chat+"\n>>NETFILESERVICE: File Copied. The File Path is: "+dst+"\n";
                                } 
                                if(Server.delete){
                                    boolean delete = a.delete();
                                    Server.chat=Server.chat+">>NETFILESERVICE: Original File Deleted. The path was: "+src+". Operation successful.\n";
                                }
                                
    	    inStream.close();
    	    outStream.close();
            c=true;
            }
            
    	}catch(IOException e){
    		e.printStackTrace();
    	}
        return c;
        
    }
}
