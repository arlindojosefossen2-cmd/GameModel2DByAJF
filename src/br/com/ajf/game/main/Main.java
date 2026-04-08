package br.com.ajf.game.main;

import br.com.ajf.game.framework.Game;
import br.com.ajf.game.thread.IGameThreadManager;

public class Main
{
	private Main()
	{

	}

	public static void main(String[] args)
	{
		System.out.println("Testing");

		Game game = new Game(
				"Testing Game Refactor",
				1024,
				576,
				IGameThreadManager.GAME_THREAD_TIMER_TASK);

		game.addScene(new TestingScene(game).start());
		game.init(IGameThreadManager.FPS_30);
	}
}