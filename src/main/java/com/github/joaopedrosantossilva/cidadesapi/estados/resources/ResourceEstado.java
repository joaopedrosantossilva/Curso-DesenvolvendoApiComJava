package com.github.joaopedrosantossilva.cidadesapi.estados.resources;

import com.github.joaopedrosantossilva.cidadesapi.estados.Estado;
import com.github.joaopedrosantossilva.cidadesapi.estados.repository.EstadoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estado")
public class ResourceEstado {

    private final EstadoRepository repository;

    public ResourceEstado(final EstadoRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Estado> estados() {
        return repository.findAll();
    }
}
