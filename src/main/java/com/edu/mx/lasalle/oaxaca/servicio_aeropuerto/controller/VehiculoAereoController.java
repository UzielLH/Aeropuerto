package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.AvionModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.AvionetaModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.HelicopteroModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.VehiculoAereoModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.AvionModelService;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.AvionetaModelService;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.HelicopteroModelService;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.VehiculoAereoModelService;

@RestController
@RequestMapping("/api/vehiculoAereo")
@CrossOrigin(origins = "*")
public class VehiculoAereoController {

    @Autowired
    private VehiculoAereoModelService vehiculoAereoService;

    @Autowired
    private AvionModelService avionService;

    @Autowired
    private AvionetaModelService avionetaService;

    @Autowired
    private HelicopteroModelService helicopteroService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        List<VehiculoAereoModel> vehiculoAereo = vehiculoAereoService.obtenerVehiculosAereos();
        if (vehiculoAereo.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay vehiculos aereos registrados");
        }
        return ResponseEntity.status(HttpStatus.OK).body(vehiculoAereo);
    }

    @GetMapping("{matricula}")
    public ResponseEntity<?> getVehiculoAereo(@PathVariable int matricula) {
        VehiculoAereoModel vehiculoAereo = vehiculoAereoService.getVehiculoAereo(matricula).orElse(null);
        if (vehiculoAereo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el vehiculo aereo");
        }
        return ResponseEntity.status(HttpStatus.OK).body(vehiculoAereo);
    }

    @PostMapping("/create/avion")
    public ResponseEntity<?> createAvion(@RequestBody AvionModel avionModel) {
        AvionModel avion = avionService.registrarAvion(avionModel);
        if (avion == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo registrar el vehiculo aereo");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(avion);
    }

    @PostMapping("/create/avioneta")
    public ResponseEntity<?> createAvioneta(@RequestBody AvionetaModel avionetaModel) {
        AvionetaModel avioneta = avionetaService.registrarAvioneta(avionetaModel);
        if (avioneta == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo registrar el vehiculo aereo");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(avioneta);
    }

    @PostMapping("/create/helicoptero")
    public ResponseEntity<?> createHelicoptero(@RequestBody HelicopteroModel helicopteroModel) {
        HelicopteroModel helicoptero = helicopteroService.registrarHelicoptero(helicopteroModel);
        if (helicoptero == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo registrar el vehiculo aereo");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(helicoptero);
    }

    @PutMapping("/update/{matricula}")
    public ResponseEntity<?> updateVehiculoAereo(@PathVariable int matricula,
            @RequestBody VehiculoAereoModel vehiculoAereoModel) {
        VehiculoAereoModel vehiculoAereo = vehiculoAereoService
                .actualizarDatosVehiculoAereo(vehiculoAereoModel, matricula).orElse(null);
        if (vehiculoAereo == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo actualizar el vehiculo aereo");
        }
        return ResponseEntity.status(HttpStatus.OK).body(vehiculoAereo);
    }

    @DeleteMapping("/delete/{matricula}")
    public ResponseEntity<?> deleteVehiculoAereo(@PathVariable int matricula) {
        VehiculoAereoModel vehiculoAereo = vehiculoAereoService.borrarVehiculoAereo(matricula).orElse(null);
        if (vehiculoAereo == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo borrar el vehiculo aereo");
        }
        return ResponseEntity.status(HttpStatus.OK).body(vehiculoAereo);
    }
}
