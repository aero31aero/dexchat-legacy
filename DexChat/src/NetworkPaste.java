/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pc
 */
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
public class NetworkPaste extends Thread{
    @Override
    public void run(){
        try {
            Server.opcheck=true;
            ServerSocket ss = new ServerSocket(1233);

            Socket s = ss.accept();
            System.out.println("Connection established!");
  


            
            Scanner in = new Scanner(s.getInputStream());

                
            OutputStream out = s.getOutputStream();
            boolean q=paste(Default.Var.file2,out);
            Server.opcheck=q;
            if(!q){
                Server.chat=Server.chat+"\n>>NETWORKPASTE: File copying failed. Please check the file name and path and try again.\n";        
            }
        } catch (IOException ex) {
            Logger.getLogger(NetworkCopy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static boolean paste(String src,OutputStream dst){
        InputStream inStream = null;
	OutputStream outStream = null;
        boolean c=false;
    	try{
            File b =new File(Default.Var.file3);
            b.mkdirs();
    	    File a =new File(src);
            //long len = a.length();
    	    
            if(!a.exists()){
                    a.createNewFile();
                    outStream = new FileOutputStream(a);
                                
                            int port = 1233;
                    String temp1=Client.hostname.getText();

                            
                    Socket s = DexCCL.getSocket(port); 
                    try
                    {
                    System.out.println("Connected on port " + port);

                    InputStream in = s.getInputStream();
                    inStream=in;
                         
                    
                    
                    

                    
                    // disconnect from the server
                    
                    //System.out.println(in.nextLine());

                    

                    // write the quote on the chalkboard

                    
                    byte[] buffer = new byte[1024];
            //long i=0;
    	    int length;
    	    //copy the file content in bytes 
    	    while ((length = inStream.read(buffer)) > 0){
                //i++;                
    	    	outStream.write(buffer, 0, length);
                //Server.opstatus=(int) ((i*1024*100)/len);
    	    }   
            s.close();


                    }
                    catch (Exception e)
                    {
                    e.printStackTrace(); 
                    }
    	    
 
    	    
                                {
                                    Server.chat=Server.chat+"\n>>NETFILESERVICE: File Copied. The File Path is: "+dst+"\n";
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

