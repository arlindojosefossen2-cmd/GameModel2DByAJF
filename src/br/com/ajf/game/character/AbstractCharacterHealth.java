package br.com.ajf.game.character;

public final class AbstractCharacterHealth
{
	private int maxLife;
	private int life;
	
	public AbstractCharacterHealth()
	{
	
	}
	
	public AbstractCharacterHealth(int maxLife)
	{
		this.maxLife = maxLife;
		this.life = maxLife;
	}
	
	public int getMaxLife()
	{
		return maxLife;
	}
	
	public void setMaxLife(int maxLife)
	{
		this.maxLife = maxLife;
	}
	
	public int getLife()
	{
		return life;
	}
	
	public void setLife(int life)
	{
		this.life = life;
	}
}