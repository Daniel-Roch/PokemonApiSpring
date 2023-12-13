package br.com.infnet.PokemonApiSpring.model.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResponsePayload {
    private String message;
    private LocalDateTime dataHora;
    public ResponsePayload(String message){
        this.message = message;
        this.dataHora = LocalDateTime.now();
    }
}
