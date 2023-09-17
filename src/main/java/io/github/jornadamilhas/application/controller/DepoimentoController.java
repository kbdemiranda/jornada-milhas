package io.github.jornadamilhas.application.controller;

import io.github.jornadamilhas.application.dto.depoimentos.DepoimentoDTOInput;
import io.github.jornadamilhas.application.dto.depoimentos.DepoimentoDTOOutput;
import io.github.jornadamilhas.application.service.DepoimentoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/depoimentos")
public class DepoimentoController {

    private final DepoimentoService depoimentoService;
    public DepoimentoController(DepoimentoService depoimentoService) {
        this.depoimentoService = depoimentoService;
    }

    @GetMapping
    public ResponseEntity<?> listarDepoimentos(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size
    ) {
        Page<DepoimentoDTOOutput> outputs = depoimentoService.listarDepoimentos(PageRequest.of(page, size));
        return ResponseEntity.ok(outputs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarDepoimento(@PathVariable Long id) {
        DepoimentoDTOOutput depoimento = depoimentoService.detalharDepoimento(id);
        return ResponseEntity.ok(depoimento);
    }

    @PostMapping
    public ResponseEntity<?> salvarDepoimento(@ModelAttribute @Valid DepoimentoDTOInput dto) {
        DepoimentoDTOOutput depoimento = depoimentoService.salvarDepoimento(dto);
        return ResponseEntity.created(URI.create("/api/depoimentos/" + depoimento.getId())).body(depoimento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarDepoimento(@PathVariable Long id, @ModelAttribute @Valid DepoimentoDTOInput dto) {
        DepoimentoDTOOutput depoimento = depoimentoService.atualizarDepoimento(id, dto);
        return ResponseEntity.created(URI.create("/api/depoimentos/" + depoimento.getId())).body(depoimento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerDepoimento(@PathVariable Long id) {
        depoimentoService.excluirDepoimento(id);
        return ResponseEntity.noContent().build();
    }
}
