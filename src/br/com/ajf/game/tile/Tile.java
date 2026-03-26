package br.com.ajf.game.tile;

import java.awt.image.BufferedImage;

/**
 * The Class Tile.
 *
 * @param id    The id.
 * @param solid The solid.
 * @param image The image.
 */
public record Tile(int id, boolean solid, BufferedImage image) implements ITile
{
	/**
	 * Instantiates a new tile.
	 *
	 * @param id    the id
	 * @param solid the solid
	 * @param image the image
	 */
	public Tile
	{
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
	 * Gets the image.
	 *
	 * @return the image
	 */
	@Override
	public BufferedImage image()
	{
		return image;
	}
}