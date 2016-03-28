

import Default.*;
import Default.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pc
 */
public class clein extends Thread{
    public void run(){
        new Client().setVisible(true);
        //Thread refreshthread=new Refresh();
           // refreshthread.start();
    }
}
