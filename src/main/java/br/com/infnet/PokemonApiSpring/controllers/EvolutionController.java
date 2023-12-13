package br.com.infnet.PokemonApiSpring.controllers;

import br.com.infnet.PokemonApiSpring.model.Evolution;
import br.com.infnet.PokemonApiSpring.service.EvolutionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evolution")
public class EvolutionController {
    @Autowired
    EvolutionService evolutionService;
    Logger logger = LoggerFactory.getLogger(EvolutionController.class);

    @GetMapping
    public List<Evolution> getAll(){
        logger.info("GET EVOLUTION EVOLUTION");
        return evolutionService.getAll();
    }

    @PostMapping
    public String saveEvolution(@RequestBody Evolution evolution){
        logger.info("ADD EVOLUTION");
        evolutionService.addEvolution(evolution);
        return "Evolution add success";
    }

    @DeleteMapping("/{id}")
    public void deleteEvolution(@PathVariable int id){
        logger.info("DELETE EVOLUTION ID: " + id);
        evolutionService.removeById(id);
    }

    @PutMapping("/{id}")
    public void updateEvolution(@PathVariable int id, @RequestBody Evolution evolution){
        logger.info("UPDATE EVOLUTION ID: " + id);
        evolutionService.updateEvolution(id, evolution);
    }
}
