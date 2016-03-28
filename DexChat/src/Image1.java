



import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pc
 */
public class Image1 {
    public static Image iconToImage(Icon icon)
{
    if(icon instanceof ImageIcon)
    {
        return ((ImageIcon) icon).getImage();
    }
    else
    {
        BufferedImage image = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
        icon.paintIcon(null, image.getGraphics(), 0, 0);
        return image;
    }
}
}
