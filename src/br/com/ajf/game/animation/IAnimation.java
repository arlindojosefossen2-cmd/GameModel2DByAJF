package br.com.ajf.game.animation;

import java.awt.Graphics2D;

/**
 * Author A.J.F.
 * @version 1.0
 * 17 June 2025
 */
public interface IAnimation
{
	/** The Constant NORMAL_ANIMATION. */
	String NORMAL_ANIMATION = "normal_animation";
	
	/** The Constant PING_PONG_ANIMATION. */
	String PING_PONG_ANIMATION = "ping_pong_animation";
	
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
	 * @param xPos the x position to the animation
	 * @param yPos the y position to the animation
	 */
	void draw(Graphics2D graphics2d, int xPos, int yPos);
	
	/**
	 * Checks if is finished.
	 *
	 * @return true, if is finished
	 */
	boolean isFinished();
	
	/**
	 * Reset.
	 */
	void reset();
	
	/**
	 * Checks if it is looping.
	 *
	 * @return true, if it is looping
	 */
	boolean isLooping();

	/**
	 * Checks if is ping pong.
	 *
	 * @return true, if is ping pong
	 */
	boolean isPingPong();
	
	/**
	 * Gets the index.
	 *
	 * @return the index
	 */
	int getIndex();
	
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
}