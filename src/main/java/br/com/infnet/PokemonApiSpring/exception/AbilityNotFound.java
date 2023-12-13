package br.com.infnet.PokemonApiSpring.exception;

public class AbilityNotFound extends RuntimeException  {
    public AbilityNotFound(String message) {
        super(message);
    }
}
