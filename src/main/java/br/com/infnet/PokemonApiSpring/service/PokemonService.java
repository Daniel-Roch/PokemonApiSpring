package br.com.infnet.PokemonApiSpring.service;

import br.com.infnet.PokemonApiSpring.exception.PokemonNotFound;
import br.com.infnet.PokemonApiSpring.model.Pokemon;
import br.com.infnet.PokemonApiSpring.util.PokemonApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PokemonService {
    Logger logger = LoggerFactory.getLogger(PokemonService.class);
    private List<Pokemon> listPokemon = initPokemon();
    private List<Pokemon> initPokemon() {
        logger.info("Get all pokemon");
        ArrayList<Pokemon> piokemonList = new ArrayList<>();
        PokemonApi pokemonApi = new PokemonApi();

        for(int i = 1; i <= 10; i++){
            try{

                logger.debug("Get pokemon api");
                Pokemon pokemon = pokemonApi.getById(i);
                piokemonList.add(pokemon);
            }catch(PokemonNotFound e){
                logger.error("Error: " + e);
            }
        }
        return piokemonList;
    }

    public List<Pokemon> getAll(){
        return listPokemon;
    }
    public Pokemon getByIndex(int index){ return listPokemon.get(index); }
    public Optional<Pokemon> getByIndexWithOptional(int index){
        if (index >= 0 && index < listPokemon.size()) {
            Pokemon pokemon = listPokemon.get(index);
            return Optional.ofNullable(pokemon);
        } else {
            return Optional.empty();
        }
    }
    public void addPokemon(Pokemon pokemon) { listPokemon.add(pokemon); }
    public Pokemon removeByIndex(int index) {
        if(index < 0 || index >= listPokemon.size()) throw new PokemonNotFound("Pokemon não encontrado.");
        return listPokemon.remove(index);
    }
    public void updatePokemon(int index, Pokemon pokemon){
        logger.info("Update Pokemon index: " + index);
        listPokemon.set(index, pokemon);
    }

    public Object getSprites(int id, String position) {
        logger.info("GET SPRITES");
        Pokemon pokemon = listPokemon.get(id);
        if(Objects.equals(position, "Front")){
            return new HashMap<String, Object>(){{
                put("frontDefault", pokemon.getSprites().getFrontDefault());
                put("frontFemale", pokemon.getSprites().getFrontDefault());
            }};
        }
        if(Objects.equals(position, "Back")){
            return new HashMap<String, Object>(){{
                put("backDefault", pokemon.getSprites().getBackDefault());
                put("backFemale", pokemon.getSprites().getBackFemale());
            }};
        }
        throw new PokemonNotFound("Sprites not found!");
    }
}
