

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
public class serve extends Thread{
    public void run(){
        new Server().setVisible(false);
        Server.i=1;
        Server.pass=Launcher.passname.getText();
        Server.chat="";
        Server.pass=Launcher.passname.getText();
        DexCC.run1();       
        Thread proc=new DexCC();
        proc.start();
    }
}
