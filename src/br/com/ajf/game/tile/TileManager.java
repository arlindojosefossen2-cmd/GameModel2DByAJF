package br.com.ajf.game.tile;

import java.awt.Graphics2D;

import br.com.ajf.game.framework.Game;

/**
 * The Class TileManager.
 */
public final class TileManager implements ITileManager
{
	/** The tiles. */
	private final ITile[] tiles;
	
	/** The data. */
	private final short[][][] data;
	
	/** The tile size. */
	public int tileSize;
	
	/**
	 * Instantiates a new tile manager.
	 *
	 * @param tiles the tiles
	 * @param data the data
	 * @param tileSize the tileSize
	 */
	public TileManager(ITile[] tiles, short[][][] data, int tileSize)
	{
		this.tiles = tiles;
		this.data = data;
		this.tileSize = tileSize;
	}
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
	@Override
	public void draw(Graphics2D graphics2d, Game game, int playerX, int playerY, int playerScreenX, int playerScreenY, int idLayer)
	{
		update(game);
		
		if(idLayer < data.length)
		{	
			for(int r = 0; r < data[idLayer].length; r++)
	    	{
	    		for(int c = 0; c < data[idLayer][0].length; c++)
	        	{
	    			int num = data[idLayer][r][c]-1;
	    			
	    			if(num == -1)
	    				continue;
	    			
	    			final int worldX = c * tileSize;
	            	final int worldY = r * tileSize;
	                
	            	final int screenX = worldX - playerX + playerScreenX;
	            	final int screenY = worldY -  playerY + playerScreenY;
	
	    			if(isPlayerOnScreen(worldX, worldY, this.tileSize,playerX,playerY, playerScreenX, playerScreenY))
	    				graphics2d.drawImage(tiles[num].image(), screenX,screenY, null);
	        	}
	    	}
		}
	}
	
	/**
	 * Draw.
	 *
	 * @param graphics2d the graphics 2 d
	 * @param game the game
	 * @param playerX the player X
	 * @param playerY the player Y
	 * @param playerScreenX the playerScreenX
	 * @param playerScreenY the playerScreenY
	 */
	@Override
	public void draw(Graphics2D graphics2d, Game game, int playerX, int playerY, int playerScreenX, int playerScreenY)
	{
		update(game);

		for (short[][] datum : data)
		{
			for (int r = 0; r < datum.length; r++)
			{
				for (int c = 0; c < datum[0].length; c++)
				{
					int num = datum[r][c] - 1;

					if (num == -1)
						continue;

					final int worldX = c * tileSize;
					final int worldY = r * tileSize;

					final int screenX = worldX - playerX + playerScreenX;
					final int screenY = worldY - playerY + playerScreenY;

					if (isPlayerOnScreen(worldX, worldY, this.tileSize, playerX, playerY, playerScreenX, playerScreenY))
						graphics2d.drawImage(tiles[num].image(), screenX, screenY, null);
				}
			}
		}
	}
	
	/**
	 * Draw.
	 *
	 * @param graphics2d the graphics 2 d
	 * @param game the game
	 * @param playerX the player X
	 * @param playerY the player Y
	 * @param playerScreenX the playerScreenX
	 * @param playerScreenY the playerScreenY
	 * @param idLayers the idLayers
	 */
	@Override
	public void draw(Graphics2D graphics2d, Game game, int playerX, int playerY, int playerScreenX, int playerScreenY, int[] idLayers)
	{
		update(game);
		
		for(int idLayer = 0; idLayer < data.length;idLayer++)
		{	
			if(idLayer < idLayers.length && idLayer == idLayers[idLayer])
			{
				for(int r = 0;r < data[idLayer].length;r++)
		    	{
		    		for(int c = 0;c < data[idLayer][0].length;c++)
		        	{
		    			int num = data[idLayer][r][c]-1;
		    			
		    			if(num == -1)
		    				continue;
		    			
		    			final int worldX = c * tileSize;
		            	final int worldY = r * tileSize;
		                
		            	final int screenX = worldX - playerX + playerScreenX;
		            	final int screenY = worldY -  playerY + playerScreenY;
		
		    			if(isPlayerOnScreen(worldX, worldY, this.tileSize,playerX,playerY, playerScreenX, playerScreenY))
		    				graphics2d.drawImage(tiles[num].image(), screenX,screenY, null);
		        	}
		    	}
			}
		}
	}

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
	@Override
	public boolean isPlayerOnScreen(int worldX, int worldY, int tileSize, int playerX, int playerY, int width, int height)
	{
		return (worldX + 5* tileSize > playerX - width &&
                worldX - 5* tileSize < playerX + width &&
                worldY + 5* tileSize > playerY - height &&
                worldY - 5* tileSize < playerY + height);
	}
	
	/**
	 * Update.
	 *
	 * @param game the game
	 */
	public void update(Game game)
	{
		for (ITile tile : tiles)
		{
			if(tile instanceof TileAnimated)
			{
				((TileAnimated) tile).update(game.delta());
			}
		}
	}
	
	/**
	 * Gets the tiles.
	 *
	 * @return the tiles
	 */
	@Override
	public ITile[] getTiles()
	{
		return tiles;
	}
	
	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	@Override
	public short[][][] getData()
	{
		return data;
	}
}