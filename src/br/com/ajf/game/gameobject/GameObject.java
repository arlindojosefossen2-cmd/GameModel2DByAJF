package br.com.ajf.game.gameobject;

import br.com.ajf.game.animation.IAnimationManager;
import br.com.ajf.game.collision.Collider;
import br.com.ajf.game.math.Vector2I;
import br.com.ajf.game.moviment.FourDirections;

/**
 * The Class GameObject.
 */
public abstract class GameObject implements IGameObject
{
	/** The collider. */
	public Collider collider;

	/** The solid area X. */
	public int solidAreaX;

	/** The solid area Y. */
	public int solidAreaY;

	/** The animations. */
	public IAnimationManager animations;
	
	/** The position. */
	public Vector2I position = new Vector2I(0, 0);
	
	/** The velocity. */
	public Vector2I velocity = new Vector2I(1,1);
	
	/** The solid. */
	public boolean solid = true;
	
	/** The moving. */
	public boolean moving;
	
	/** The collision. */
	public boolean collision;
	
	/** The direction. */
	public FourDirections direction = FourDirections.DOWN;

	/** The dialog. */
	public boolean dialog;
	
	/** The name. */
	public String name;
	
	/**
	 * Instantiates a new game object.
	 */
	public GameObject()
	{
		super();
	}

	/**
	 * Gets the width.
	 *
	 * @return the width
	 */
	@Override
	public int getWidth()
	{
		return this.animations.getWidth();
	}

	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	@Override
	public int getHeight()
	{
		return this.animations.getHeight();
	}

	/**
	 * Gets the center position X.
	 *
	 * @return the center position X
	 */
	@Override
	public int getCenterPositionX()
	{
		return this.position.getX()+this.animations.getWidth()/2;
	}

	/**
	 * Gets the center position Y.
	 *
	 * @return the center position Y
	 */
	@Override
	public int getCenterPositionY()
	{
		return this.position.getY()+this.animations.getHeight()/2;
	}

	/**
	 * Gets the max position width.
	 *
	 * @return the max position width
	 */
	@Override
	public int getMaxPositionWidth()
	{
		return this.position.getX()+this.animations.getWidth();
	}

	/**
	 * Gets the max position height.
	 *
	 * @return the max position height
	 */
	@Override
	public int getMaxPositionHeight()
	{
		return this.position.getY()+this.animations.getHeight();
	}
}