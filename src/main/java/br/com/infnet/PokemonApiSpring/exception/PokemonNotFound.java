package br.com.infnet.PokemonApiSpring.exception;

public class PokemonNotFound extends RuntimeException {
    public PokemonNotFound() {
    }

    public PokemonNotFound(String message) {
        super(message);
    }
}
