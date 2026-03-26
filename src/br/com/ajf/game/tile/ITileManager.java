package br.com.ajf.game.tile;

import java.awt.Graphics2D;

import br.com.ajf.game.framework.Game;

/**
 * The Interface ITileManager.
 */
public interface ITileManager
{
	/**
	 * Draw.
	 *
	 * @param graphics2d the graphics 2 d
	 * @param game the game
	 * @param playerX the player X
	 * @param playerY the player Y
	 * @param playerScreenX the playerScreenX
	 * @param playerScreenY the playerScreenY
	 * @param idLayer the idLayer
	 */
	void draw(Graphics2D graphics2d, Game game, int playerX, int playerY, int playerScreenX, int playerScreenY, int idLayer);
	
	/**
	 * Draw.
	 *
	 * @param graphics2d the graphics 2 d
	 * @param playerX the player X
	 * @param playerY the player Y
	 * @param playerScreenX the playerScreenX
	 * @param playerScreenY the playerScreenY
	 */
	void draw(Graphics2D graphics2d, Game game, int playerX, int playerY, int playerScreenX, int playerScreenY);
	
	
	/**
	 * Draw.
	 *
	 * @param graphics2d the graphics 2 d
	 * @param playerX the player X
	 * @param playerY the player Y
	 * @param playerScreenX the playerScreenX
	 * @param playerScreenY the playerScreenY
	 * @param idLayers the idLayers
	 */
	void draw(Graphics2D graphics2d, Game game, int playerX, int playerY, int playerScreenX, int playerScreenY, int[] idLayers);

	/**
	 * Checks if is player ON screen.
	 *
	 * @param worldX the world X
	 * @param worldY the world Y
	 * @param tileSize the tileSize
	 * @param playerX the player X
	 * @param playerY the player Y
	 * @param width the width
	 * @param height the height
	 * @return true, if is player ON screen
	 */
	boolean isPlayerOnScreen(int worldX, int worldY, int tileSize, int playerX, int playerY, int width, int height);
	
	/**
	 * Gets the tiles.
	 *
	 * @return the tiles
	 */
	ITile[] getTiles();
	
	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	short[][][] getData();
}
