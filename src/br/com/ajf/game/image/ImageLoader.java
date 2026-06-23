package br.com.ajf.game.image;

import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 * The Class ImageLoader.
 */
public final class ImageLoader
{
	/**
	 * Instantiates a new image loader.
	 */
	public ImageLoader()
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
		return new LoadImage().loadImage(fileResourcePath);
	}
	
	/**
	 * Load images from files.
	 *
	 * @param fileResourcePaths the fileResourcePaths
	 * @return the image[]
	 */
	public Image[] loadImagesFromFiles(String[] fileResourcePaths)
	{
		return new LoadImage().loadImagesFromFiles(fileResourcePaths);
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
		return new LoadImage().loadImagesFromSheet(fileResourcePath, rows, cols);
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
		return new LoadImage().loadScaledImage(fileResourcePath, scale);
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
		return new LoadImage().loadScaledImagesFromFiles(fileResourcePaths, scale);
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
		return new LoadImage().loadScaledImagesFromSheet(fileResourcePath, rows, cols, scale);
	}
	
	/**
	 * Load buffered image.
	 *
	 * @param fileResourcePath the fileResourcePath
	 * @return the buffered image
	 */
	public BufferedImage loadBufferedImage(String fileResourcePath)
	{
		return new BufferedImageLoader().loadBufferedImage(fileResourcePath);
	}
	
	/**
	 * Load buffered images from sheet.
	 *
	 * @param fileResourcePath the fileResourcePath
	 * @param rows the rows
	 * @param cols the cols
	 * @return the buffered image[]
	 */
	public BufferedImage[] loadBufferedImagesFromSheet(String fileResourcePath,int rows,int cols)
	{
		return new BufferedImageLoader().loadBufferedImagesFromSheet(fileResourcePath, rows, cols);
	}
	
	/**
	 * Load buffered images from files.
	 *
	 * @param fileResourcePaths the fileResourcePaths
	 * @return the buffered image[]
	 */
	public BufferedImage[] loadBufferedImagesFromFiles(String[] fileResourcePaths)
	{
		return new BufferedImageLoader().loadBufferedImagesFromFiles(fileResourcePaths);
	}
	
	/**
	 * Load scaled buffered image.
	 *
	 * @param fileResourcePath the fileResourcePath
	 * @param scale the scale
	 * @return the buffered image
	 */
	public BufferedImage loadScaledBufferedImage(String fileResourcePath,float scale)
	{	
		return new BufferedImageLoader().loadScaledBufferedImage(fileResourcePath, scale);
	}
	
	/**
	 * Load scaled buffered images from sheet.
	 *
	 * @param fileResourcePath the fileResourcePath
	 * @param rows the rows
	 * @param cols the cols
	 * @param scale the scale
	 * @return the buffered image[]
	 */
	public BufferedImage[] loadScaledBufferedImagesFromSheet(String fileResourcePath,int rows,int cols,float scale)
	{
		return new BufferedImageLoader().loadScaledBufferedImagesFromSheet(fileResourcePath, rows, cols, scale);
	}
	
	/**
	 * Load scaled buffered images from files.
	 *
	 * @param fileResourcePaths the fileResourcePaths
	 * @param scale the scale
	 * @return the buffered image[]
	 */
	public BufferedImage[] loadScaledBufferedImagesFromFiles(String[] fileResourcePaths,float scale)
	{
		return new BufferedImageLoader().loadScaledBufferedImagesFromFiles(fileResourcePaths, scale);
	}
	
	/**
	 * Load flipped buffered image.
	 *
	 * @param fileResourcePath the file name
	 * @param flipKind the flip kind
	 * @return the buffered image
	 */
	public BufferedImage loadFlippedBufferedImage(String fileResourcePath, int flipKind)
	{
		return new BufferedImageLoader().loadFlippedBufferedImage(fileResourcePath, flipKind);
	}
	
	/**
	 * Load flipped buffered images from sheet.
	 *
	 * @param fileResourcePath the file name
	 * @param rows the rows
	 * @param cols the cols
	 * @param flipKind the flip kind
	 * @return the buffered image[]
	 */
	public BufferedImage[] loadFlippedBufferedImagesFromSheet(String fileResourcePath,int rows,int cols, int flipKind)
	{
		return new BufferedImageLoader().loadFlippedBufferedImagesFromSheet(fileResourcePath, rows, cols, flipKind);
	}
	
	/**
	 * Load flipped buffered images from files.
	 * @param fileResourcePaths the file name
	 * @param flipKind the flip kind
	 * @return the buffered image[]
	 */
	public BufferedImage[] loadFlippedBufferedImagesFromFiles(String[] fileResourcePaths,int flipKind)
	{
		return new BufferedImageLoader().loadFlippedBufferedImagesFromFiles(fileResourcePaths, flipKind);
	}
	
	/**
	 * Convert image to buffered image.
	 *
	 * @param img the img
	 * @return the buffered image
	 */
	public BufferedImage convertImageToBufferedImage(Image img)
	{	
		return new ImageConvert().convertImageToBufferedImage(img);
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
		return new ImageConvert().convertImageToBufferedImage(img, width, height);
	}
	
	/**
	 * Gets the scaled image size.
	 *
	 * @param fileResourcePath the file path
	 * @param scale the scale
	 * @return the scaled image size or a default 'new ImageSize(1,1)';
	 */
	public ImageSize getScaledImageSize(String fileResourcePath,float scale)
	{
		if(scale > 0)
		{
			return new BufferedImageLoader().getScaledImageSize(fileResourcePath, scale);
		}
		return new ImageSize(1, 1);
	}
}