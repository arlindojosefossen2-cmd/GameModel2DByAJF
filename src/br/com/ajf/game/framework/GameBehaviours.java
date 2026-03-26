package br.com.ajf.game.framework;

import br.com.ajf.game.image.ImageLoader;
import br.com.ajf.game.scene.Scene;

/** 
 * Author A.J.F.
 * @version 1.0
 * 30 June 2025
 */
public sealed interface GameBehaviours permits Game
{
	/** The Constant loader. */
	ImageLoader LOADER = new ImageLoader();
	
	 /**
 	 * Instantiates the attributes and thread.
 	 *
 	 * @param fps the fps
 	 */
	 void init(int fps);
 	
 	/**
	  * Update.
	  */
	void update();
	 
	/**
	 * Adds the state.
	 *
	 * @param scene the scene
	 */
	void addScene(Scene scene);
	
	/**
	 * Change scene.
	 *
	 * @param sceneName the scene name
	 * @return the scene
	 */
	Scene changeScene(String sceneName);
	 
	 /**
 	 * Sets the icon.
 	 *
 	 * @param path the new icon
 	 */
	 void setIcon(String path);
 	
 	/**
	  * Delta.
	  *
	  * @return the float
	  */
	float delta();
	
	/**
	 * Gets the fps.
	 *
	 * @return the fps
	 */
	int getFps();
}