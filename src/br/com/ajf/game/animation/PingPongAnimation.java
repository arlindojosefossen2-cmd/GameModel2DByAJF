package br.com.ajf.game.animation;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import br.com.ajf.game.framework.Game;

/**
 * The Class PingPongAnimation.
 */
public final class PingPongAnimation implements IAnimation
{
	/** The index. */
	private int index;
	
	/** The interval. */
	private final float interval;
	
	/** The counter. */
	private float counter;
	
	/** The images. */
	private final BufferedImage[] images;

	/** The looping. */
	private final boolean looping;
	
	/** the pingPong. */
	private boolean pingPong;
	
	/** the control increment and decrement index of frames. */
	private int controlFrameIndex;
	
	/**
	 * Instantiates a new ping pong animation.
	 *
	 * @param images the images
	 * @param interval the interval
	 */
	public PingPongAnimation(final BufferedImage[] images, final float interval)
	{
		this(images, interval,true);
	}
	
	/**
	 * Instantiates a new ping pong animation.
	 *
	 * @param images the images
	 * @param interval the interval
	 * @param looping the looping
	 */
	public PingPongAnimation(final BufferedImage[] images, final float interval, final boolean looping)
	{
		this.images = images;
		this.interval = interval;
		this.looping = looping;
		this.pingPong = true;
	}
	
	/**
	 * Instantiates a new animation.
	 *
	 * @param path the path
	 * @param numberOfRows the rows
	 * @param numberOfCols the cols
	 * @param interval the interval
	 * @param scale the scale
	 * @param looping the looping
	 */
	public PingPongAnimation(final String path,final int numberOfRows,final int numberOfCols,final float interval,final float scale,final boolean looping)
	{
		this.interval = interval;
		this.images = Game.LOADER.loadScaledBufferedImagesFromSheet(path,numberOfRows, numberOfCols, scale);
		this.looping = looping;
	}
	
	/**
	 * Update.
	 *
	 * @param delta the delta
	 */
	@Override
	public void update(float delta)
	{	
		if(!looping && index == images.length - 1)
				return;
		
		counter += delta;
			
		if(counter >= interval)
		{	
			if(index <= 0)
			{
				controlFrameIndex = 1;
			}
			else if(index >= images.length-1)
			{
				controlFrameIndex = 0;
			}
				
			if(controlFrameIndex == 1)
			{
				index++;
			}
			else if(controlFrameIndex == 0)
			{
				index--;
			}
				
			counter = 0;
		}
	}

	/**
	 * Draw.
	 *
	 * @param graphics2d the graphics 2 d
	 * @param xPos the x pos
	 * @param yPos the y pos
	 */
	@Override
	public void draw(final Graphics2D graphics2d,final int xPos,final int yPos)
	{
		graphics2d.drawImage(this.images[this.index], xPos, yPos, null);
	}

	/**
	 * Checks if is finished.
	 *
	 * @return true, if is finished
	 */
	@Override
	public boolean isFinished()
	{
		return index == images.length - 1;
	}

	/**
	 * Reset.
	 */
	@Override
	public void reset()
	{
		index = 0;
	}

	/**
	 * Checks if it is looping.
	 *
	 * @return true, if it is looping
	 */
	@Override
	public boolean isLooping()
	{
		return looping;
	}
	
	/**
	 * Checks if is ping pong.
	 *
	 * @return true, if is ping pong
	 */
	@Override
	public boolean isPingPong()
	{
		return pingPong;
	}
	
	/**
	 * Gets the index.
	 *
	 * @return the index
	 */
	@Override
	public int getIndex()
	{
		return index;
	}

	/**
	 * Gets the width.
	 *
	 * @return the width
	 */
	@Override
	public int getWidth()
	{
		return this.images[index].getWidth();
	}

	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	@Override
	public int getHeight()
	{
		return this.images[index].getHeight();
	}
}