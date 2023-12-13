package br.com.infnet.PokemonApiSpring.util;

import br.com.infnet.PokemonApiSpring.exception.PokemonNotFound;
import br.com.infnet.PokemonApiSpring.model.Pokemon;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PokemonApi {
    public Pokemon getByName(String name) {
        name = name.toLowerCase();
        try{
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(new URI("https://pokeapi.co/api/v2/pokemon/" + name + "/"))
                    .version(HttpClient.Version.HTTP_2)
                    .build();
            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() != 200){
                throw new PokemonNotFound(response.body());
            }
            ObjectMapper objectMapper = new ObjectMapper();
            Pokemon pokemon = objectMapper.readValue(response.body(), Pokemon.class);
            return pokemon;
        }catch(URISyntaxException | IOException | InterruptedException e){
            throw new RuntimeException(e);
        }
    }
    public Pokemon getById(int id) {
        try{
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(new URI("https://pokeapi.co/api/v2/pokemon/" + id + "/"))
                    .version(HttpClient.Version.HTTP_2)
                    .build();
            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() != 200){
                throw new PokemonNotFound(response.body());
            }
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(response.body(), Pokemon.class);
        }catch(URISyntaxException | IOException | InterruptedException e){
            throw new RuntimeException(e);
        }
    }
//    public void getAvatar(Pokemon pokemon){
//        try{
//            HttpRequest request = HttpRequest.newBuilder()
//                    .GET()
//                    .uri(new URI(pokemon.getSprites().getFront_default()))
//                    .version(HttpClient.Version.HTTP_2)
//                    .build();
//            HttpClient client = HttpClient.newBuilder().build();
//            HttpResponse<byte[]> response = client.send(request, HttpResponse.BodyHandlers.ofByteArray());
//            Path pathAvatar = Paths.get("ApiPokemon/avatares");
//            if (!Files.exists(pathAvatar)) {
//                Files.createDirectories(pathAvatar);
//            }
//            Path path = pathAvatar.resolve(pokemon.getName() + ".png");
//            Files.write(path, response.body());
//        }catch (URISyntaxException | IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
}
