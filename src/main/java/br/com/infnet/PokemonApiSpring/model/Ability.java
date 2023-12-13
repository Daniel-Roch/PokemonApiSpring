package br.com.infnet.PokemonApiSpring.model;

import lombok.Data;

import java.util.List;

@Data
public class Ability {
    private List<Object> effectChanges;
    private List<Object> effectEntries;
    private List<Object> flavorTextEntries;
    private Object generation;
    private int id;
    private String isMainSeries;
    private String name;
    private List<Object> names;
    private List<Object> pokemon;

    public List<Object> getEffect_entries() {
        return effectEntries;
    }

    public void setEffect_entries(List<Object> effectEntries) {
        this.effectEntries = effectEntries;
    }

    public List<Object> getFlavor_text_entries() {
        return flavorTextEntries;
    }

    public void setFlavor_text_entries(List<Object> flavorTextEntries) {
        this.flavorTextEntries = flavorTextEntries;
    }

    public String getIs_main_series() {
        return isMainSeries;
    }

    public void setIs_main_series(String isMainSeries) {
        this.isMainSeries = isMainSeries;
    }

    public List<Object> getEffect_changes() {
        return effectChanges;
    }

    public void setEffect_changes(List<Object> effectChanges) {
        this.effectChanges = effectChanges;
    }
}
