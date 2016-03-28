/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

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
public class Files {
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
 
    	    int length;
    	    //copy the file content in bytes 
    	    while ((length = inStream.read(buffer)) > 0){
                
    	    	outStream.write(buffer, 0, length);
 
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
