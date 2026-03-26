package br.com.ajf.game.framework;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import br.com.ajf.game.scene.Scene;

/**
 * The Class GameRender.
 * Author A.J.F
 */
public final class GameRender
{
	/** The game render manager. */
	private final GameRenderManager gameRenderManager;
	
	/** The scenes. */
	private final List<Scene> scenes = new ArrayList<>();
	
    /** The state manager. */
    private Scene scene;

	/**
	 * Instantiates a new game render.
	 *
	 * @param width the width
	 * @param height the height
	 */
	public GameRender(final int width,final int height)
	{
		gameRenderManager = new GameRenderManager(width, height);
	}
    
	/**
	 * Creates the J panel and add properties.
	 */
	public void createJPanelAndAddProperties()
	{
		gameRenderManager.createJPanelAndAddProperties();
	}
	
	/**
	 * Draw to buffered image.
	 */
	public void drawToBufferedImage()
	{
		gameRenderManager.drawToBufferedImage();
		
		if(scene != null)
		{
			this.scene.draw(gameRenderManager.graphics2d);
		}
	}
	
	/**
	 * Draw to screen.
	 */
	public void drawToScreen()
	{
		gameRenderManager.drawToScreen();
	}
	
	/**
	 * Adds the scene.
	 *
	 * @param scene the scene
	 * @return the scene
	 */
	public Scene addScene(final Scene scene)
	{
		this.scenes.add(scene);
		return this.scene = scene;
	}
	
	/**
	 * Change scene.
	 *
	 * @param name the scene id
	 * @return the scene
	 */
	public Scene changeScene(String name)
	{
		for (Scene scene : scenes)
		{
			if(scene.getSceneName().equalsIgnoreCase(name))
			{
				return this.scene = scene;
			}
		}
		return null;
	}
	
	/**
	 * Gets the canvas.
	 *
	 * @return the canvas
	 */
	public JPanel getCanvas()
	{
		return gameRenderManager.canvas;
	}

	/**
	 * this method update the state.
	 */
	public void update()
	{
		if(scene != null)
		{
			scene.update();
		}
	}
}