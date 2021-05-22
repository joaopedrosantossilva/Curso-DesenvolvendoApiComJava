package com.github.joaopedrosantossilva.cidadesapi.cidades.repository;

import com.github.joaopedrosantossilva.cidadesapi.cidades.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    @Query(value = "SELECT ((SELECT lat_lon FROM cidade WHERE id=?1) <@> (SELECT lat_lon FROM cidade WHERE id=?2)) as distance", nativeQuery = true)
    Double distanciaPorPontos(Long cidade1, Long cidade2);

    @Query(value = "SELECT earth_distance(ll_to_earth(?1,?2), ll_to_earth(?3,?4)) as distance", nativeQuery = true)
    Double distanciaPorCube(double x, double y, double x1, double y1);
}
