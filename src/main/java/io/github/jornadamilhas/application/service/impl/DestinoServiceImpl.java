package io.github.jornadamilhas.application.service.impl;

import io.github.jornadamilhas.Infrastructure.jpa.DestinoRepository;
import io.github.jornadamilhas.application.dto.destinos.DestinoDTOInput;
import io.github.jornadamilhas.application.dto.destinos.DestinoDTOOutput;
import io.github.jornadamilhas.application.exception.JornadaMilhasException;
import io.github.jornadamilhas.application.service.DestinoService;
import io.github.jornadamilhas.application.service.FotoService;
import io.github.jornadamilhas.domain.model.Destino;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class DestinoServiceImpl implements DestinoService {


    private final DestinoRepository destinoRepository;
    private final FotoService fotoService;
    private final ModelMapper modelMapper = new ModelMapper();

    public DestinoServiceImpl(DestinoRepository destinoRepository, FotoService fotoService) {
        this.destinoRepository = destinoRepository;
        this.fotoService = fotoService;
    }

    @Override
    public Page<DestinoDTOOutput> listarDestinos(String nomeDestino, Pageable pageable) {
        Page<Destino> destinos = destinoRepository.findByNomeDestino(nomeDestino, pageable);
        return destinos.map(destino -> modelMapper.map(destino, DestinoDTOOutput.class));
    }

    @Override
    public DestinoDTOOutput detalharDestino(Long id) {
        Destino destino = getDestino(id);
        return modelMapper.map(destino, DestinoDTOOutput.class);
    }

    @Override
    public DestinoDTOOutput cadastrarDestino(DestinoDTOInput dtoInput) {
        Destino destino = Destino.builder()
                .nomeDestino(dtoInput.getNome())
                .foto(fotoService.salvarFoto(dtoInput.getFoto()))
                .valor(dtoInput.getValor())
                .build();

        Destino d = destinoRepository.save(destino);

        return modelMapper.map(d, DestinoDTOOutput.class);
    }

    @Override
    public DestinoDTOOutput atualizarDestino(Long id, DestinoDTOInput dtoInput) {
        Destino destino = getDestino(id);
        destino.setNomeDestino(dtoInput.getNome());
        destino.setFoto(fotoService.salvarFoto(dtoInput.getFoto()));
        destino.setValor(dtoInput.getValor());
        Destino d = destinoRepository.save(destino);
        return modelMapper.map(d, DestinoDTOOutput.class);
    }

    @Override
    public void excluirDestino(Long id) {
        Destino destino = getDestino(id);
        destinoRepository.delete(destino);
    }

    private Destino getDestino(Long id){
        return destinoRepository.findById(id).orElseThrow(() -> new JornadaMilhasException(HttpStatus.NOT_FOUND, "Destino não encontrado"));
    }
}
