/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RedServer;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author pc
 */
public class Responder extends Thread{
    private static Socket s;
    private static String client;
    private static String name;
    private static Scanner in;
    private static PrintWriter out;
    public Responder(Socket socket){
        s=socket;
        client = s.getInetAddress().toString();
    }    
    public void run(){
        try{
            in = new Scanner(s.getInputStream());
            out = new PrintWriter(s.getOutputStream(),true);
            name=in.nextLine();
            sendall();
            while(true){
                scan();
                //refresh();
            }
            
        }
        catch(Exception e){}        
    }
    private static void sendall(){
        //Vars.fullchat
        out.println("CMD_SERVER_SENDALL");
        out.println(Vars.fullchat);
    }
    private static void scan(){
        if(in.hasNext()){
            String input=in.nextLine();
            if((input.equalsIgnoreCase("CMD_ONLINE"))||(input.toUpperCase().startsWith("CMD_SENDFILE "))||(input.equalsIgnoreCase("CMD_FSTOGGLE_ON"))||(input.equalsIgnoreCase("CMD_FSTOGGLE_OFF"))||(input.equalsIgnoreCase("CMD_ADMIN_GETMSG"))||(input.equalsIgnoreCase("CMD_RESTORE"))||(input.equalsIgnoreCase("CMD_ADMIN_MSG"))||(input.equalsIgnoreCase("CMD_ADMIN_EXIT"))||(input.equalsIgnoreCase("CMD_UPTIME"))||(input.equalsIgnoreCase("CMD_GETMSGCUR"))||(input.equalsIgnoreCase("CMD_GETMSG"))||(input.equalsIgnoreCase("CMD_EXIT"))||(input.equalsIgnoreCase("REFRESH"))||(input.equalsIgnoreCase("CMD_DISCONNECT"))||(input.equalsIgnoreCase("CMD_CONNECT"))||(input.equalsIgnoreCase("CMD_BACKUP"))||(input.equalsIgnoreCase("CMD_GETTIME"))){
                //executecommand();
            }
            else{
                Server.refreshAll(client,name,in.nextLine());
            }
                        
        }
    }
}
