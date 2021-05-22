package com.github.joaopedrosantossilva.cidadesapi.paises.resources;

import com.github.joaopedrosantossilva.cidadesapi.paises.Pais;
import com.github.joaopedrosantossilva.cidadesapi.paises.repository.PaisRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/paises")
public class ResourcePais {


    private PaisRepository repositorio;

    public ResourcePais(PaisRepository repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping
    public Page<Pais> paises(Pageable page){

        return repositorio.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable long id){
        Optional<Pais> optional = repositorio.findById(id);
        if (optional.isPresent()){
        return ResponseEntity.ok().body(optional.get());
        }else{
            return ResponseEntity.notFound().build();

        }
    }
}
