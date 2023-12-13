package br.com.infnet.PokemonApiSpring.util;


import br.com.infnet.PokemonApiSpring.model.Item;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ItemApi {
    public Item getById(int id){
        try{
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(new URI("https://pokeapi.co/api/v2/item/" + id))
                    .version(HttpClient.Version.HTTP_2)
                    .build();
            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(response.body(), Item.class);
        }catch(URISyntaxException | IOException | InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
