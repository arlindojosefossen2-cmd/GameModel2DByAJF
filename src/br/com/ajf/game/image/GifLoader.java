package br.com.ajf.game.image;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class GifLoader
{
    public GifLoader()
    {
    
    }
    
    public Image load(String fileResourcePath)
    {
        return new ImageIcon(Objects.requireNonNull(GifLoader.class.getResource(fileResourcePath))).getImage();
    }
    
    public Image[] load(String[] fileResourcePaths)
    {
        Image[] images = new Image[fileResourcePaths.length];
        
        for (int i = 0; i < images.length; i++)
        {
            images[i] = load(fileResourcePaths[i]);
        }
        return images;
    }
}
