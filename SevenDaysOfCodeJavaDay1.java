import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class SevenDaysOfCodeJavaDay1 {

	
	public static void main(String[] args) throws Exception {
		
		String iMDB = "https://imdb-api.com/en/API/Top250Movies/k_218fzln4";

		HttpRequest request = HttpRequest
				.newBuilder()
				.uri(new URI(iMDB))
				.GET()
				.build();
		
		
		HttpResponse<String> response = HttpClient
				.newBuilder()
				.build()
				.send(request, BodyHandlers.ofString());
		
		System.out.println(response.body());
		
	}
	
}

