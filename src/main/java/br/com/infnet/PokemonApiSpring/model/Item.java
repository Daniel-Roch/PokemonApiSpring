package br.com.infnet.PokemonApiSpring.model;

import lombok.Data;

import java.util.List;

@Data
public class Item {
    private List<Object> attributes;
    private Object babyTriggerFor;
    private Object category;
    private int cost;
    private List<Object> effectEntries;
    private List<Object> flavorTextEntries;
    private List<Object> flingEffect;
    private List<Object> flingPower;
    private List<Object> gameIndices;
    private List<Object> heldByPokemon;
    private int id;
    private List<Object> machines;
    private String name;
    private List<Object> names;
    private Object sprites;

    public Object getBaby_trigger_for() {
        return babyTriggerFor;
    }
    public void setBaby_trigger_for(Object babyTriggerFor) { this.babyTriggerFor = babyTriggerFor; }

    public List<Object> getEffect_entries() {
        return effectEntries;
    }
    public void setEffect_entries(List<Object> effectEntries) { this.effectEntries = effectEntries; }

    public List<Object> getFlavor_text_entries() {
        return flavorTextEntries;
    }
    public void setFlavor_text_entries(List<Object> flavorTextEntries) { this.flavorTextEntries = flavorTextEntries; }

    public List<Object> getFling_effect() {
        return flingEffect;
    }
    public void setFling_effects(List<Object> flingEffect) { this.flingEffect = flingEffect; }

    public List<Object> getFling_power() {
        return flingPower;
    }
    public void setFling_power(List<Object> flingPower) { this.flingPower = flingPower; }

    public List<Object> getGame_indices() {
        return gameIndices;
    }
    public void setGame_indices(List<Object> gameIndices) { this.gameIndices = gameIndices; }

    public List<Object> getHeld_by_pokemon() {
        return heldByPokemon;
    }
    public void setHeld_by_pokemon(List<Object> heldByPokemon) { this.heldByPokemon = heldByPokemon; }
}
