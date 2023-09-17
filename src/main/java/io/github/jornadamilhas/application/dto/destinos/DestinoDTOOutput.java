package io.github.jornadamilhas.application.dto.destinos;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class DestinoDTOOutput {

    private Long id;
    private String nome;
    private String foto;
    private BigDecimal valor;

}
