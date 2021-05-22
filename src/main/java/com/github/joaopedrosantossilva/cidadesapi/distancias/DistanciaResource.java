package com.github.joaopedrosantossilva.cidadesapi.distancias;

import com.github.joaopedrosantossilva.cidadesapi.distancias.service.DistanciaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/distancias")
public class DistanciaResource {

    private final DistanciaService service;
    Logger log = LoggerFactory.getLogger(DistanciaResource.class);

    public DistanciaResource(DistanciaService service) {
        this.service = service;
    }

    @GetMapping("/by-points")
    public ResponseEntity byPoints(@RequestParam(name = "from") final Long cidade1,
                           @RequestParam(name = "to") final Long cidade2) {
        log.info("byPoints");
        return  ResponseEntity.ok().body(service.distanceByPointsInMiles(cidade1, cidade2));
    }

    @GetMapping("/by-cube")
    public ResponseEntity byCube(@RequestParam(name = "from") final Long cidade1,
                                 @RequestParam(name = "to") final Long cidade2) {
        log.info("byCube");
        return ResponseEntity.ok().body(service.distanceByCubeInMeters(cidade1, cidade2));
    }

}
