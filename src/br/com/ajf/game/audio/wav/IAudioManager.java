package br.com.ajf.game.audio.wav;
/**
 * 
 * Author A.J.F.
 * @version 1.0
 * 24 June 2025
 */
public interface IAudioManager
{
	/**
	 * Play.
	 *
	 * @param audioIndex the audio index
	 */
	void play(int audioIndex);
	
	/**
	 * Stop.
	 *
	 * @param audioIndex the audio index
	 */
	void stop(int audioIndex);
	
	/**
	 * Adds the audio.
	 *
	 * @param audio the audio
	 */
	void addAudio(IAudio audio);
	
	/**
	 * Sets the volume.
	 *
	 * @param audioIndex the audio index
	 * @param volume the volume
	 */
	void setVolume(int audioIndex, float volume);
	
	/**
	 * Gets the volume.
	 *
	 * @param audioIndex the audio index
	 * @return the volume
	 */
	float getVolume(int audioIndex);

	void close();
}