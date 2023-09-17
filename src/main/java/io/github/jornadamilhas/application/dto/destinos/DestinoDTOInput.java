package io.github.jornadamilhas.application.dto.destinos;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class DestinoDTOInput {

    @NotEmpty @NotBlank
    private String nome;
    @NotNull
    private MultipartFile foto;
    @NotNull
    private BigDecimal valor;

}
