package io.github.jornadamilhas.application.dto.destinos;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class DestinoDTOOutput {

    private Long id;
    private String nome;
    private String meta;
    private String fotoPrincipal;
    private String fotoSecundaria;
    private BigDecimal valor;
    private String descricao;

}
