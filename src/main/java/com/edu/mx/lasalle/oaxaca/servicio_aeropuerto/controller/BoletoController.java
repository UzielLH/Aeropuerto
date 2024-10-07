package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.BoletoModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.BoletoService;

@RestController
@RequestMapping("/api/boleto")
public class BoletoController {

    @Autowired
    private BoletoService boletoService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        List<BoletoModel> boleto = boletoService.obtenerBoletos();
        if (boleto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay boletos registrados");
        }
        return ResponseEntity.status(HttpStatus.OK).body(boleto);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getBoleto(@PathVariable int id) {
        BoletoModel boleto = boletoService.getBoleto(id).orElse(null);
        if (boleto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el boleto");
        }
        return ResponseEntity.status(HttpStatus.OK).body(boleto);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createBoleto(@PathVariable BoletoModel boletoModel) {
        BoletoModel boleto = boletoService.registrarBoleto(boletoModel);
        if (boleto == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo registrar el boleto");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(boleto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateBoleto(@PathVariable int id, @PathVariable BoletoModel boletoModel) {
        BoletoModel boleto = boletoService.actualizarDatosBoleto(boletoModel, id).orElse(null);
        if (boleto == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo actualizar el boleto");
        }
        return ResponseEntity.status(HttpStatus.OK).body(boleto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBoleto(@PathVariable int id) {
        BoletoModel boleto = boletoService.borrarBoleto(id).orElse(null);
        if (boleto == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo borrar el boleto");
        }
        return ResponseEntity.status(HttpStatus.OK).body(boleto);
    }
}
