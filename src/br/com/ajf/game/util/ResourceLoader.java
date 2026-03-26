package br.com.ajf.game.util;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;

/**
 * The Class ResourceLoader.
 */
public final class ResourceLoader
{
    /**
     * Instantiates a new resource loader.
     */
    public ResourceLoader()
	{
		super();
	}

    /**
     * Load.
     *
     * @param filepath the filepath
     * @return the input stream
     */
    public InputStream load(final String filepath)
    {
        try
        {
            if(!(filepath == null || filepath.isEmpty()))
            {
            	return new FileInputStream(filepath);
            }
        }
        catch (Exception exception)
        {
			JOptionPane.showMessageDialog(null,"Error: "+exception.getMessage());
        }
    return null;
    }
    /**
     * Load.
     *
     * @param clazz the clazz
     * @param resPath path the res path
     * @return the input stream
     */
    public InputStream load(final Class<?> clazz,final String resPath)
    {
        try
        {
            if(!(resPath == null || resPath.isEmpty()))
            {
                return clazz.getResourceAsStream(resPath);
            }
        }
        catch (Exception exception)
        {
			JOptionPane.showMessageDialog(null,"Error: "+exception.getMessage());
        }
    return null;
    }
    
	/**
     * Load.
     *
     * @param clazz the clazz
     * @param filepath the filepath
     * @param resPath the res path
     * @return the input stream
     */
    public InputStream load(final Class<?> clazz,final String filepath,final String resPath)
    {
        try
        {
            if(!(resPath == null || resPath.isEmpty()))
            {
                return clazz.getResourceAsStream(resPath);
            }
            else
            {
            	return new FileInputStream(filepath);
            }
        }
        catch (Exception exception)
        {
			JOptionPane.showMessageDialog(null,"Error: "+exception.getMessage());
        }
    return null;
    }
    
    /**
     * Read.
     *
     * @param filename the filename
     * @return the string
     */
    public String read(final String filename)
   	{
   	   final StringBuilder text = new StringBuilder();
   	   
   	   try(BufferedReader reader = new BufferedReader(new FileReader(filename)))
   	   { 
   	      while(reader.ready())
   	      {
   	           text.append(reader.readLine()).append("\n");
   	      }
	   }
   	   catch(Exception exception)
   	   {
		   JOptionPane.showMessageDialog(null,"Error: "+exception.getMessage());
   	   }
   	   return text.toString();
   	}	
}