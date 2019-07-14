package download.gradle;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.gradle.wrapper.GradleWrapperMain;

public class DownloadGradle {

	public static void main(String[] args) throws Exception {
		String address = "https://www.google.com";

		URL url = new URL(address);
		URLConnection conn = url.openConnection();
		
		

        System.out.println(System.getProperty("http.proxyHost"));
        System.out.println(System.getProperty("https.proxyHost"));

        System.out.println(System.getProperty("http.proxyPort"));
        System.out.println(System.getProperty("https.proxyPort"));
		
		System.setProperty("http.proxyHost", "www-proxy.us.oracle.com");
		System.setProperty("https.proxyHost", "www-proxy.us.oracle.com");
		System.setProperty("http.proxyPort", "80");
		System.setProperty("https.proxyPort", "8080");
		
		InputStream in = conn.getInputStream();
		
		//String string = new String(in.readA)
		
		int numRead;
		StringBuilder sb =  new StringBuilder();
		 while ((numRead = in.read()) != -1) {
			 sb.append(numRead);
		 }

		 System.out.println(sb.toString());
		 
		//GradleWrapperMain.main(args);

	}

}
