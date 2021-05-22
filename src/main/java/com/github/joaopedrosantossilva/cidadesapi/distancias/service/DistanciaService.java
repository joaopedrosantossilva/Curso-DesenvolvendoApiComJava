package com.github.joaopedrosantossilva.cidadesapi.distancias.service;

import com.github.joaopedrosantossilva.cidadesapi.cidades.Cidade;
import com.github.joaopedrosantossilva.cidadesapi.cidades.repository.CidadeRepository;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;


@Service
public class DistanciaService {

    Logger log = LoggerFactory.getLogger(DistanciaService.class);
    private final CidadeRepository cidadeRepository;

    public DistanciaService(final CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    public Double distanceByPointsInMiles(final Long cidade1, final Long cidade2) {
        log.info("nativePostgresInMiles({}, {})", cidade1, cidade2);
        return cidadeRepository.distanciaPorPontos(cidade1, cidade2);
    }

    public Double distanceByCubeInMeters(Long city1, Long city2) {
        log.info("distanceByCubeInMeters({}, {})", city1, city2);
        final List<Cidade> cities = cidadeRepository.findAllById((Arrays.asList(city1, city2)));

        Point p1 = cities.get(0).getLocation();
        Point p2 = cities.get(1).getLocation();

        return cidadeRepository.distanciaPorCube(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }
}
