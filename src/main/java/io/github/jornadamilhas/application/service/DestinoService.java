package io.github.jornadamilhas.application.service;

import io.github.jornadamilhas.application.dto.destinos.DestinoDTOInput;
import io.github.jornadamilhas.application.dto.destinos.DestinoDTOOutput;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DestinoService {

    Page<DestinoDTOOutput> listarDestinos(String nomeDestino, Pageable pageable);
    DestinoDTOOutput detalharDestino(Long id);
    DestinoDTOOutput cadastrarDestino(DestinoDTOInput dtoInput);
    DestinoDTOOutput atualizarDestino(Long id, DestinoDTOInput dtoInput);
    void excluirDestino(Long id);

}
