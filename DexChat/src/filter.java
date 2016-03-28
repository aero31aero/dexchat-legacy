

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
public class filter extends javax.swing.filechooser.FileFilter{
    


public boolean accept(File f)
{
    if (f.isDirectory())
    return true;
    String name = f.getName();
    if (name.matches(".*\\.dex"))
        return true;
    else
        return false;
}   
public String getDescription()
{
        return "Dex files (*.dex)";
}

}
