package br.com.ajf.game.player;

import java.awt.Graphics2D;

import br.com.ajf.game.character.AbstractCharacter;
import br.com.ajf.game.collision.Collider;

/**
 * The Class Player.
 */
public abstract class Player extends AbstractCharacter
{
	/** The Constant SCREEN_X. */
	public static int SCREEN_X = 0;
	
	/** The Constant SCREEN_Y. */
	public static int SCREEN_Y = 0;
	
	/** The draw UI. */
	protected IDrawPlayerUI drawUI;
	
	/** The dialog area. */
	public final Collider dialogArea = new Collider(0 , 0, 0, 0, 64, 64, "Dialog");
	
	/**
	 * Instantiates a new player.
	 */
	public Player()
	{
		super();
	}
	
	/**
	 * Draw UI.
	 *
	 * @param graphics2d the graphics 2 d
	 */
	public abstract void drawUI(Graphics2D graphics2d);
}