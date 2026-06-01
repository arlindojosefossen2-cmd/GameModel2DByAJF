package br.com.ajf.game.framework;

import javax.swing.JPanel;

import br.com.ajf.game.scene.Scene;

/**
 * The Interface IGamePanelManager.
 * Author A.J.F
 */
public interface IGamePanel
{
	/**
	 * Gets the canvas.
	 *
	 * @return the canvas
	 */
	JPanel getCanvas();

	/**
	 * this method update the state.
	 */
	void update();

	/**
	 * this method start the state.
	 */
	void start();

	/**
	 * Sets the scene.
	 *
	 * @param scene the new scene
	 * @return the scene
	 */
	Scene setScene(Scene scene);
}