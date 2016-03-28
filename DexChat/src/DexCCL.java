

/*
 
 */

/**
 *
 * @author pc
 */
import Default.*;
import Default.*;
import java.net.*;
import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;
public class DexCCL
{
/*public static void runn()
{
int port = 1234;
System.out.println("Welcome to the Bart Client\n");
Socket s = getSocket(port); 
try
{
System.out.println("Connected on port " + port);
Scanner in =
new Scanner(s.getInputStream());
PrintWriter out;
out = new PrintWriter(s.getOutputStream(),
true); 
// discard the welcome message
in.nextLine(); 
// discard the exit instructions
in.nextLine(); 
// get a quote
out.println("get"); 
String quote = in.nextLine(); 
// disconnect from the server
out.println("bye"); 
//System.out.println(in.nextLine());

s.close(); 
// write the quote on the chalkboard
for (int i = 0; i < 20; i++) 

System.out.println(quote);
}
catch (Exception e)
{
e.printStackTrace(); 
}
}*/
public static Socket getSocket(int port) 
        
{
Socket s;
String host;
InetAddress ip;
Scanner sc = new Scanner(System.in);
while (true)
{
    System.out.print("What server do you want to connect to?");
    host = Client.temp1; 
try
{
    ip = InetAddress.getByName(host); 
    s = new Socket(ip, port);
    return s; 
}
catch (UnknownHostException e) 
{
    System.out.println("The host is unknown.");
    
    System.exit(1);
}
catch (IOException e)
{
    System.out.println("Network error.");
    //JOptionPane errorMsg=new JOptionPane();
    
    if(Launcher.errorCheck){
        Launcher.errorCheck=false;
        new ErrorQuit().setVisible(true);        
    }
    System.exit(12);
            
         
    
    //errorMsg.showMessageDialog(null, "A basic JOptionPane message dialog");

    //System.exit(0);

}
}
}
}
