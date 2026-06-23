package br.com.ajf.game.image;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * The Class BufferedImageLoader.
 */
public final class BufferedImageLoader
{
	
	/**
	 * Instantiates a new buffered image loader.
	 */
	public BufferedImageLoader()
	{
		
	}
	
	/**
	 * Load buffered image.
	 *
	 * @param fileResourcePath the fileResourcePath
	 * @return the buffered image
	 */
	public BufferedImage loadBufferedImage(String fileResourcePath)
	{
		BufferedImage img;
		try
		{
			img = ImageIO.read(Objects.requireNonNull(this.getClass().getResourceAsStream(fileResourcePath)));
		} 
		catch (IOException e)
		{
			throw new RuntimeException(e.getMessage());
		}
	return img;
	}
	
	/**
	 * Load buffered images from sheet.
	 *
	 * @param filename the filename
	 * @param rows the rows
	 * @param cols the cols
	 * @return the buffered image[]
	 */
	public BufferedImage[] loadBufferedImagesFromSheet(String filename,int rows,int cols)
	{
		BufferedImage imgAux = loadBufferedImage(filename);
		return getBufferedImages(rows, cols, imgAux);
	}

	private BufferedImage[] getBufferedImages(int rows, int cols, BufferedImage imgAux)
	{
		BufferedImage[] img = new BufferedImage[rows*cols];

		int sizeW = imgAux.getWidth()/cols;
		int sizeH = imgAux.getHeight()/rows;

		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < cols; j++)
			{
				img[j + i*cols] = imgAux.getSubimage(j*sizeW, i*sizeH, sizeW, sizeH);
			}
		}
		return img;
	}

	/**
	 * Load buffered images from files.
	 *
	 * @param fileResourcePaths the filename
	 * @return the buffered image[]
	 */
	public BufferedImage[] loadBufferedImagesFromFiles(String[] fileResourcePaths)
	{
		BufferedImage[] img = new BufferedImage[fileResourcePaths.length];

		for (int i = 0; i < img.length; i++)
		{
			img[i] = loadBufferedImage(fileResourcePaths[i]);
		}

	return img;
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
		ImageSFX imageSFX = new ImageSFX();	
		return imageSFX.scaleBufferedImage(loadBufferedImage(fileResourcePath), scale);
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
		BufferedImage imgAux = loadScaledBufferedImage(fileResourcePath,scale);
		return getBufferedImages(rows, cols, imgAux);
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
		BufferedImage[] img = new BufferedImage[fileResourcePaths.length];
		ImageSFX imageSFX = new ImageSFX();

		for (int i = 0; i < img.length; i++)
		{
			img[i] = loadBufferedImage(fileResourcePaths[i]);
			img[i] = imageSFX.scaleBufferedImage(img[i], scale);
		}

	return img;
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
		ImageSFX imageSFX = new ImageSFX();
		return imageSFX.getFlippedBufferedImage(loadBufferedImage(fileResourcePath), flipKind);
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
		ImageSFX imageSFX = new ImageSFX();
		return imageSFX.getFlippedBufferedImages(loadBufferedImagesFromSheet(fileResourcePath, rows,cols), flipKind);
	}
	
	/**
	 * Load flipped buffered images from files.
	 *
	 * @param fileResourcePaths the file name
	 * @param flipKind the flip kind
	 * @return the buffered image[]
	 */
	public BufferedImage[] loadFlippedBufferedImagesFromFiles(String[] fileResourcePaths, int flipKind)
	{
		ImageSFX imageSFX = new ImageSFX();
		return imageSFX.getFlippedBufferedImages(loadBufferedImagesFromFiles(fileResourcePaths), flipKind);
	}
	
	/**
	 * Gets the scaled image size.
	 *
	 * @param fileResourcePath the file path
	 * @param scale the scale
	 * @return the scaled image size
	 */
	public ImageSize getScaledImageSize(String fileResourcePath,float scale)
	{
		BufferedImage img = loadScaledBufferedImage(fileResourcePath, scale);
		return new ImageSize(img.getWidth(), img.getHeight());
	}
}
