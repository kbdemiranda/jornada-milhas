package io.github.jornadamilhas.application.service;

import io.github.jornadamilhas.application.dto.depoimentos.DepoimentoDTOInput;
import io.github.jornadamilhas.application.dto.depoimentos.DepoimentoDTOOutput;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DepoimentoService {

    Page<DepoimentoDTOOutput> listarDepoimentos(Pageable pageable);
    DepoimentoDTOOutput detalharDepoimento(Long id);
    DepoimentoDTOOutput salvarDepoimento(DepoimentoDTOInput dto);
    DepoimentoDTOOutput atualizarDepoimento(Long id, DepoimentoDTOInput dto);
    void excluirDepoimento(Long id);

}
