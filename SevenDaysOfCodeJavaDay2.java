import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SevenDaysOfCodeJavaDay2 {

	
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
		

		String json = response.body();
		
		String[] filmesArray = parseJsonFilme(json);	
		
		List<String> titulos = parseTitulo(filmesArray);
		titulos.forEach(System.out::println);
		
		List<String> imagem = parseImagem(filmesArray);
		imagem.forEach(System.out::println);
		
		List<String> pontuacao = parsePontuacao(filmesArray);
		pontuacao.forEach(System.out::println);
		
		List<String> lancamento = parseLancamento(filmesArray);
		lancamento.forEach(System.out::println);
		
	}
	

	private static String[] parseJsonFilme(String json) {
		
		Matcher matcher = Pattern.compile(".*\\[(.*)\\].*").matcher(json);

		if (!matcher.matches()) {
			throw new IllegalArgumentException("no match in " + json);
		}
		
		String[] filmeArray = matcher.group(1).split("\\},\\{");
		filmeArray[0] = filmeArray[0].substring(1);
		int ultimo = filmeArray.length-1;
		String ultimoString = filmeArray[ultimo];
		filmeArray[ultimo] = ultimoString.substring(0, ultimoString.length() - 1);
		
		
		return filmeArray;
	}
	
	private static List<String> parseTitulo(String[] filmesArray){
		return parseAtributo(filmesArray, 3);
		
	}
	
	private static List<String> parseImagem(String[] filmesArray){
	
		return parseAtributo(filmesArray, 5);
	}

	private static List<String> parsePontuacao(String[] filmesArray){
		
		return parseAtributo(filmesArray, 1);
	}
	
	private static List<String> parseLancamento(String[] filmesArray) {
		
		return parseAtributo(filmesArray, 4);
	}
	
	
	private static List<String> parseAtributo(String[] filmesArray, int posicao) {
		
		
		return Stream.of(filmesArray)
				.map(e -> e.split("\",\"")[posicao])
				.map(e -> e.split(":\"")[1])
				.map(e -> e.replaceAll("\"",""))
				.collect(Collectors.toList());
	}

	
	
}

