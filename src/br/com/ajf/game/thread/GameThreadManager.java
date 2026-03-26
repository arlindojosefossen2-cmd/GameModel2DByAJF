package br.com.ajf.game.thread;

import br.com.ajf.game.framework.Game;

/**
 * The Class GameThreadManager.
 * Author A.J.F
 */
public final class GameThreadManager implements IGameThreadManager
{	
    
    /** The game thread. */
    private GameThread gameThread ;
    
    /** The thread timer. */
    private GameThreadTaskTimer threadTimer;

	/** The thread type. */
	private final int threadType;

	/**
	 * Instantiates a new game thread manager.
	 *
	 * @param game the game
	 * @param threadType the type of the thread
	 */
	public GameThreadManager(final Game game,final int threadType)
	{
		this.threadType = threadType;
		if (threadType == 1)
		{
			this.threadTimer = new GameThreadTaskTimer(game);
		} else
		{
			this.gameThread = new GameThread(game);
		}
	}

	
	/**
	 * Start.
	 */
	@Override
	public void start()
	{
		if (this.threadType == 1)
		{
			this.threadTimer.start();
		} else
		{
			this.gameThread.start();
		}
	}
}