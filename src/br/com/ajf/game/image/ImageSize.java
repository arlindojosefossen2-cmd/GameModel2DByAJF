package br.com.ajf.game.image;

/**
 * The Class ImageSize.
 *
 * @param width  The width.
 * @param height The height.
 */
public record ImageSize(int width, int height)
{
	/**
	 * Gets the width.
	 *
	 * @return the width
	 */
	@Override
	public int width()
	{
		return width;
	}

	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	@Override
	public int height()
	{
		return height;
	}
}
