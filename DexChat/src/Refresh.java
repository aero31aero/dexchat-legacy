
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;



public class Refresh extends Thread implements Runnable{
    @Override
    public void run(){
           while(true){
            try {
                sleep(1000);
                SwingUtilities.invokeLater(new Runnable() {
                                 public void run() {
                                     //Launch.newFrame.time.setText(time);
                                     Client.autoRefresh.doClick();

                                 }
                             });
            } catch (InterruptedException ex) {
                Logger.getLogger(Refresh.class.getName()).log(Level.SEVERE, null, ex);
            }
       }  
    }
}