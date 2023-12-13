package br.com.infnet.PokemonApiSpring.service;

import br.com.infnet.PokemonApiSpring.exception.AbilityNotFound;
import br.com.infnet.PokemonApiSpring.model.Ability;
import br.com.infnet.PokemonApiSpring.model.Pokemon;
import br.com.infnet.PokemonApiSpring.util.AbilityPokemonApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AbilityService {
    Logger logger = LoggerFactory.getLogger(AbilityService.class);
    private List<Ability> listAbility = initAbility();

    private List<Ability> initAbility() {
        logger.info("Get 5 Ability's");
        ArrayList<Ability> abilitys = new ArrayList<>();
        AbilityPokemonApi abilityPokemonApi = new AbilityPokemonApi();

        for(int i = 1; i <= 5; i++){
            logger.debug("Get " + i + " ability");
            try{
                Ability ability = abilityPokemonApi.getAbilityById(i);
                abilitys.add(ability);
            }catch(AbilityNotFound e){
                logger.error("Error: " + e);
            }

        }
        return abilitys;
    }

    public List<Ability> getAll() { return listAbility; }
    public void addAbility(Ability ability) { listAbility.add(ability); }
    public void removeById(int id) { listAbility.remove(id); }
    public void updateAbility(int id, Ability ability) {
        listAbility.set(id, ability);
    }
}
