package com.examples;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        final String path = System.getProperty("user.dir") + "/src/main/config/config.properties";
//        final String path = "config/config.properties";       
        
        
        final Properties properties = loadProperties( path);
         
        final String artifactId = properties.getProperty("artifactId");
        
        System.out.println("artifactId=" + artifactId);
    }

	private static Properties loadProperties(String path) {
		// TODO Auto-generated method stub
		FileInputStream in = null;
		
		try{
			in = FileUtils.openInputStream(new File(path));

			final Properties properties = new Properties();
			properties.load(in);
			return properties;
		}catch (IOException e){
			e.printStackTrace();
			return null;
		}finally{
			IOUtils.closeQuietly(in);
		}		
	}
}
