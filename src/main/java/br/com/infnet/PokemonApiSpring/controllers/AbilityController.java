package br.com.infnet.PokemonApiSpring.controllers;


import br.com.infnet.PokemonApiSpring.model.Ability;
import br.com.infnet.PokemonApiSpring.service.AbilityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ability")
public class AbilityController {
    @Autowired
    AbilityService abilityService;
    Logger logger = LoggerFactory.getLogger(AbilityService.class);

    @GetMapping
    public List<Ability> getAll(){
        logger.info("GET ALL ABILITY");
        return abilityService.getAll();
    }

    @PostMapping
    public String saveAbility(@RequestBody Ability ability){
        logger.info("ADD ABILITY");
        abilityService.addAbility(ability);
        return "Ability add success";
    }

    @DeleteMapping("/{id}")
    public void deleteAbility(@PathVariable int id){
        logger.info("DELETE ABILITY INDEX: " + id);
        abilityService.removeById(id);
    }

    @PutMapping("/{id}")
    public void updateAbility(@PathVariable int id, @RequestBody Ability ability){
        logger.info("UPDATE ABILITY INDEX: " + id);
        abilityService.updateAbility(id, ability);
    }

}
