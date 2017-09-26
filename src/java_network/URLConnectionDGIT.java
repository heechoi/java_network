package java_network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionDGIT {
	public static void main(String[] args) {
		try {
			URL dgit = new URL("http://www.dgit.or.kr/login.php");
			try {
				URLConnection urlConnection = dgit.openConnection();
				urlConnection.setDoOutput(true);
				
				OutputStreamWriter osw = new OutputStreamWriter(urlConnection.getOutputStream());
				osw.write("user_id = ekgml9904&userpasswd=heehee99004");
				//http://www.dgit.or.kr/login.php?user_id = ekgml9904&userpasswd=heehee99004
				osw.close();
				BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				
				String line;
				while((line=br.readLine())!=null){
					System.out.println(line);
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
	}
}
