package br.com.ajf.game.util;

/**
 * The Class FrameRate.
 */
public final class FrameRate
{
	/** The frame rate. */
	private String frameRate;
	
	/** The lasTime. */
	private long lasTime;
	
	/** The delta. */
	private long delta;
	
	/** The frame counter. */
	private int frameCounter;
	
	/**
	 * Instantiates a new frame rate.
	 */
	public FrameRate()
	{
		
	}

	/**
	 * Initialize.
	 */
	public void initialize()
	{
		lasTime = System.currentTimeMillis();
		frameRate = "";
	}

	/**
	 * Calculate.
	 */
	public void calculate()
	{
		long current = System.currentTimeMillis();
		delta += current - lasTime;
		lasTime = current;
		
		frameCounter++;
		
		if(delta > 1000)
		{
			delta -= 1000;
			frameRate = String.format(String.valueOf(frameCounter));
			frameCounter = 0;
		}
	}

	/**
	 * Gets the frame rate.
	 *
	 * @return the frame rate
	 */
	public String getFrameRate()
	{
		return frameRate;
	}
}