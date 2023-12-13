package br.com.infnet.PokemonApiSpring.controllers;


import br.com.infnet.PokemonApiSpring.exception.PokemonNotFound;
import br.com.infnet.PokemonApiSpring.model.Pokemon;
import br.com.infnet.PokemonApiSpring.model.payload.ResponsePayload;
import br.com.infnet.PokemonApiSpring.service.PokemonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    PokemonService pokemonService;

    Logger logger = LoggerFactory.getLogger(PokemonService.class);
    @GetMapping
    public List<Pokemon> getAll(){
        logger.info("GET ALL CLIENTS");
        return pokemonService.getAll();
    }

    @GetMapping("/sprites")
    public Object getSprites(
            @RequestParam(required = false, name="id") int id,
            @RequestParam(required = false, name="position") String position
    ){
        logger.info("GET SPRITES");
        try{
            return pokemonService.getSprites(id, position);
        }catch(PokemonNotFound e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponsePayload(e.getMessage()));
        }
    }

    @GetMapping("/{index}")
    public ResponseEntity getById(@PathVariable int index){
        logger.info("GET POKEMON" + index);
        try{
            Pokemon pokemon = pokemonService.getByIndexWithOptional(index)
                    .orElseThrow(() -> new PokemonNotFound("Index não encontrado."));
            return ResponseEntity.ok(pokemon);
        }catch(PokemonNotFound e){
            logger.error("Pokemon not found", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponsePayload(e.getMessage()));
        }
    }
    @PostMapping
    public String savePokemon(@RequestBody Pokemon pokemon){
        logger.info("ADD POKEMON " + pokemon);
        pokemonService.addPokemon(pokemon);
        return "Pokemon Add Success!";
    }
    @DeleteMapping("/{index}")
    public ResponseEntity delete(@PathVariable int index){
        logger.info("DELETE POKEMON INDEX:  " + index);
        try{
            Pokemon removed = pokemonService.removeByIndex(index);
            return ResponseEntity.ok(removed);
        }catch(PokemonNotFound e){
            logger.error("Pokemon not found", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponsePayload(e.getMessage()));
        }
    }
    @PutMapping("/{index}")
    public String update(@PathVariable int index, @RequestBody Pokemon pokemon){
        logger.info("UPDATE POKEMON: " + index + " " + pokemon);
        pokemonService.updatePokemon(index, pokemon);
        return "Modific success!";
    }
}
