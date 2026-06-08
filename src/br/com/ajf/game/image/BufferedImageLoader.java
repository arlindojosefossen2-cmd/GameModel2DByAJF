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
	 * @param filename the filename
	 * @return the buffered image
	 */
	public BufferedImage loadBufferedImage(String filename)
	{
		BufferedImage img;
		try
		{
			img = ImageIO.read(Objects.requireNonNull(this.getClass().getResource(filename)));
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
	 * @param filename the filename
	 * @return the buffered image[]
	 */
	public BufferedImage[] loadBufferedImagesFromFiles(String[] filename)
	{
		BufferedImage[] img = new BufferedImage[filename.length];
		
		try
		{
			for (int i = 0; i < img.length; i++)
			{
				img[i] = ImageIO.read(Objects.requireNonNull(this.getClass().getResourceAsStream(filename[i])));
			}
		} 
		catch (IOException e)
		{
			throw new RuntimeException(e.getMessage());
		}
	return img;
	}
	
	/**
	 * Load scaled buffered image.
	 *
	 * @param filename the filename
	 * @param scale the scale
	 * @return the buffered image
	 */
	public BufferedImage loadScaledBufferedImage(String filename,float scale)
	{	
		ImageSFX imageSFX = new ImageSFX();	
		return imageSFX.scaleBufferedImage(loadBufferedImage(filename), scale);
	}
	
	/**
	 * Load scaled buffered images from sheet.
	 *
	 * @param filename the filename
	 * @param rows the rows
	 * @param cols the cols
	 * @param scale the scale
	 * @return the buffered image[]
	 */
	public BufferedImage[] loadScaledBufferedImagesFromSheet(String filename,int rows,int cols,float scale)
	{
		BufferedImage imgAux = loadScaledBufferedImage(filename,scale);
		return getBufferedImages(rows, cols, imgAux);
	}
	
	/**
	 * Load scaled buffered images from files.
	 *
	 * @param filename the filename
	 * @param scale the scale
	 * @return the buffered image[]
	 */
	public BufferedImage[] loadScaledBufferedImagesFromFiles(String[] filename,float scale)
	{
		BufferedImage[] img = new BufferedImage[filename.length];
		ImageSFX imageSFX = new ImageSFX();
		
		try
		{
			for (int i = 0; i < img.length; i++)
			{
				img[i] = ImageIO.read(Objects.requireNonNull(this.getClass().getResourceAsStream(filename[i])));
				img[i] = imageSFX.scaleBufferedImage(img[i], scale);
			}
		} 
		catch (IOException e)
		{
			throw new RuntimeException(e.getMessage());
		}
	return img;
	}
	
	/**
	 * Load flipped buffered image.
	 *
	 * @param fileName the file name
	 * @param flipKind the flip kind
	 * @return the buffered image
	 */
	public BufferedImage loadFlippedBufferedImage(String fileName, int flipKind)
	{
		ImageSFX imageSFX = new ImageSFX();
		return imageSFX.getFlippedBufferedImage(loadBufferedImage(fileName), flipKind);
	}
	
	/**
	 * Load flipped buffered images from sheet.
	 *
	 * @param fileName the file name
	 * @param rows the rows
	 * @param cols the cols
	 * @param flipKind the flip kind
	 * @return the buffered image[]
	 */
	public BufferedImage[] loadFlippedBufferedImagesFromSheet(String fileName,int rows,int cols, int flipKind)
	{
		ImageSFX imageSFX = new ImageSFX();
		return imageSFX.getFlippedBufferedImages(loadBufferedImagesFromSheet(fileName, rows,cols), flipKind);
	}
	
	/**
	 * Load flipped buffered images from files.
	 *
	 * @param fileName the file name
	 * @param flipKind the flip kind
	 * @return the buffered image[]
	 */
	public BufferedImage[] loadFlippedBufferedImagesFromFiles(String[] fileName, int flipKind)
	{
		ImageSFX imageSFX = new ImageSFX();
		return imageSFX.getFlippedBufferedImages(loadBufferedImagesFromFiles(fileName), flipKind);
	}
	
	/**
	 * Gets the scaled image size.
	 *
	 * @param filePath the file path
	 * @param scale the scale
	 * @return the scaled image size
	 */
	public ImageSize getScaledImageSize(String filePath,float scale)
	{
		BufferedImage img = loadScaledBufferedImage(filePath, scale);
		return new ImageSize(img.getWidth(), img.getHeight());
	}
}