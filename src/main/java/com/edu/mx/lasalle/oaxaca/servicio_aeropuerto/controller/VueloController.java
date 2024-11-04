package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
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

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.VueloModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.VueloService;

@RestController
@RequestMapping("/api/vuelo")
@CrossOrigin(origins = "*")
public class VueloController {

    @Autowired
    private VueloService vueloService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        List<VueloModel> vuelo = vueloService.obtenerVuelo();
        if (vuelo.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay vuelos registrados");
        }
        return ResponseEntity.status(HttpStatus.OK).body(vuelo);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getVuelo(@PathVariable int id) {
        VueloModel vuelo = vueloService.getVuelo(id).orElse(null);
        if (vuelo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el vuelo");
        }
        return ResponseEntity.status(HttpStatus.OK).body(vuelo);
    }

    @GetMapping("/{id}/pasajeros")
    public ResponseEntity<?> getPasajeros(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(vueloService.obtenerPasajeros(id));
    }

    @GetMapping("/{id}/detalles")
    public ResponseEntity<?> getDetalles(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(vueloService.obtenerDetallesVuelo(id));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createVuelo(@RequestBody VueloModel vueloModel) {
        VueloModel vuelo = vueloService.registrarVuelo(vueloModel);
        if (vuelo == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo registrar el vuelo");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(vuelo);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveVuelo(@RequestBody VueloModel vueloModel) {
        VueloModel vuelo = vueloService.save(vueloModel);
        if (vuelo == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo registrar el vuelo");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(vuelo);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateVuelo(@PathVariable int id, @RequestBody VueloModel vueloModel) {
        VueloModel vuelo = vueloService.actualizarDatosVuelo(vueloModel, id).orElse(null);
        if (vuelo == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo actualizar el vuelo");
        }
        return ResponseEntity.status(HttpStatus.OK).body(vuelo);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteVuelo(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(vueloService.borrarVuelo(id));
    }
}
