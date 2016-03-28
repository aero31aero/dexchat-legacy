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
import java.util.logging.Level;
import java.util.logging.Logger;
public class erro extends Thread{
    public void run(){
        new ErrorQuit().setVisible(true);
        try {
            this.wait(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(erro.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(4);
    }
}

