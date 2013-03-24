/**
 * URLUtility.java
 * Joshua Dickson, for ASSISTments and InBloom
 */
package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * A class that provides functions for working with URLs and URL objects
 * @author Joshua Dickson
 * @version March 23, 2013
 */
public class URLUtility {
	
	/**
	 * A function that gets the String representation of the XML response from a given urlPath
	 * @param urlPath the absolute path to query
	 * @return the String return from the URL query
	 * @throws Exception
	 */
	public static String getXMLStringFromURL(String urlPath) throws Exception {
		String checkResponse;
		
		BufferedReader reader = null;
	    try {
	        URL url = new URL(urlPath);
	        URLConnection connection = url.openConnection();

	        reader = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
	        
	        StringBuffer buffer = new StringBuffer();
	        int read;
	        char[] chars = new char[4128];
	        while ((read = reader.read(chars)) != -1)
	            buffer.append(chars, 0, read); 

	        checkResponse = buffer.toString();		        
	        
	    } finally {
	        if (reader != null)
	            reader.close();
	    }
	    
	    return checkResponse;
		
		
		
	}
	
	
	
	/**
	 * A function that queries a specified urlPath on top of the InBloom base URL and
	 * returns the String response of the server
	 * @param urlPath the additional URL to query InBloom in addition to the base path
	 * @return the String response
	 * @throws Exception if the connection returns an error
	 */
	public static String getJSONStringFromURL(String urlPath) throws Exception {
		
			String urlString = (ApplicationSettings.getInBloomBasePath() + urlPath);
			String checkResponse;
			
			BufferedReader reader = null;
		    try {
		        URL url = new URL(urlString);
		        URLConnection connection = url.openConnection();
		        
		        System.out.println("Trying to query for user...: " + ActiveUser.getActiveUser()
		        		.getAccessToken().getAccess_token());
		        
		        connection.setRequestProperty("Accept", "application/vnd.slc+json");		        
		        connection.setRequestProperty("Content-Type", "application/vnd.slc+json");
		        connection.setRequestProperty("Authorization", ("bearer " + 
		        ActiveUser.getActiveUser().getAccessToken().getAccess_token()));

		        reader = new BufferedReader(new InputStreamReader(
                        connection.getInputStream()));
		        
		        StringBuffer buffer = new StringBuffer();
		        int read;
		        char[] chars = new char[4128];
		        while ((read = reader.read(chars)) != -1)
		            buffer.append(chars, 0, read); 

		        checkResponse = buffer.toString();		        
		        
		    } finally {
		        if (reader != null)
		            reader.close();
		    }
		    
		    return checkResponse;
	}
	
	/**
	 * 
	 * @param urlPath
	 * @param postArg
	 * @return
	 * @throws Exception
	 */
	public static String getXMLStringFromURLPost(String urlPath, String postArg) throws Exception {
		
		String checkResponse;
		
		BufferedReader reader = null;
	    try {
	        URL url = new URL(urlPath);
	        URLConnection connection = url.openConnection();
	        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	        connection.setRequestProperty("Cookie", 
	        		"auth_token=88fa8406989a903f9541a22cd768040f54eca8d5; " +
	        		"_Assistment_session_id=446f9ce16570b1338efbcef2b4dfa927;" +
	        		" __utma=201738513.979843057.1364099363.1364099363.1364099363.1;" +
	        		" __utmb=201738513.4.10.1364099363; __utmc=201738513; " +
	        		"__utmz=201738513.1364099363.1.1.utmcsr=(direct)" +
	        		"|utmccn=(direct)|utmcmd=(none))");
	        
	        connection.setDoOutput(true);

	        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
	        
	        writer.write(postArg);
	        writer.flush();
	        

	        reader = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
	        
	        StringBuffer buffer = new StringBuffer();
	        int read;
	        char[] chars = new char[1024];
	        while ((read = reader.read(chars)) != -1)
	            buffer.append(chars, 0, read); 

	        checkResponse = buffer.toString();	
	        
	        writer.close();
	        
	    } finally {
	        if (reader != null)
	        	
	        	reader.close();
	    }
	    
	    return checkResponse;
}
	

	/**
	 * A function that returns a String representing the response of a given urlString
	 * query
	 * @param urlString the string used to make the URL request
	 * @return the String representation of the return
	 * @throws Exception if there is an error querying the URL
	 */
	public static String readUrl(String urlString) throws Exception {
	    BufferedReader reader = null;
	    try {
	        URL url = new URL(urlString);
	        
	        reader = new BufferedReader(new InputStreamReader(url.openStream()));
	        StringBuffer buffer = new StringBuffer();
	        int read;
	        char[] chars = new char[4128];
	        while ((read = reader.read(chars)) != -1)
	            buffer.append(chars, 0, read); 

	        return buffer.toString();
	    } finally {
	        if (reader != null)
	            reader.close();
	    }
	    
	}
}
