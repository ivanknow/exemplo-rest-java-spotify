
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;


public class TestGet {
	
	public static String httpGet(String urlStr) throws IOException{
		
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		if (conn.getResponseCode() != 200){
			throw new IOException(conn.getResponseMessage());
		}
		
		
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);	
		}
		rd.close();
		
		conn.disconnect();
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		
		try {
			String dados =  httpGet("http://ws.spotify.com/search/1/artist.json?q=jorge");
			
			JSONObject json = new JSONObject(dados);
			
			JSONArray artists = json.getJSONArray("artists");
			
			for(int i = 0;i<artists.length();i++){
				Artista a = new Artista(artists.getJSONObject(i).getString("name"),artists.getJSONObject(i).getString("popularity"));
				System.out.println(a);
			}
			
			//System.out.println(dados);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	

}
