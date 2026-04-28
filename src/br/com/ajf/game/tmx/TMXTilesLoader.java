package br.com.ajf.game.tmx;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

import br.com.ajf.game.framework.Game;
import br.com.ajf.game.image.ImageSFX;
import br.com.ajf.game.tile.ITile;
import br.com.ajf.game.tile.Tile;
import br.com.ajf.game.tile.TileAnimated;
import br.com.ajf.game.util.XMLUtility;

/**
 * The Class TMXTilesLoader.
 */
public final class TMXTilesLoader
{
	/** The size. */
	int size;

	/**
	 * Instantiates a new TMX tiles loader.
	 */
	public TMXTilesLoader()
	{
		super();
	}
	
	/**
	 * Gets the tiles.
	 *
	 * @param documentElement the document element
	 * @param xmlUtility the xml utility
	 * @param scale the scale
	 * @return the tiles
	 */
	public ITile[] getTiles(Element documentElement, XMLUtility xmlUtility, float scale)
	{
		ITile[] tiles;
			
		Element tileset = xmlUtility.getAllElementsByTagName(documentElement,"tileset").getFirst();
			
		List<Element> tileList = xmlUtility.getAllElementsByTagName(tileset,"tile");
		
		int tileCount = Integer.parseInt(tileset.getAttribute("tilecount"));
			
		Element imageElement = xmlUtility.getAllElementsByTagName(tileset, "image").getFirst();
			
		String path = imageElement.getAttribute("source");
			
		int width = Integer.parseInt(imageElement.getAttribute("width"));
		int height = Integer.parseInt(imageElement.getAttribute("height"));
			
		size = Integer.parseInt(tileset.getAttribute("tilewidth"));
			
		int imageColumns = width/size;
		int imageRows = height/size;
			
		BufferedImage[] images = Game.LOADER.loadScaledBufferedImagesFromSheet(path, 
				imageRows, 
				imageColumns, 
				scale);
		
		ImageSFX imageSFX = new ImageSFX();
		
		tiles = new ITile[tileCount];
		
		if(tileList.isEmpty())
		{
			return loadTilesByImage(tiles, images);
		}
		
	return loadTilesByTag(tiles, tileList, images, imageSFX, xmlUtility);
	}

	/**
	 * Load tiles by image.
	 *
	 * @param tiles the tiles
	 * @param images the images
	 * @return the tile[]
	 */
	private ITile[] loadTilesByImage(ITile[] tiles, BufferedImage[] images)
	{
		for (int i = 0; i < tiles.length; i++)
		{
			tiles[i] = new Tile(i,false,images[i]);
		}
		return tiles;
	}

	/**
	 * Load tiles by tag.
	 *
	 * @param tiles the tiles
	 * @param tileList the tile list
	 * @param images the images
	 * @param imageSFX the image SFX
	 * @param xmlUtility the xml utility
	 * @return the tile[]
	 */
	private ITile[] loadTilesByTag(ITile[] tiles, List<Element> tileList, BufferedImage[] images, ImageSFX imageSFX, XMLUtility xmlUtility)
	{
		for (Element t : tileList)
		{
			int id = Integer.parseInt(t.getAttribute("id"));
			
			Element props = xmlUtility.getElementsByTagName(t,"properties").getFirst();
			
			List<Element> prop = xmlUtility.getAllElementsByTagName(props, "property");
			
			boolean animated;
			boolean solid = false;
			float interval;
			int frames;
			
			List<String> auxList = new ArrayList<>(); 
			
			for (Element p : prop)
			{
				auxList.add(p.getAttribute("value"));
			}
			
			animated = Boolean.parseBoolean(auxList.get(0));

			if(animated)
			{
				if(auxList.size() == 5)
				{
					solid = Boolean.parseBoolean(auxList.get(4));
				}

				frames = Integer.parseInt(auxList.get(1));
				interval = Float.parseFloat(auxList.get(2));
				
				tiles[id] = new TileAnimated(id, solid,
						imageSFX.cropBufferedImage(images, id, frames),
						interval);
				auxList.clear();
			}
			else
			{
				if(auxList.size() == 3)
				{
					solid = Boolean.parseBoolean(auxList.get(2));
				}
				tiles[id] = new Tile(id, solid, images[id]);
			}
		}
	return tiles;
	}
}