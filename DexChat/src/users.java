

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
public class users{
    private String pass,name;
    //<editor-fold defaultstate="collapsed" desc=" Method declarations[Do not modify] ">
    public users(String username,String password)
    {
        name=username;
        pass=password;
    }
    public String getName()
    {
        return name;        
    }
    public String getPass()
    {
        return pass;        
    }
    public void setName(String username)
    {
        name=username;
    }
    public void setPass(String password)
    {
        pass=password;
    }
    public void setUser(String username,String password)
    {
        name=username;
        pass=password;
    }//</editor-fold>
}
