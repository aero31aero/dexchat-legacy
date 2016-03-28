/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author pc
 */
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
 

/**
 *
 * @author mkyong
 */
public class Images {
 
	private static int IMG_WIDTH;
	private static int IMG_HEIGHT;
 
	/**
     *  
     * @param Original_Image
     */
       
 
    public static BufferedImage resizeImage(BufferedImage originalImage,int x,int y){
        IMG_WIDTH=x;
        IMG_HEIGHT=y;
        int type=originalImage.getType();
	BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
	Graphics2D g = resizedImage.createGraphics();
	g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
	g.dispose();
 
	return resizedImage;
    }
 
    public static  BufferedImage resizeImageFullscreen(BufferedImage originalImage ){
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int x = gd.getDisplayMode().getWidth();
        int y = gd.getDisplayMode().getHeight();
        IMG_WIDTH=x;
        IMG_HEIGHT=y;
        int type=originalImage.getType();
	BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
	Graphics2D g = resizedImage.createGraphics();
	g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
	g.dispose();	
	g.setComposite(AlphaComposite.Src);
 
	g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
	RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	g.setRenderingHint(RenderingHints.KEY_RENDERING,
	RenderingHints.VALUE_RENDER_QUALITY);
	g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	RenderingHints.VALUE_ANTIALIAS_ON);
        
	return resizedImage;
    }	
}