package br.com.infnet.PokemonApiSpring;

import br.com.infnet.PokemonApiSpring.exception.AbilityNotFound;
import br.com.infnet.PokemonApiSpring.model.Ability;
import br.com.infnet.PokemonApiSpring.util.AbilityPokemonApi;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AbilityTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(PokemonsTest.class);
    @Test
    @DisplayName("Return Ability, using name")
    public void getAbility(){
        LOGGER.info("Test search ability names");
        assertThrows(AbilityNotFound.class, () ->{
            AbilityPokemonApi abilityPokemonApi = new AbilityPokemonApi();
            LOGGER.debug("Search Ability");
            Ability stench = abilityPokemonApi.getAbility("stenchh");
            assertEquals(1, stench.getId());
        }, "Ability Not Found");
    }
}
