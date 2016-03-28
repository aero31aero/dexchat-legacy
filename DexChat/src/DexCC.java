

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Default.*;
import Default.*;
import java.net.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author pc
 */
public class DexCC extends Thread{
    public void run()
{
int port = Integer.parseInt(Launcher.portname.getText());
DexQuote bart = new DexQuote();
try
{
System.out.println("DexServer 2.0");
System.out.println("Listening on port " + port);
ServerSocket ss = new ServerSocket(port);
while (true) 
{
Socket s = ss.accept();
System.out.println("Connection established!");
//CODE STARTS

       
        
//CODE ENDS        
Thread t = new Thread(new DexCT(s, bart));
t.start();
}
}
catch (Exception e)
{
System.out.println("System exception!");
}
}
    public static void run1()
    {
        Server.txt1="Qwert";
        
    }
}

