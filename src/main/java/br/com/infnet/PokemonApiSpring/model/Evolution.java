package br.com.infnet.PokemonApiSpring.model;

import lombok.Data;

@Data
public class Evolution {
    private Object babyTriggerItem;
    private Object chain;
    private int id;

    public Object getBaby_trigger_item() {
        return babyTriggerItem;
    }
    public void setBaby_trigger_item(Object babyTriggerItem) { this.babyTriggerItem = babyTriggerItem; }
}
