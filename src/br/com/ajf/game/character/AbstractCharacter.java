package br.com.ajf.game.character;

import java.awt.Graphics2D;

import br.com.ajf.game.gameobject.GameObject;

/**
 * The Class AbstractCharacter.
 */
public abstract class AbstractCharacter extends GameObject
{
	/** The input. */
	public AbstractCharacterInput input;	
	
	/** The character movement. */
	public AbstractCharacterMovement characterMovement;
	
	public AbstractCharacterHealth health = new AbstractCharacterHealth(6);
		
	/**
	 * Instantiates a new abstract character.
	 */
	public AbstractCharacter()
	{
		super();
	}

	/**
	 * Adds the character input.
	 *
	 * @param input the input
	 */
	public void addCharacterInput(AbstractCharacterInput input)
	{
		this.input = input;
	}
	
	/**
	 * Adds the character movement.
	 *
	 * @param characterMovement the character movement
	 */
	public void addCharacterMovement(AbstractCharacterMovement characterMovement)
	{
		this.characterMovement = characterMovement;
	}
	
	/**
	 * Update.
	 *
	 * @param delta the delta
	 */
	@Override
	public void update(float delta)
	{
		input.updateInputs();
		characterMovement.update(delta,animations);
	}
	
	/**
	 * Prevent movement.
	 *
	 * @param delta the delta
	 */
	public void preventMovement(float delta)
	{
		characterMovement.prevent(delta);
	}
	
	/**
	 * Draw.
	 *
	 * @param graphics2d the graphics 2 d
	 * @param playerXOffset the player X offset
	 * @param playerYOffset the player Y offset
	 */
	@Override
	public void draw(Graphics2D graphics2d,int playerXOffset,int playerYOffset)
	{	
		animations.draw(graphics2d, position.getX() + playerXOffset,
				position.getY() + playerYOffset);
	}
}