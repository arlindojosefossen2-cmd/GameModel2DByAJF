package br.com.ajf.game.tile;
import java.awt.image.BufferedImage;

import br.com.ajf.game.framework.Game;

/**
 * The Class TileAnimated.
 */
public final class TileAnimated implements ITile
{
	/** The id. */
	private final int id;
	
	/** The solid. */
	private final boolean solid;
	
	/** The index. */
	private int index;
	
	/** The interval. */
	private final float interval;
	
	/** The counter. */
	private float counter;
	
	/** The images. */
	private final BufferedImage[] images;
	
	/**
	 * Instantiates a new tile animated.
	 *
	 * @param id the id
	 * @param solid the solid
	 * @param images the images
	 * @param interval the interval
	 */
	public TileAnimated(int id, boolean solid,BufferedImage[] images, float interval)
	{
		this.id = id;
		this.solid = solid;
		this.interval = interval;
		this.images = images;	
	}
	
	/**
	 * Instantiates a new tile animated.
	 *
	 * @param id the id
	 * @param solid the solid
	 * @param path the path
	 * @param tileSize the tile size
	 * @param numberOfFrames the number of frames
	 * @param scale the scale
	 * @param interval the interval
	 */
	public TileAnimated(int id, boolean solid,String path, int tileSize, int numberOfFrames, float scale, float interval)
	{
		this.id = id;
		this.solid = solid;
		this.interval = interval;
		final BufferedImage aux = Game.LOADER.loadScaledBufferedImage(path, scale);
		
		images = new BufferedImage[numberOfFrames];
		
		for(int col = 0;col < images.length;col++)
		{
			images[col] = aux.getSubimage(col * tileSize,0,tileSize, tileSize);
		}
		
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Override
	public int id()
	{
		return id;
	}
	
	/**
	 * Checks if is solid.
	 *
	 * @return true, if is solid
	 */
	@Override
	public boolean solid()
	{
		return solid;
	}
	
	/**
	 * Update.
	 *
	 * @param delta the delta
	 */
	public void update(float delta)
	{
		counter+=delta;
		
		if(counter >= interval)
		{
			counter = 0;
			index++;
			
			if(index >= images.length)
				index = 0;
		}
	}
	
	/**
	 * Gets the image.
	 *
	 * @return the image
	 */
	@Override
	public BufferedImage image()
	{
		return images[index];
	}
}