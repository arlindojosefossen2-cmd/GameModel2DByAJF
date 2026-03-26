package br.com.ajf.game.constant;

/**
 * The Class GameConstants.
 */
public final class GameConstants
{
	/**
	 *Can't instantiate a new game constants.
	 */
	private GameConstants()
	{
		
	}
	
	/** The Constant ORIGINAL_TILE SIZE_16. */
	public static final int ORIGINAL_TILE_SIZE_16 = 16;
	
	/** The Constant SCALE. */
	public static final float SCALE = 3;
	
	/** The Constant TILE SIZE. */
	public static final int TILE_SIZE = (int) (ORIGINAL_TILE_SIZE_16*SCALE);
	
	/** The Constant MAX_ROWS. */
	public static final int MAX_ROWS = 18;
	
	/** The Constant MAX_COLUMN. */
	public static final int MAX_COLUMN = 10;
	
	/** The Constant SCREEN_WIDTH. */
	public static final int SCREEN_WIDTH = MAX_ROWS*TILE_SIZE;
	//column
	/** The Constant SCREEN_HEIGHT. */
	public static final int SCREEN_HEIGHT = MAX_COLUMN *TILE_SIZE;
	
}