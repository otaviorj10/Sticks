import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {

    private static JsonParser jsonParser;

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        String url = "https://api.mocki.io/v2/549a5d8b";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        var body  = response.body();
        var parser = jsonParser = new JsonParser();

        List<Map<String,String>> listaDeFilmes = parser.Parse(body);


        for (Map<String,String> lista : listaDeFilmes) {
            
            System.out.println(lista.get( "title"));
            System.out.println(lista.get( "image"));
            System.out.println(lista.get( "imDbRating"));
            System.out.println();
        }

    }
}
