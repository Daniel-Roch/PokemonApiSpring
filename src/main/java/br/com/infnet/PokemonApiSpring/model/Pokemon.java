package br.com.infnet.PokemonApiSpring.model;

import lombok.Data;

import java.util.List;

@Data
public class Pokemon {
    private int id;
    private List<Object> abilities;
    private List<Object> forms;
    private List<Object> gameIndices;
    private List<Object> heldItems;
    private List<Object> moves;
    private List<Object> pastAbilities;
    private List<Object> pastTypes;
    private Object species;
    private PokemonSprites sprites;
    private List<Object> stats;
    private List<Object> types;
    private String name;
    private int order;
    private int weight;
    private int height;
    private int baseExperience;
    private String isDefault;
    private String locationAreaEncounters;

    public List<Object> getGame_indices() {
        return gameIndices;
    }

    public void setGame_indices(List<Object> gameIndices) {
        this.gameIndices = gameIndices;
    }

    public List<Object> getHeld_items() {
        return heldItems;
    }

    public void setHeld_items(List<Object> heldItems) {
        this.heldItems = heldItems;
    }

    public List<Object> getPast_abilities() {
        return pastAbilities;
    }

    public void setPast_abilities(List<Object> pastAbilities) {
        this.pastAbilities = pastAbilities;
    }

    public List<Object> getPast_types() {
        return pastTypes;
    }

    public void setPast_types(List<Object> pastTypes) {
        this.pastTypes = pastTypes;
    }

    public int getBase_experience() {
        return baseExperience;
    }

    public void setBase_experience(int baseExperience) {
        this.baseExperience = baseExperience;
    }

    public String getIs_default() {
        return isDefault;
    }

    public void setIs_default(String isDefault) {
        this.isDefault = isDefault;
    }

    public String getLocation_area_encounters() {
        return locationAreaEncounters;
    }

    public void setLocation_area_encounters(String locationAreaEncounters) {
        this.locationAreaEncounters = locationAreaEncounters;
    }
}
