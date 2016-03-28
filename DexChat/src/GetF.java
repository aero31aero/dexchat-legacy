

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
import java.io.File;
import javax.swing.JFileChooser;
public class GetF {
    public static File getFile()
{
JFileChooser fc = new JFileChooser();
fc.setFileFilter(new filter());
fc.setAcceptAllFileFilterUsed(false);
int result = fc.showOpenDialog(null);
File file = null;
if (result == JFileChooser.APPROVE_OPTION)
file = fc.getSelectedFile();
return file;
}
}
