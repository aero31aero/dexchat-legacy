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

/**
 *
 * @author rohitt
 */
public class ThreadedCopy extends Thread{
    @Override
    public void run(){
        Server.opcheck=true;
        boolean q=copy(Server.cpy1,Server.cpy2,Server.cpy3);
        Server.opcheck=q;
        if(!q){
            Server.chat=Server.chat+"\n>>FILESERVICE: File copying failed. Please check the file name and path and try again.\n";
        }        
    }
    public static boolean copy(String src,String dst,String dir){
        InputStream inStream;
	OutputStream outStream;
        boolean c=false;
    	try{
            File d=new File(dir);
            if(!d.exists()){
                boolean result;
                result = d.mkdirs();
                if(!result){
                            return false;
                }
            }
    	    File a =new File(src);
            //long len = a.length();
    	    File b =new File(dst);
            if(a.exists()&&!b.exists()){
            boolean result;
                result = b.createNewFile();
            if(!result){
                return false;
            }
    	    inStream = new FileInputStream(a);
    	    outStream = new FileOutputStream(b);
 
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
                                    Server.chat=Server.chat+"\n>>FILESERVICE: File Copied. The File Path is: "+dst+"\n";
                                } 
                                if(Server.delete){
                                    boolean delete = a.delete();
                                    Server.chat=Server.chat+">>FILESERVICE: Original File Deleted. The path was: "+src+". Operation successful.\n";
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
