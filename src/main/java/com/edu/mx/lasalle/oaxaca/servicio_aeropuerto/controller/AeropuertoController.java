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

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.Aeropuerto;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.AeropuertoService;

@RestController
@RequestMapping("/api/aeropuerto")
@CrossOrigin(origins = "*")
public class AeropuertoController {

    @Autowired
    private AeropuertoService aeropuertoService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        List<Aeropuerto> aeropuerto = aeropuertoService.obtenerAeropuertos();
        if (aeropuerto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay aeropuertos registrados");
        }
        return ResponseEntity.status(HttpStatus.OK).body(aeropuerto);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getAeropuerto(@PathVariable int id) {
        Aeropuerto aeropuerto = aeropuertoService.getAeropuerto(id).orElse(null);
        if (aeropuerto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el aeropuerto");
        }
        return ResponseEntity.status(HttpStatus.OK).body(aeropuerto);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createAeropuerto(@RequestBody Aeropuerto aeropuerto) {
        Aeropuerto aeropuertoDb = aeropuertoService.registrarAeropuerto(aeropuerto);
        if (aeropuertoDb == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo registrar el aeropuerto");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(aeropuerto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAeropuerto(@PathVariable int id, @RequestBody Aeropuerto aeropuerto) {
        Aeropuerto aeropuertoDb = aeropuertoService.actualizarDatosAeropuerto(id, aeropuerto).orElse(null);
        if (aeropuertoDb == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo actualizar el aeropuerto");
        }
        return ResponseEntity.status(HttpStatus.OK).body(aeropuerto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAeropuerto(@PathVariable int id) {
        Aeropuerto aeropuerto = aeropuertoService.borrarAeropuerto(id).orElse(null);
        if (aeropuerto == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo borrar el aeropuerto");
        }
        return ResponseEntity.status(HttpStatus.OK).body(aeropuerto);
    }
}
