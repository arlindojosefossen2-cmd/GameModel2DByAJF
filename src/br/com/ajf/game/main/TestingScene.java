package br.com.ajf.game.main;

import br.com.ajf.game.audio.wav.IAudio;
import br.com.ajf.game.audio.wav.Music;
import br.com.ajf.game.framework.Game;
import br.com.ajf.game.input.GameInput;
import br.com.ajf.game.scene.Scene;

import java.awt.*;
import java.awt.event.KeyEvent;

public class TestingScene implements Scene
{
	protected final Game game;
	protected String name;

	private int x,y;

	private final IAudio
			music = new Music("/main.wav");

	public TestingScene(Game game)
	{
		this.game = game;
	}

	@Override
	public Scene start()
	{
		name = "Testing Scene";
		music.setVolume(1f);
		return this;
	}

	@Override
	public void update()
	{
		if(GameInput.keyDown(KeyEvent.VK_W))
		{
			y -= 6;
		}
		else if(GameInput.keyDown(KeyEvent.VK_S))
		{
			y += 6;
		}
		else if(GameInput.keyDown(KeyEvent.VK_D))
		{
			x += 6;
		}
		else if(GameInput.keyDown(KeyEvent.VK_A))
		{
			x -= 6;
		}

		if(GameInput.keyDownOnce(KeyEvent.VK_N))
		{
			music.play();
		}
		else if(GameInput.keyDownOnce(KeyEvent.VK_K))
		{
			music.stop();
		}

		if(GameInput.keyDownOnce(KeyEvent.VK_C))
		{
			music.close();
		}
	}

	@Override
	public void draw(Graphics2D graphics2d)
	{
		graphics2d.setColor(Color.BLUE);
		graphics2d.fillRect(x,y,64,64);
	}

	@Override
	public Scene setSceneName(String sceneName)
	{
		this.name = sceneName;
		return this;
	}

	@Override
	public String getSceneName()
	{
		return this.name;
	}
}
