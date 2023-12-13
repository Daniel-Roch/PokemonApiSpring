package br.com.infnet.PokemonApiSpring.exception;

public class ItemNotFound extends RuntimeException {
    public ItemNotFound(){}
    public ItemNotFound(String message) { super(message); }
}
