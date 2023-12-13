package br.com.infnet.PokemonApiSpring.service;

import br.com.infnet.PokemonApiSpring.exception.EvolutionNotFound;
import br.com.infnet.PokemonApiSpring.model.Evolution;
import br.com.infnet.PokemonApiSpring.model.Item;
import br.com.infnet.PokemonApiSpring.util.EvolutionApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EvolutionService {
    Logger logger = LoggerFactory.getLogger(EvolutionService.class);
    protected List<Evolution> listEvolution = initEvolution();

    private List<Evolution> initEvolution() {
        logger.info("5 Evolutions");
        ArrayList<Evolution> evolutions = new ArrayList<>();
        EvolutionApi evolutionApi = new EvolutionApi();
        for(int i = 1; i <= 5; i++){
            logger.debug("Get " + i + " Evolution");
            try{
                Evolution evolution = evolutionApi.getId(i);
                evolutions.add(evolution);
            }catch(EvolutionNotFound e){
                logger.error("Error: " + e);
            }
        }
        return evolutions;
    }

    public List<Evolution> getAll() { return listEvolution; }
    public void addEvolution(Evolution evolution) { listEvolution.add(evolution); }
    public void removeById(int id) { listEvolution.remove(id); }
    public void updateEvolution(int id, Evolution evolution) {
        listEvolution.set(id, evolution);
    }

}
