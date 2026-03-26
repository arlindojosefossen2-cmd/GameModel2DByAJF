package br.com.ajf.game.framework;

/**
 * Author A.J.F.
 * @version 1.0
 * 30 June 2025
 */
public sealed interface IGameWindow permits GameWindow
{
	
	/**
	 * Instantiates the window attributes.
	 *
	 * @param gamePanel the game panel
	 */
	void init(GamePanel gamePanel);
	
	/**
	 * Sets the icon.
	 *
	 * @param path the new icon
	 */
	void setIcon(String path);
	
	/**
	 * Sets the tile.
	 *
	 * @param title the new tile
	 */
	void setTitle(String title);
	
	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	String getTitle();
}