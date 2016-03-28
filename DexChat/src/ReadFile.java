

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pc
 */
import Default.*;
import Default.*;
import java.io.*;
public class ReadFile {
    

public static void runn() throws IOException
{
    
    BufferedReader in = getReader(Server.file.getCanonicalPath());
    User user = readMovie(in);
    while (user != null) 
    {
        String msg;
        msg = "Username: " + user.name+ ": Password: " + user.pass ;
        System.out.println(msg);
        user = readMovie(in);
    }
} 
private static BufferedReader getReader(String name) 
    {
        BufferedReader in = null;
        try
        {
            File file = new File(name);
            in = new BufferedReader(
            new FileReader(file) );
        }
        catch (FileNotFoundException e)
        {
            System.out.println("The file doesn’t exist.");
            System.exit(0);
        }
        catch (IOException e)
        {
            System.out.println("I/O Error");
            System.exit(0);
        }
        return in;
    } 
private static User readMovie(BufferedReader in) 
{
    String name,pass;
    
    String line = "";
    String[] data;
    try
    {
        line = in.readLine();
    }
    catch (IOException e)
    {
        System.out.println("I/O Error");
        System.exit(0);
    }
    if (line == null)
    return null;
    else
    {
        data = line.split("\t");
        name = data[0];
        pass = data[1];
        return new User(name,pass);
    }
}
private static class User
{
    public String name,pass;
    
    public User(String name, String pass)
    {
        this.name = name;
        this.pass = pass;
        
    }
}
}

