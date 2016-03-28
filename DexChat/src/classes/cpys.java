/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class cpys extends Thread{
    @Override
    public void run() {
        try {
            
            File a = new File("G:\\Project BTL\\Dialogs1.txt");
            
            classes.FileCopy.sendFile(a);
        } catch (IOException ex) {
            Logger.getLogger(cpys.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
}
