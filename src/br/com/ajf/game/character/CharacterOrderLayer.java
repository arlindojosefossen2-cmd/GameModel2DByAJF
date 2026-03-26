package br.com.ajf.game.character;

import java.util.Comparator;

/**
 * The Class CharacterOrderLayer.
 */
public final class CharacterOrderLayer implements Comparator<AbstractCharacter>
{
	/**
	 * Instantiates a new character order layer.
	 */
	public CharacterOrderLayer()
	{
		super();
	}

	/**
	 * Compare.
	 *
	 * @param o1 the o 1
	 * @param o2 the o 2
	 * @return the int
	 */
	@Override
	public int compare(AbstractCharacter o1, AbstractCharacter o2)
	{
		if(o1 == null || o2 == null)
		{
			return -1;
		}
		
		return (o1.getMaxPositionHeight() >= o2.getMaxPositionHeight()) ? 1 : -1;
	}
}