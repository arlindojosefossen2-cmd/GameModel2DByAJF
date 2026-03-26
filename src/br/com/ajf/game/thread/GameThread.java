package br.com.ajf.game.thread;

import br.com.ajf.game.framework.Game;

import javax.swing.*;

/**
 * The Class GameThread.
 * Author A.J.F
 */
public final class GameThread implements Runnable
{
	/** The Constant ONE. */
	private static final double ONE = 1;

	/** The game. */
	private final Game game;
	
	/** The thread. */
	private final Thread thread;
	
	/** The running. */
	public boolean running;
	
	/**
	 * Instantiates a new game thread.
	 *
	 * @param game the game
	 */
	public GameThread(final Game game)
	{
		this.game = game;
		this.thread = new Thread(this);
	}
	
	/**
	 * Run.
	 *
	 * @see Runnable#run()
	 * method that run the thread
	 */
	@Override
	public void run()
	{
		final double drawInterval = (double) 1_000_000_000 / this.game.getFps();
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
		
		while(this.running)
		{
			 currentTime = System.nanoTime();
	         delta += (currentTime - lastTime) / drawInterval;
	         lastTime = currentTime;

	         if(delta >= ONE)
			 {
				 this.game.update();
				 delta--;
			 }
		}
		
		try
		{
			this.thread.join();
		} 
		catch (InterruptedException err)
		{
			JOptionPane.showMessageDialog(null,"Error: "+err.getMessage());
		}
	}
	
	/**
	 * method that start the thread.
	 */
	public void start()
	{
		this.running = true;
		this.thread.start();
	}
}