package br.com.ajf.game.tile;

import java.awt.image.BufferedImage;

/**
 * The Interface ITile.
 */
public interface ITile
{
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	int id();
	
	/**
	 * Checks if is solid.
	 *
	 * @return true, if is solid
	 */
	boolean solid();
	
	/**
	 * Gets the image.
	 *
	 * @return the image
	 */
	BufferedImage image();
}