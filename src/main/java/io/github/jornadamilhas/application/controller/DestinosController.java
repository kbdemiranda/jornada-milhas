package io.github.jornadamilhas.application.controller;

import io.github.jornadamilhas.application.dto.destinos.DestinoDTOInput;
import io.github.jornadamilhas.application.dto.destinos.DestinoDTOOutput;
import io.github.jornadamilhas.application.service.DestinoService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/destinos")
public class DestinosController {


    private final DestinoService destinoService;

    public DestinosController(DestinoService destinoService) {
        this.destinoService = destinoService;
    }

    @GetMapping
    public ResponseEntity<?> listarDestinos(
            @RequestParam(value = "nomeDestino", required = false) String nomeDestino,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size
    ) {
        return ResponseEntity.ok(destinoService.listarDestinos(nomeDestino, PageRequest.of(page, size)));
    }

    @PostMapping
    public ResponseEntity<?> criarDestino(@ModelAttribute DestinoDTOInput dtoInput) {
        DestinoDTOOutput output = destinoService.cadastrarDestino(dtoInput);
        return ResponseEntity.created(URI.create("/api/destinos/" + output.getId())).body(output);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalharDestino(@PathVariable("id") Long id) {
        return ResponseEntity.ok(destinoService.detalharDestino(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarDestino(@PathVariable("id") Long id, @ModelAttribute DestinoDTOInput dtoInput) {
        DestinoDTOOutput output = destinoService.atualizarDestino(id, dtoInput);
        return ResponseEntity.created(URI.create("/api/destinos/" + output.getId())).body(output);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerDestino(@PathVariable("id") Long id) {
        destinoService.excluirDestino(id);
        return ResponseEntity.noContent().build();
    }
}
