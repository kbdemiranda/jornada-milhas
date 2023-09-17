package io.github.jornadamilhas.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

import static io.github.jornadamilhas.domain.enuns.JornadaMilhas.SCHEMA;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

@Entity
@Table(name = "destinos", schema = SCHEMA)
public class Destino {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome_destino", nullable = false)
    private String nomeDestino;
    @Column(name = "foto", nullable = false)
    private String foto;
    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

}
