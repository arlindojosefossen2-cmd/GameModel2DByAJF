package br.com.ajf.game.tmx;

import java.io.IOException;
import java.util.List;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import br.com.ajf.game.collision.Collider;
import br.com.ajf.game.math.Vector2I;
import br.com.ajf.game.tile.ITile;
import br.com.ajf.game.tile.ITileManager;
import br.com.ajf.game.tile.TileManager;
import br.com.ajf.game.util.ResourceLoader;
import br.com.ajf.game.util.XMLUtility;

/**
 * The Class TMXLoader.
 */
public final class TMXLoader
{
	/** The xml utility. */
	private final XMLUtility xmlUtility = new XMLUtility();
	
	/** The document element. */
	private Element documentElement;
	
	/** The size. */
	private int size = 1;
	
	/** The scale. */
	private float scale = 1;
	
	/** The layers. */
	private int layers;
	
	/**
	 * Instantiates a new TMX loader.
	 *
	 * @param resPath the res path
	 */
	public TMXLoader(String resPath)
	{	
		try
		{
			documentElement = xmlUtility.parseDocument(new ResourceLoader()
					.load(TMXLoader.class, resPath))
					.getDocumentElement();
		} 
		catch (ParserConfigurationException | IOException | SAXException e)
		{
			JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
		}
	}
	
	/**
	 * Gets the map data.
	 *
	 * @return the map data
	 */
	public short[][][] getMapData()
	{
		TMXDataLoader tmxDataLoader = new TMXDataLoader();
		short[][][] data = tmxDataLoader.getMapData(xmlUtility, documentElement);
		this.scale = tmxDataLoader.scale;
		this.layers = tmxDataLoader.layers;
		
	return data;
	}
	
	/**
	 * Gets the tiles.
	 *
	 * @return the tiles
	 */
	public ITile[] getTiles()
	{
		TMXTilesLoader tmxTilesLoader = new TMXTilesLoader();
		ITile[] tiles = tmxTilesLoader.getTiles(documentElement, xmlUtility, scale);
		this.size = tmxTilesLoader.size;
		return tiles;
	}
	
	/**
	 * Gets the rectangles colliders by attribute name.
	 *
	 * @param attributeName the attribute name
	 * @return the rectangles colliders by attribute name
	 */
	public List<Collider> getRectanglesCollidersByAttributeName(String attributeName)
	{
		return new TMXColliderLoader().getColliders(attributeName, documentElement, scale, xmlUtility);
	}
	
	/**
	 * Gets the vector 2 I list from property tag name.
	 *
	 * @param tagName the tag name
	 * @return the vector 2 I list from property tag name
	 */
	public List<Vector2I> getVector2IListFromPropertyTagName(String tagName)
	{
		List<Element> objectGroup = xmlUtility.getAllElementsByTagName(documentElement, "objectgroup");
		return new TMXPositionLoader().loadDataPositions(tagName, objectGroup, scale);
	}
	
	/**
	 * Gets the tile manager.
	 *
	 * @return the tile manager
	 */
	public ITileManager getTileManager()
	{	
		short[][][] mapData = getMapData();
		ITile[] tiles = getTiles();
		return new TileManager(tiles, mapData,(int)(size*scale));
	}

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public int getSize()
	{
		return size;
	}
	
	/**
	 * Gets the scale.
	 *
	 * @return the scale
	 */
	public float getScale()
	{
		return scale;
	}

	/**
	 * Gets the layers.
	 *
	 * @return the layers
	 */
	public int[] getLayers()
	{
		int[] layers = new int[this.layers];
		
		for (int i = 0; i < layers.length; i++)
		{
			layers[i] = i;
		}
		
		return layers;
	}
}