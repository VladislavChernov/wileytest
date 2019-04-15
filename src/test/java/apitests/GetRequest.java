package apitests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class GetRequest {
	
	public int simpleGet(String url, String RequestMethod) throws MalformedURLException, ProtocolException, IOException {
        
		HttpURLConnection con = null;
		int retCode;
		
        try {

			URL myurl = new URL(url);
            con = (HttpURLConnection) myurl.openConnection();

            con.setRequestMethod(RequestMethod);
            

        } finally {
        	 
        	retCode = con.getResponseCode();
            con.disconnect();
        }
		return retCode;
	}
}
