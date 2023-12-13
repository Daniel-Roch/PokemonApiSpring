package br.com.infnet.PokemonApiSpring;

import br.com.infnet.PokemonApiSpring.model.Pokemon;
import br.com.infnet.PokemonApiSpring.service.PokemonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PokemonApiSpringApplicationTests {
	@Autowired
	PokemonService pokemonService;
	@Test
	public void testGetListPokemons() {
		List<Pokemon> listPokemons = pokemonService.getAll();
		assertEquals(10, listPokemons.size());
	}
	@Test
	public void testGetByIndex(){
		int index = 0;
		Pokemon pokemon = pokemonService.getByIndex(0);
		assertNotNull(pokemon);
	}

}
