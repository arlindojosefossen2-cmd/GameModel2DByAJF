package br.com.ajf.game.character;

import br.com.ajf.game.animation.IAnimationManager;

/**
 * The Class AbstractCharacterMovement.
 */
public abstract class AbstractCharacterMovement
{
	/** The input. */
	public final AbstractCharacter character;
	
	/**
	 * Instantiates a new abstract character movement.
	 *
	 * @param character the character
	 */
	public AbstractCharacterMovement(AbstractCharacter character)
	{
		this.character = character;
	}

	/**
	 * Update.
	 *
	 * @param delta the delta
	 * @param animations the animations
	 */
	protected abstract void update(float delta,IAnimationManager animations);

	/**
	 * Prevent.
	 *
	 * @param delta the delta
	 */
	protected abstract void prevent(float delta);
}