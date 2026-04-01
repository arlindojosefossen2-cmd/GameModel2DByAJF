package br.com.ajf.game.framework;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import br.com.ajf.game.scene.Scene;

/**
 * The Class RenderManager.
 * Author A.J.F
 */
public final class RenderManager
{
	/** The game render manager. */
	private final Render render;
	
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
	public RenderManager(final int width, final int height)
	{
		render = new Render(width, height);
	}
    
	/**
	 * Creates the J panel and add properties.
	 */
	public void createJPanelAndAddProperties()
	{
		render.createJPanelAndAddProperties();
	}
	
	/**
	 * Draw to buffered image.
	 */
	public void drawToBufferedImage()
	{
		render.drawToBufferedImage();
		
		if(scene != null)
		{
			this.scene.draw(render.graphics2d);
		}
	}
	
	/**
	 * Draw to screen.
	 */
	public void drawToScreen()
	{
		render.drawToScreen();
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
		return render.canvas;
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