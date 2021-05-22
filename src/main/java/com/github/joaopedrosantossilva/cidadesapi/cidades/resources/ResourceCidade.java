package com.github.joaopedrosantossilva.cidadesapi.cidades.resources;

import com.github.joaopedrosantossilva.cidadesapi.cidades.Cidade;
import com.github.joaopedrosantossilva.cidadesapi.cidades.repository.CidadeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cidades")
public class ResourceCidade {

    private final CidadeRepository repository;

    public ResourceCidade(final CidadeRepository repository) {
        this.repository = repository;
    }

  /* 1st
  @GetMapping
  public List<City> cities() {
      return repository.findAll();
  }*/

    // 2nd - Pageable
    @GetMapping
    public Page<Cidade> cidades(final Pageable page) {
        return repository.findAll(page);
    }
}
