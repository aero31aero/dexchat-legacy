/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */





/**
 *
 * @author pc
 */
public class General  {
    public static String hashReturn(String in){
        String[] a;
        a = in.split("#");
        if(a.length==2){        
            int b=Integer.parseInt(a[0]);
            String c=Server.hash.split("@")[b];//hashpaths[b];
            in=c+a[1];
            
        }
        //in = in.substring(0,in.length()-1);
        return in;        
    }
}
