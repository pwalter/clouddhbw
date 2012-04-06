package com.appspot.clouddhbw.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

public class RequestHelper {
	public static String getHost(UriInfo ui) {
		String port = ui.getRequestUri().getPort() == -1 ? "" : ":" + ui.getRequestUri().getPort();
		
		return ui.getRequestUri().getScheme() + "://" + ui.getRequestUri().getHost() + port;
		
	}
	
	public static HttpURLConnection getConnection(String URL, RequestType method, String reqContentType) throws Exception {
		URL url = new URL( URL );
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod( method.toString() );
		
		if(method != RequestType.GET) {
			connection.setDoInput( true );
		}
		
		connection.setDoOutput( true );
		connection.setUseCaches( false );
		connection.setRequestProperty( "Content-Type", reqContentType );
		
		return connection;
	}
	
	public static String doGET(String URL, String requestContentType) {
		try {
			HttpURLConnection con = RequestHelper.getConnection(URL, RequestType.GET, requestContentType);
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()) );
			StringBuffer result = new StringBuffer();
			
			result.append("<strong>URL:</strong> " + URL + "<br /><br />");
			
			// Response
			result.append("<strong>GET Response:</strong><br />");
			result.append("<pre>");
			for ( String line; (line = reader.readLine()) != null; )
			{
				result.append(line + "<br />");
			}
			result.append("</pre>");

			//writer.close();
			reader.close();
			
			return result.toString();
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public static String doPUT(String URL, String requestContentType, String postData) {
		try {
			HttpURLConnection con = RequestHelper.getConnection(URL, RequestType.PUT, requestContentType);
			OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());
			writer.write(postData);
			writer.flush();
		    
			BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()) );
			StringBuffer result = new StringBuffer();
			
			result.append("<strong>URL:</strong> " + URL + "<br /><br />");
			
			// Request
			result.append("<strong>PUT Request:</strong> <br />");
			result.append("<pre>");
			result.append(postData);
			result.append("</pre>");
			
			// Response
			result.append("<strong>PUT Response:</strong><br />");
			result.append("<pre>");
			for ( String line; (line = reader.readLine()) != null; )
			{
				result.append(line + "<br />");
			}
			result.append("</pre>");

			//writer.close();
			reader.close();
			
			return result.toString();
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
