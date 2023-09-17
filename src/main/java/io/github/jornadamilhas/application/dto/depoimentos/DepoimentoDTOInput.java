package io.github.jornadamilhas.application.dto.depoimentos;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class DepoimentoDTOInput{

    @NotEmpty @NotBlank
    private String nome;
    @NotEmpty @NotBlank
    private String depoimento;
    @NotNull
    private MultipartFile foto;

}
