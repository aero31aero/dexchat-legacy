/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author pc
 */
import java.io.*;
import java.net.*;

public class FileCopy {    
    public static void getFile(File file,String ip) throws Exception {
        Socket sock = new Socket(ip, 15064);
        InputStream in = sock.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        byte [] buffer = new byte[64*1024]; 
        int bytesRead = 0;

        while ( (bytesRead = in.read(buffer)) != -1) {
            fileOutputStream.write(buffer, 0, bytesRead);
        }
        sock.close();
        fileOutputStream.close();
    }    
    
    public static void sendFile(File file) throws IOException {


        ServerSocket servsock = new ServerSocket(15064);
        Socket sock = servsock.accept();
            long time = System.currentTimeMillis();

        OutputStream out = sock.getOutputStream();
        FileInputStream fileInputStream = new FileInputStream(file);

        byte [] buffer = new byte[64*1024]; 
        int bytesRead = 0;
        long totalSent = 0;

        while ( (bytesRead = fileInputStream.read(buffer)) != -1)
        {
            if (bytesRead > 0)
            {   
                out.write(buffer, 0, bytesRead);
                totalSent += bytesRead;
                System.out.println("sent " + totalSent);
            }   
        }

        sock.close();

        System.out.println("Sent " + totalSent + " bytes in "
                + (System.currentTimeMillis() - time) + "ms.");

    }
}
