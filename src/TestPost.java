import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONObject;



public class TestPost {
	
	public static String httpPost(String urlStr)throws Exception{
		
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setUseCaches(false);
		conn.setAllowUserInteraction(false);
		conn.setRequestProperty("Accept", "application/json");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("Authorization", "Bearer -put the generate token here-");
		
		OutputStream out = conn.getOutputStream();
		Writer writer = new OutputStreamWriter(out);

		
		writer.write("{\"name\":\"NewPlaylist 3\",\"public\":false}");
		writer.close();
		out.close();
		
	
		
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
			
			
			String retorno = httpPost("https://api.spotify.com/v1/users/ivanknow/playlists");
			
			System.out.println(retorno);
			 JSONObject json = new JSONObject(retorno);
			PlayList pl = new PlayList(json.getString("name"), json.getJSONObject("followers").getInt("total"), json.getJSONObject("owner").getString("id")) ;
			System.out.println(pl);
			
		}catch(IOException e){
			System.out.println(e.getStackTrace());
		} 
		catch (Exception e) {
			e.getMessage();
			System.out.println(e.getStackTrace());
		}

	}

}