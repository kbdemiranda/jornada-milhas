package io.github.jornadamilhas.application.service.impl;

import io.github.jornadamilhas.Infrastructure.jpa.DepoimentoRepository;
import io.github.jornadamilhas.application.dto.depoimentos.DepoimentoDTOInput;
import io.github.jornadamilhas.application.dto.depoimentos.DepoimentoDTOOutput;
import io.github.jornadamilhas.application.exception.JornadaMilhasException;
import io.github.jornadamilhas.application.service.DepoimentoService;
import io.github.jornadamilhas.application.service.FotoService;
import io.github.jornadamilhas.domain.model.Depoimento;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class DepoimentoServiceImpl implements DepoimentoService {

    private final DepoimentoRepository depoimentoRepository;
    private final FotoService fotoService;

    private final ModelMapper modelMapper = new ModelMapper();

    public DepoimentoServiceImpl(DepoimentoRepository depoimentoRepository, FotoService fotoService) {
        this.depoimentoRepository = depoimentoRepository;
        this.fotoService = fotoService;
    }


    @Override
    public Page<DepoimentoDTOOutput> listarDepoimentos(Pageable pageable) {
        Page<Depoimento> depoimentos = depoimentoRepository.findAll(pageable);
        return depoimentos.map(depoimento -> modelMapper.map(depoimento, DepoimentoDTOOutput.class));
    }

    @Override
    public DepoimentoDTOOutput detalharDepoimento(Long id) {
        Depoimento depoimento = getDepoimento(id);
        return modelMapper.map(depoimento, DepoimentoDTOOutput.class);
    }

    @Override
    public DepoimentoDTOOutput salvarDepoimento(DepoimentoDTOInput dto) {
        Depoimento depoimento = Depoimento.builder()
                .nome(dto.getNome())
                .depoimento(dto.getDepoimento())
                .foto(fotoService.salvarFoto(dto.getFoto()))
                .build();
        Depoimento d = depoimentoRepository.save(depoimento);
        return modelMapper.map(d, DepoimentoDTOOutput.class);
    }

    @Override
    public DepoimentoDTOOutput atualizarDepoimento(Long id, DepoimentoDTOInput dto) {
        Depoimento depoimento = getDepoimento(id);
        depoimento.setNome(dto.getNome());
        depoimento.setDepoimento(dto.getDepoimento());
        depoimento.setFoto(fotoService.salvarFoto(dto.getFoto()));
        Depoimento d = depoimentoRepository.save(depoimento);
        return modelMapper.map(d, DepoimentoDTOOutput.class);
    }

    @Override
    public void excluirDepoimento(Long id) {
        Depoimento depoimento = getDepoimento(id);
        depoimentoRepository.delete(depoimento);
    }

    private Depoimento getDepoimento(Long id) {
        return depoimentoRepository.findById(id)
                .orElseThrow(() -> new JornadaMilhasException(NOT_FOUND, "Depoimento não encontrado"));
    }
}
