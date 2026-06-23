package br.com.ajf.game.image;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * The Class LoadImage.
 */
public final class LoadImage
{
	/**
	 * Instantiates a new load image.
	 */
	public LoadImage()
	{
		
	}
	
	/**
	 * Load image.
	 *
	 * @param fileResourcePath the fileResourcePath
	 * @return the image
	 */
	public Image loadImage(String fileResourcePath)
	{
        try
		{
            return ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(fileResourcePath)));
        }
		catch (IOException e)
		{
            throw new RuntimeException(e);
        }
    }
	
	/**
	 * Load images from files.
	 *
	 * @param fileResourcePaths the fileResourcePaths
	 * @return the image[]
	 */
	public Image[] loadImagesFromFiles(String[] fileResourcePaths)
	{
		Image[] img = new Image[fileResourcePaths.length];
		
		for (int i = 0; i < fileResourcePaths.length; i++)
		{
			img[i] = loadImage(fileResourcePaths[i]);
		}

		return img;
	}
	
	/**
	 * Load images from sheet.
	 *
	 * @param fileResourcePath the fileResourcePath
	 * @param rows the rows
	 * @param cols the cols
	 * @return the image[]
	 */
	public Image[] loadImagesFromSheet(String fileResourcePath,int rows,int cols)
	{
		ImageIcon iconAux  = new ImageIcon(loadImage(fileResourcePath));
		Image[] img = new Image[rows*cols];
		
		int sizeW = iconAux.getIconWidth()/cols;
		int sizeH = iconAux.getIconHeight()/rows;
		
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < cols; j++)
			{
				img[j + i*cols] = ((BufferedImage) iconAux.getImage()).getSubimage(j*sizeW, i*sizeH, sizeW, sizeH); 
			}
		}
		
		return img;
	}
	
	/**
	 * Load scaled image.
	 *
	 * @param fileResourcePath the fileResourcePath
	 * @param scale the scale
	 * @return the image
	 */
	public Image loadScaledImage(String fileResourcePath, float scale)
	{
		ImageSFX imageSFX = new ImageSFX();
		return imageSFX.scaleImage(loadImage(fileResourcePath), scale);
	}
	
	/**
	 * Load scaled images from files.
	 *
	 * @param fileResourcePaths the fileResourcePaths
	 * @param scale the scale
	 * @return the image[]
	 */
	public Image[] loadScaledImagesFromFiles(String[] fileResourcePaths, float scale)
	{
		Image[] img = loadImagesFromFiles(fileResourcePaths);
		ImageSFX imageSFX = new ImageSFX();
		return imageSFX.scaleImages(img, scale);
	}
	
	/**
	 * Load scaled images from sheet.
	 *
	 * @param fileResourcePath the fileResourcePath
	 * @param rows the rows
	 * @param cols the cols
	 * @param scale the scale
	 * @return the image[]
	 */
	public Image[] loadScaledImagesFromSheet(String fileResourcePath,int rows,int cols, float scale)
	{
		Image[] img = loadImagesFromSheet(fileResourcePath, rows, cols);
		ImageSFX imageSFX = new ImageSFX();
		return imageSFX.scaleImages(img, scale);
	}
}