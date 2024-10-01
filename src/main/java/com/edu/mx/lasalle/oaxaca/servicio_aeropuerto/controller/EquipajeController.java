package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.EquipajeModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.EquipajeService;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.utils.CustomResponse;

@RestController
@RequestMapping("api/v1/equipaje")
public class EquipajeController {

    @Autowired
    private EquipajeService equipajeService;

    @PostMapping("/registro")
    public CustomResponse registrarEquipaje(@RequestBody EquipajeModel equipajeModel) {
        CustomResponse response = new CustomResponse();
        try {
            equipajeService.registrarEquipaje(equipajeModel);
            response.setHttpCode(HttpStatus.CREATED);
            response.setData(equipajeModel);
            response.setMessage("Equipaje registrado correctamente");
            response.setCode(201);
        } catch (Exception e) {
            response.setHttpCode(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage("Error al registrar el equipaje: " + e.getMessage());
            response.setCode(500);
        }
        return response;
    }

    @GetMapping("/registros")
    public ResponseEntity<List<EquipajeModel>> getAllEquipajes() {
        List<EquipajeModel> equipajes = equipajeService.obtenerEquipajes();
        if (equipajes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(equipajes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEquipajeById(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new CustomResponse(
                            HttpStatus.OK,
                            equipajeService.getEquipaje(id),
                            "Show all matches",
                            200));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new CustomResponse(
                            HttpStatus.INTERNAL_SERVER_ERROR,
                            null,
                            "Error al obtener el equipaje: " + e.getMessage(),
                            500));
        }
    }

    @PutMapping("/{id}/actualizar")
    public ResponseEntity<?> updateEquipaje(@RequestBody EquipajeModel equipajeModel,
            @PathVariable(value = "id") int id) {
        CustomResponse response = new CustomResponse();
        try {
            if (equipajeService.getEquipaje(id) == null) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                        new CustomResponse(
                                HttpStatus.NO_CONTENT,
                                null,
                                "No se encontró el equipaje con el id: " + id,
                                204));
            }
            equipajeService.actualizarDatosEquipaje(equipajeModel, id);
            response.setHttpCode(HttpStatus.OK);
            response.setData(equipajeModel);
            response.setMessage("Equipaje actualizado correctamente");
            response.setCode(200);
        } catch (Exception e) {
            response.setHttpCode(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage("Error al actualizar el equipaje: " + e.getMessage());
            response.setCode(500);
        }
        return ResponseEntity.status(response.getHttpCode()).body(response);
    }

    @PutMapping("/borrar/{id}")
    public ResponseEntity<?> deleteEquipaje(@PathVariable int id) {
        CustomResponse response = new CustomResponse();
        try {
            if (equipajeService.getEquipaje(id) == null) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                        new CustomResponse(
                                HttpStatus.NO_CONTENT,
                                null,
                                "No se encontró el equipaje con el id: " + id,
                                204));
            }
            equipajeService.borrarEquipaje(id);
            response.setHttpCode(HttpStatus.OK);
            response.setMessage("Equipaje eliminado correctamente");
            response.setCode(200);
        } catch (Exception e) {
            response.setHttpCode(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage("Error al eliminar el equipaje: " + e.getMessage());
            response.setCode(500);
        }
        return ResponseEntity.status(response.getHttpCode()).body(response);
    }
}
