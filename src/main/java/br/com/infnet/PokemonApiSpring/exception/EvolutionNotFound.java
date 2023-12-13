package br.com.infnet.PokemonApiSpring.exception;

public class EvolutionNotFound extends RuntimeException {
    public EvolutionNotFound(){}
    public EvolutionNotFound(String message) {
        super(message);
    }
}
