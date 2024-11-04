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

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.CopilotoModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.PilotoModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.SobrecargoModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.TripulacionModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.CopilotoService;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.PilotoService;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.SobrecargoService;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.TripulacionService;

@RestController
@RequestMapping("/api/tripulacion")
@CrossOrigin(origins = "*")
public class TripulacionController {

    @Autowired
    private TripulacionService tripulacionService;

    @Autowired
    private CopilotoService copilotoService;

    @Autowired
    private PilotoService pilotoService;

    @Autowired
    private SobrecargoService sobrecargoService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        List<TripulacionModel> tripulacion = tripulacionService.obtenerTripulacion();
        if (tripulacion.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay tripulacion registrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(tripulacion);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getTripulacion(@PathVariable int id) {
        TripulacionModel tripulacion = tripulacionService.getTripulacion(id).orElse(null);
        if (tripulacion == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro la tripulacion");
        }
        return ResponseEntity.status(HttpStatus.OK).body(tripulacion);
    }

    @PostMapping("/create/piloto")
    public ResponseEntity<?> createPiloto(@RequestBody PilotoModel pilotoModel) {
        PilotoModel piloto = pilotoService.registrarPiloto(pilotoModel);
        if (piloto == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo registrar la tripulacion");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(piloto);
    }

    @PostMapping("/create/copiloto")
    public ResponseEntity<?> createCopiloto(@RequestBody CopilotoModel copilotoModel) {
        CopilotoModel copiloto = copilotoService.registrarCopiloto(copilotoModel);
        if (copiloto == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo registrar la tripulacion");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(copiloto);
    }

    @PostMapping("/create/sobrecargo")
    public ResponseEntity<?> createSobreCargo(@RequestBody SobrecargoModel sobrecargoModel) {
        SobrecargoModel sobrecargo = sobrecargoService.registrarSobrecargo(sobrecargoModel);
        if (sobrecargo == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo registrar la tripulacion");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(sobrecargo);
    }

    @PutMapping("/update/piloto/{id}")
    public ResponseEntity<?> updatePiloto(@PathVariable int id, @RequestBody PilotoModel pilotoModel) {
        PilotoModel piloto = pilotoService.actualizarDatosPiloto(pilotoModel, id).orElse(null);
        if (piloto == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo actualizar la tripulacion");
        }
        return ResponseEntity.status(HttpStatus.OK).body(piloto);
    }

    @PutMapping("/update/copiloto/{id}")
    public ResponseEntity<?> updateCopiloto(@PathVariable int id, @RequestBody CopilotoModel copilotoModel) {
        CopilotoModel copiloto = copilotoService.actualizarDatosCopiloto(copilotoModel, id).orElse(null);
        if (copiloto == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo actualizar la tripulacion");
        }
        return ResponseEntity.status(HttpStatus.OK).body(copiloto);
    }

    @PutMapping("/update/sobrecargo/{id}")
    public ResponseEntity<?> updateSobrecargo(@PathVariable int id, @RequestBody SobrecargoModel sobrecargoModel) {
        SobrecargoModel sobrecargo = sobrecargoService.actualizarDatosSobrecargo(sobrecargoModel, id).orElse(null);
        if (sobrecargo == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo actualizar la tripulacion");
        }
        return ResponseEntity.status(HttpStatus.OK).body(sobrecargo);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTripulacion(@PathVariable int id) {
        TripulacionModel tripulacion = tripulacionService.borrarTripulacion(id).orElse(null);
        if (tripulacion == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo borrar la tripulacion");
        }
        return ResponseEntity.status(HttpStatus.OK).body(tripulacion);
    }
}
