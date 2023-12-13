package br.com.infnet.PokemonApiSpring.model;

import lombok.Data;

@Data
public class PokemonSprites {
    private String backDefault;
    private String backFemale;
    private String backShiny;
    private String backShinyFemale;
    private String frontDefault;
    private String frontFemale;
    private String frontShiny;
    private String frontShinyFemale;
    private Object other;
    private Object versions;

    public String getBack_default() {
        return backDefault;
    }

    public void setBack_default(String backDefault) {
        this.backDefault = backDefault;
    }

    public String getBack_female() {
        return backFemale;
    }

    public void setBack_female(String backFemale) {
        this.backFemale = backFemale;
    }

    public String getBack_shiny() {
        return backShiny;
    }

    public void setBack_shiny(String backShiny) {
        this.backShiny = backShiny;
    }

    public String getBack_shiny_female() {
        return backShinyFemale;
    }

    public void setBack_shiny_female(String backShinyFemale) {
        this.backShinyFemale = backShinyFemale;
    }

    public String getFront_default() {
        return frontDefault;
    }

    public void setFront_default(String frontDefault) {
        this.frontDefault = frontDefault;
    }

    public String getFront_female() {
        return frontFemale;
    }

    public void setFront_female(String frontFemale) {
        this.frontFemale = frontFemale;
    }

    public String getFront_shiny() {
        return frontShiny;
    }

    public void setFront_shiny(String frontShiny) {
        this.frontShiny = frontShiny;
    }

    public String getFront_shiny_female() {
        return frontShinyFemale;
    }

    public void setFront_shiny_female(String frontShinyFemale) {
        this.frontShinyFemale = frontShinyFemale;
    }


//    public String back_default() { return backDefault; }
//    public String back_female() { return backFemale; }
//    public String back_shiny() { return backShiny; }
//    public String back_shiny_female() { return backShinyFemale; }
//    public String front_default() { return frontDefault; }
//    public String front_female() { return frontFemale; }
//    public String front_shiny() { return frontShiny; }
//    public String front_shiny_female() { return frontShinyFemale; }
}
