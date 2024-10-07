package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.PasajeroModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.PasajeroService;

@RestController
@RequestMapping("/api/pasajero")
public class PasajeroController {

    @Autowired
    private PasajeroService pasajeroService;

    @Transactional(readOnly = true)
    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        List<PasajeroModel> pasajero = pasajeroService.obtenerPasajeros();
        if (pasajero.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay pasajeros registrados");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pasajero);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getPasajero(@PathVariable int id) {
        PasajeroModel pasajero = pasajeroService.getPasajeros(id).orElseThrow();
        if (pasajero == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el pasajero");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pasajero);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createPasajero(@RequestBody PasajeroModel pasajeroModel) {
        PasajeroModel pasajero = pasajeroService.registrarPasajero(pasajeroModel);
        if (pasajero == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo registrar el pasajero");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(pasajero);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePasajero(@PathVariable int id, @RequestBody PasajeroModel pasajeroModel) {
        PasajeroModel pasajero = pasajeroService.actualizarDatosPasajero(pasajeroModel, id).orElse(null);
        if (pasajero == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo actualizar el pasajero");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pasajero);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePasajero(@PathVariable int id) {
        pasajeroService.borrarPasajero(id);
        return ResponseEntity.status(HttpStatus.OK).body("Pasajero eliminado");
    }
}
