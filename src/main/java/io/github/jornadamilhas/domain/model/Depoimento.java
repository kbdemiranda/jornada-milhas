package io.github.jornadamilhas.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import static io.github.jornadamilhas.domain.enuns.JornadaMilhas.SCHEMA;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

@Entity
@Table(name = "depoimentos", schema = SCHEMA)
public class Depoimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String depoimento;
    private String foto;
}
