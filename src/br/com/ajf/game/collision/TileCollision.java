package br.com.ajf.game.collision;

import br.com.ajf.game.gameobject.AbstractGameObject;
import br.com.ajf.game.moviment.IDirection;
import br.com.ajf.game.tile.TileManager;
/**
 * The Class TileCollision.
 */
public final class TileCollision
{
	
	
	/**
	 * Instantiates a new tile collision.
	 */
	public TileCollision()
	{
		super();
	}

	/**
	 * Check tile.
	 *
	 * @param gameObject the gameObject
	 * @param tManager the t manager
	 *
	 */
	public void checkTile(final AbstractGameObject gameObject,final TileManager tManager)
	{
		int gameObjectLeftWorldX = gameObject.getXPos() + gameObject.getSolidArea().getX();
		int gameObjectRightWorldX = gameObject.getXPos() + gameObject.getSolidArea().getX()+ gameObject.getSolidArea().getWidth();
		
		int gameObjectTopWorldY = gameObject.getYPos() + gameObject.getSolidArea().getY();
		int gameObjectBottomWorldY = gameObject.getYPos() + gameObject.getSolidArea().getY() + gameObject.getSolidArea().getHeight();
		
		int gameobjectLeftCollun = gameObjectLeftWorldX / tManager.tileSize;
		int gameobjectRightCollun = gameObjectRightWorldX / tManager.tileSize;
		int gameobjectTopRow = gameObjectTopWorldY / tManager.tileSize;
		int gameobjectBottomRow = gameObjectBottomWorldY / tManager.tileSize;
		
		int tileId1 = 0 ;
		int tileId2 = 0 ;	
		
		for(int layerid = 0; layerid < tManager.getData().length;layerid++)
		{
			switch(gameObject.getDirection())
			{
				case IDirection.UP:
					gameobjectTopRow = (gameObjectTopWorldY - gameObject.getSpeed()) / tManager.tileSize;
					tileId1 = tManager.getData()[layerid][gameobjectTopRow][gameobjectLeftCollun]-1;
		            tileId2 = tManager.getData()[layerid][gameobjectTopRow][gameobjectRightCollun]-1;
    
					break;
				case IDirection.DOWN:
					gameobjectBottomRow = (gameObjectBottomWorldY + gameObject.getSpeed()) / tManager.tileSize;
					tileId1 = tManager.getData()[layerid][gameobjectBottomRow][gameobjectLeftCollun]-1;
		            tileId2 = tManager.getData()[layerid][gameobjectBottomRow][gameobjectRightCollun]-1;
		    		       
					break;
				case IDirection.LEFT:
					gameobjectLeftCollun = (gameObjectLeftWorldX - gameObject.getSpeed()) / tManager.tileSize;
					tileId1 = tManager.getData()[layerid][gameobjectTopRow][gameobjectLeftCollun]-1;
		            tileId2 = tManager.getData()[layerid][gameobjectBottomRow][gameobjectRightCollun]-1;
		
					break;
				case IDirection.RIGHT:
					gameobjectRightCollun = (gameObjectRightWorldX + gameObject.getSpeed()) / tManager.tileSize;
					tileId1 = tManager.getData()[layerid][gameobjectTopRow][gameobjectLeftCollun]-1;
		            tileId2 = tManager.getData()[layerid][gameobjectBottomRow][gameobjectRightCollun]-1;
				
					break;
			}
			
			if(tileId1 ==  -1)
			{
				if(tileId2 != -1)
					if(tManager.getTiles()[tileId2].solid())
				    {
						gameObject.setCollision(true);
				    } 
			}
			else if(tileId2 == -1)
			{
				if(tManager.getTiles()[tileId1].solid())
				{
					gameObject.setCollision(true);
				}
			}
			else if(tManager.getTiles()[tileId2].solid() || tManager.getTiles()[tileId1].solid())
			{
				gameObject.setCollision(true);
			} 
		}
	}
	
	/**
	 * Check tile by layer.
	 *
	 * @param gameobject the gameobject
	 * @param tManager the t manager
	 * @param layerid the layerid
	 */
	public void checkTileByLayer(final AbstractGameObject gameobject,final TileManager tManager, int layerid)
	{
		int gameobjectLeftWorldX = gameobject.getXPos() + gameobject.getSolidArea().getX();
		int gameobjectRightWorldX = gameobject.getXPos() + gameobject.getSolidArea().getX()+ gameobject.getSolidArea().getWidth();
		
		int gameobjectTopWorldY = gameobject.getYPos() + gameobject.getSolidArea().getY();
		int gameobjectBottomWorldY = gameobject.getYPos() + gameobject.getSolidArea().getY() + gameobject.getSolidArea().getHeight();
		
		int gameobjectLeftCollun = gameobjectLeftWorldX / tManager.tileSize;
		int gameobjectRightCollun = gameobjectRightWorldX / tManager.tileSize;
		int gameobjectTopRow = gameobjectTopWorldY / tManager.tileSize;
		int gameobjectBottomRow = gameobjectBottomWorldY / tManager.tileSize;
		
		int tileId1 = 0  ;
		int tileId2 = 0  ;	
	
		switch(gameobject.getDirection())
		{
				case IDirection.UP:
					gameobjectTopRow = (gameobjectTopWorldY - gameobject.getSpeed()) / tManager.tileSize;
					tileId1 = tManager.getData()[layerid][gameobjectTopRow][gameobjectLeftCollun]-1;
		            tileId2 = tManager.getData()[layerid][gameobjectTopRow][gameobjectRightCollun]-1;
    
					break;
				case IDirection.DOWN:
					gameobjectBottomRow = (gameobjectBottomWorldY + gameobject.getSpeed()) / tManager.tileSize;
					tileId1 = tManager.getData()[layerid][gameobjectBottomRow][gameobjectLeftCollun]-1;
		            tileId2 = tManager.getData()[layerid][gameobjectBottomRow][gameobjectRightCollun]-1;
		    		       
					break;
				case IDirection.LEFT:
					gameobjectLeftCollun = (gameobjectLeftWorldX - gameobject.getSpeed()) / tManager.tileSize;
					tileId1 = tManager.getData()[layerid][gameobjectTopRow][gameobjectLeftCollun]-1;
		            tileId2 = tManager.getData()[layerid][gameobjectBottomRow][gameobjectRightCollun]-1;
		
					break;
				case IDirection.RIGHT:
					gameobjectRightCollun = (gameobjectRightWorldX + gameobject.getSpeed()) / tManager.tileSize;
					tileId1 = tManager.getData()[layerid][gameobjectTopRow][gameobjectLeftCollun]-1;
		            tileId2 = tManager.getData()[layerid][gameobjectBottomRow][gameobjectRightCollun]-1;
				
					break;
		}
			
		if(tileId1 ==  -1)
		{
			if(tileId2 != -1)
				if(tManager.getTiles()[tileId2].solid())
			    {
					gameobject.setCollision(true);
			    } 
		}
		else if(tileId2 == -1)
		{
			if(tManager.getTiles()[tileId1].solid())
			{
				gameobject.setCollision(true);
			}
		}
		else if(tManager.getTiles()[tileId2].solid() || tManager.getTiles()[tileId1].solid())
		{
			gameobject.setCollision(true);
		} 
	}
	
}