package br.com.infnet.PokemonApiSpring;

import br.com.infnet.PokemonApiSpring.exception.PokemonNotFound;
import br.com.infnet.PokemonApiSpring.model.Pokemon;
import br.com.infnet.PokemonApiSpring.util.PokemonApi;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class PokemonsTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(PokemonsTest.class);
    @Test
    @DisplayName("Retorna o id do pokemon, pelo nome")
    public void getIdPokemon(){
        LOGGER.info("Test create search pokemon name and return Id");
        try{
            PokemonApi pokeApi = new PokemonApi();
            Pokemon ditto = pokeApi.getByName("Ditto");
            LOGGER.debug("Search Pokemon using name");
            assertEquals(132, ditto.getId());
        }catch(Exception e){
            LOGGER.error("Error in test" + e);
        }
    }
    @Test
    @DisplayName("Return Exception dont found")
    public void getPokemonDontFound(){
        LOGGER.info("Test create search pokemon dont found");
        PokemonApi pokeApi = new PokemonApi();
        assertThrows(PokemonNotFound.class, ()->{
            Pokemon pokemon = pokeApi.getByName("Dimi");
            LOGGER.debug("Search Pokemon using name");
        }, "Pokemon dont found");
    }
//    @Test
//    @DisplayName("Saver avatar pokemon")
//    public void getAvatarPokemon(){
//        PokemonApi pokemonApi = new PokemonApi();
//        Pokemon ditto = pokemonApi.getByName("ditto");
//        pokemonApi.getAvatar(ditto);
//        Path avatar = Path.of("avatares/" + ditto.getName() + ".png");
//        boolean exists = Files.exists(avatar);
//        assertTrue(exists);
//        //Deletei depois que verifiquei se existe. só para testes
//        try{
//            Files.deleteIfExists(avatar);
//        }catch(IOException e){
//            throw new RuntimeException(e);
//        }
//    }
}
