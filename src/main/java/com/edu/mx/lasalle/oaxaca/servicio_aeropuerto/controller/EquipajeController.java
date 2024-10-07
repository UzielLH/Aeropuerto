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

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.EquipajeModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.EquipajeService;

@RestController
@RequestMapping("/api/equipaje")
public class EquipajeController {

    @Autowired
    private EquipajeService equipajeService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        List<EquipajeModel> equipaje = equipajeService.obtenerEquipajes();
        if (equipaje.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay equipajes registrados");
        }
        return ResponseEntity.status(HttpStatus.OK).body(equipaje);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getEquipaje(@PathVariable int id) {
        EquipajeModel equipaje = equipajeService.getEquipaje(id).orElse(null);
        if (equipaje == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el equipaje");
        }
        return ResponseEntity.status(HttpStatus.OK).body(equipaje);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createEquipaje(@PathVariable EquipajeModel equipajeModel) {
        EquipajeModel equipaje = equipajeService.registrarEquipaje(equipajeModel);
        if (equipaje == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo registrar el equipaje");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(equipaje);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEquipaje(@PathVariable int id, @PathVariable EquipajeModel equipajeModel) {
        EquipajeModel equipaje = equipajeService.actualizarDatosEquipaje(equipajeModel, id).orElse(null);
        if (equipaje == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo actualizar el equipaje");
        }
        return ResponseEntity.status(HttpStatus.OK).body(equipaje);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEquipaje(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(equipajeService.borrarEquipaje(id));
    }
}
