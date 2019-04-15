package apitests;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class apitest {
	String url = "https://httpbin.org/";
	
	private SoftAssert sa = new SoftAssert();
	
	@Test
	public void testDelayGet() throws MalformedURLException, ProtocolException, IOException {
		String requestMethod = "GET";

		sa.assertEquals(new GetRequest().simpleGet(url+"delay/7", requestMethod), 200);
		
	}
	
	@Test
	public void testImagePNGGet() throws MalformedURLException, ProtocolException, IOException {
		String requestMethod = "GET";

		sa.assertEquals(new GetRequest().simpleGet(url+"image/png", requestMethod), 200);
		
	}	
}
