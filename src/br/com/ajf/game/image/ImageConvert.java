package br.com.ajf.game.image;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;

/**
 * The Class ImageConverT.
 */
public final class ImageConvert
{
	/**
	 * Instantiates a new image Convert.
	 */
	public ImageConvert()
	{
		
	}
	
	/**
	 * Convert image to buffered image.
	 *
	 * @param img the img
	 * @return the buffered image
	 */
	public BufferedImage convertImageToBufferedImage(Image img)
	{
		ImageIcon aux = new ImageIcon(img);	
		BufferedImage imgBuffer = new BufferedImage(aux.getIconWidth(),aux.getIconHeight(),BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = imgBuffer.createGraphics();
		g.drawImage(img, 0, 0, null);
		g.dispose();
		
	return imgBuffer;
	}
	
	/**
	 * Convert image to buffered image.
	 *
	 * @param img the img
	 * @param width the width
	 * @param height the height
	 * @return the buffered image
	 */
	public BufferedImage convertImageToBufferedImage(Image img,int width,int height)
	{
		BufferedImage imgBuffer = new BufferedImage(width,height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = imgBuffer.createGraphics();
		g.drawImage(img, 0, 0, null);
		g.dispose();
		
	return imgBuffer;
	}
	
	/**
	 *Gif image to buffered image list.
	 *
	 * @param gifFile the gif file
	 * @return the list
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public List<BufferedImage> converGifImageToBufferedImageList(File gifFile) throws IOException 
	{
	    List<BufferedImage> frames = new ArrayList<>();
	        
	    ImageReader reader = ImageIO.getImageReadersByFormatName("gif").next();

	    try (ImageInputStream iis = ImageIO.createImageInputStream(gifFile)) 
	    {
	        reader.setInput(iis, false);

	        int numImages = reader.getNumImages(true);
	        BufferedImage master = null;

	        for (int i = 0; i < numImages; i++) 
	        {
	            BufferedImage currentFrame = reader.read(i);
	                
	            if (i == 0)
	            {
	                master = new BufferedImage(reader.getWidth(0), reader.getHeight(0), BufferedImage.TYPE_INT_ARGB);
	            }

	            Graphics2D g2d = master.createGraphics();
	            g2d.drawImage(currentFrame, 0, 0, null);
	            g2d.dispose();

	            BufferedImage frameCopy = new BufferedImage(master.getWidth(), master.getHeight(), BufferedImage.TYPE_INT_ARGB);
	            frameCopy.getGraphics().drawImage(master, 0, 0, null);
	            frames.add(frameCopy);
	        }
	    } 
	    finally 
	    {
	       reader.dispose();
	    }
	        
	return frames;
	}
}