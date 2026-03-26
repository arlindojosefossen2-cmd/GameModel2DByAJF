package br.com.ajf.game.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

/**
 * The Class GameInput.
 * Author A.J.F
 */
public final class GameInput
{
	/** The key adapter. */
	private final KeyAdapter keyAdapter;
	
	/** The keys. */
public static boolean[] keys;
	
	/** The polled. */
public static short[] polled;
	
	/**
	 * Instantiates a new game input.
	 */
	public GameInput()
	{
		keys = new boolean[256];
		polled = new short[256];
		
		keyAdapter = new KeyAdapter()
		{
			@Override
			public synchronized void keyPressed(final KeyEvent e)
			{
				int kc = e.getKeyCode();
			
				if(kc >= 0 && kc < keys.length)
				{
					keys[kc] = true;
				}
			}
			
			@Override
			public synchronized void keyReleased(final KeyEvent e)
			{
				int kc = e.getKeyCode();
				
				if(kc >= 0 && kc < keys.length)
				{
					keys[kc] = false;
				}
			}
		};
	}

	/**
	 * Reset.
	 */
	public static void reset()
	{
		Arrays.fill(keys, false);
		Arrays.fill(polled, (short) 0);
	}
	
	/**
	 * Update.
	 */
	public static synchronized void update()
	{
		for (int i = 0; i < keys.length; ++i)
		{
			if(keys[i])
			{
				polled[i]++;
			}
			else
			{
				polled[i] = 0;
			}
		}
	}
	
	/**
	 * Key down.
	 *
	 * @param keyCode the key code
	 * @return true, if successful
	 */
	public static boolean keyDown(int keyCode)
	{
		return polled[keyCode] > 0;
	}

	/**
	 * Key down once.
	 *
	 * @param keyCode the key code
	 * @return true, if successful
	 */
	public static boolean keyDownOnce(int keyCode)
	{
		return polled[keyCode] == 1;
	}
	
	/**
	 * Gets the key adapter.
	 *
	 * @return the key adapter
	 */
	public KeyAdapter getKeyAdapter()
	{
		return keyAdapter;
	}
}