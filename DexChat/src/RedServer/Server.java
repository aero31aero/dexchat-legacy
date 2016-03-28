/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RedServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class Server {
    private Socket s;
    private static ServerSocket ss;
    public static void main(String[] args){
        listen(1234);
    }
    public static void listen(int port){
        try {
            ss = new ServerSocket(port);
            int i=0;
            while(true){            
                Socket s = ss.accept();
                Vars.node[i] = new Thread(new Responder(s));                
                Vars.node[i].start();
                i++;                
            }
        }
        catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void refreshAll(String ip,String name, String msg){
        Vars.msgs.addLast(msg);
        
    }
}
