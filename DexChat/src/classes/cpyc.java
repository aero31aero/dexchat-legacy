/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author pc
 */


import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class cpyc extends Thread{
    @Override
    public void run() {
        try {
            File a = new File("G:\\abc.txt");    
            boolean createNewFile;
            createNewFile = a.createNewFile();
            classes.FileCopy.getFile(a,"localhost");
        } catch (IOException ex) {
            Logger.getLogger(cpys.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(Exception e){
            
        }
      }
}
