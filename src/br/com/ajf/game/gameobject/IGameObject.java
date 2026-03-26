package br.com.ajf.game.gameobject;

import java.awt.Graphics2D;

/**
 * The Interface IGameObject.
 */
public interface IGameObject
{
	
	/**
	 * Start.
	 */
	void start();
	
	/**
	 * Update.
	 *
	 * @param delta the delta
	 */
	void update(float delta);
	
	/**
	 * Draw.
	 *
	 * @param graphics2d the graphics 2 d
	 * @param playerXOffset the player X offset
	 * @param playerYOffset the player Y offset
	 */
	void draw(Graphics2D graphics2d, int playerXOffset, int playerYOffset);
	
	/**
	 * Gets the width.
	 *
	 * @return the width
	 */
	int getWidth();
	
	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	int getHeight();
	
	/**
	 * Gets the center position X.
	 *
	 * @return the center position X
	 */
	int getCenterPositionX();
	
	/**
	 * Gets the center position Y.
	 *
	 * @return the center position Y
	 */
	int getCenterPositionY();
	
	/**
	 * Gets the max position width.
	 *
	 * @return the max position width
	 */
	int getMaxPositionWidth();
	
	/**
	 * Gets the max position height.
	 *
	 * @return the max position height
	 */
	int getMaxPositionHeight();
}
