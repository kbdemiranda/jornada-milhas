package io.github.jornadamilhas.application.dto.destinos;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class DestinoDTOInput {

    @NotEmpty @NotBlank
    private String nome;
    @NotEmpty @NotBlank @Max(value = 160, message = "A meta deve ter no máximo 160 caracteres")
    private String meta;
    @NotNull
    private MultipartFile fotoPrincipal;
    @NotNull
    private MultipartFile fotoSecundaria;
    @NotNull
    private BigDecimal valor;
    private String descricao;

}
