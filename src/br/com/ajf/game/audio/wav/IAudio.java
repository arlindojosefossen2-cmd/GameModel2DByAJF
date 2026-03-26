package br.com.ajf.game.audio.wav;

/**
 * 
 * Author A.J.F.
 * @version 1.0
 * 18 June 2025
 */
public interface IAudio
{
	/**
	 * Play.
	 */
	void play();
	
	/**
	 * Stop.
	 */
	void stop();
	
	/**
	 * Sets the volume.
	 *
	 * @param volume the new volume
	 */
	void setVolume(float volume);
	
	/**
	 * Gets the volume.
	 *
	 * @return the volume
	 */
	float getVolume();

	/**
	 * Close
	 */
	void close();

}