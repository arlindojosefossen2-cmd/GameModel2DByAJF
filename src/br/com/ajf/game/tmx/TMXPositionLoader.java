package br.com.ajf.game.tmx;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

import br.com.ajf.game.math.Vector2I;
import br.com.ajf.game.util.XMLUtility;

public final class TMXPositionLoader
{
	public TMXPositionLoader()
	{
		super();
	}

	/**
	 * Load data positions.
	 *
	 * @param tagName the tag name
	 * @param objectGroup the object group
	 * @return the list
	 */
	List<Vector2I> loadDataPositions(String tagName, List<Element> objectGroup, float scale)
	{
		List<Vector2I> positions = new ArrayList<>();
		
		for (Element object : objectGroup)
		{
			loadPositions(tagName, positions,object,scale);
		}
		
		return positions;
	}

	/**
	 * Load positions.
	 *
	 * @param tagName the tag name
	 * @param positions the positions
	 * @param object the object
	 * @param scale the float
	 */
	private void loadPositions(String tagName, List<Vector2I> positions,Element object, float scale)
	{
		XMLUtility xmlUtility = new XMLUtility();
		
		List<Element> objectsList = xmlUtility.getAllElementsByTagName(object, "object");	
		
		for (Element object1 : objectsList)
		{
			Element properties = xmlUtility
						.getAllElementsByTagName(object1,"properties").getFirst();
					
			Element property = xmlUtility
						.getAllElementsByTagName(properties,"property").getFirst();
					
			if(property.getAttribute("value").equalsIgnoreCase(tagName))
			{
				int x = (int) Float.parseFloat(object1.getAttribute("x"));
				int y = (int) Float.parseFloat(object1.getAttribute("y"));
				positions.add(new Vector2I((int)(x*scale),(int)(y*scale)));
			}
		}
	}
}