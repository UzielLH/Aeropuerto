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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.PasajeroModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.PasajeroService;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.utils.CustomResponse;

@RestController
@RequestMapping("/api/v1/pasajero")
public class PasajeroController {
    @Autowired
    private PasajeroService pasajeroService;

    @PostMapping("/registro")
    public CustomResponse registrarPasajero(@RequestBody PasajeroModel pasajeroModel) {
        CustomResponse response = new CustomResponse();
        try {
            pasajeroService.registrarPasajero(pasajeroModel);
            response.setHttpCode(HttpStatus.CREATED);
            response.setData(pasajeroModel);
            response.setMessage("Pasajero registrado correctamente");
            response.setCode(201);
        } catch (Exception e) {
            response.setHttpCode(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage("Error al registrar el pasajero: " + e.getMessage());
            response.setCode(500);
        }
        return response;
    }

    @GetMapping("/registros")
    public ResponseEntity<List<PasajeroModel>> getAllPasajeros() {
        List<PasajeroModel> pasajeros = pasajeroService.obtenerPasajeros();
        if (pasajeros.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pasajeros, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPasajeroById(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new CustomResponse(
                            HttpStatus.OK,
                            pasajeroService.getPasajeros(id),
                            "Show all matches",
                            200));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
                    new CustomResponse(
                            HttpStatus.UNPROCESSABLE_ENTITY,
                            pasajeroService.getPasajeros(id),
                            "Error al obtener el pasajero: " + e.getMessage(),
                            422));
        }
    }

    @PutMapping("({id}/actualizar)")
    public ResponseEntity<?> updatePasajero(@RequestBody PasajeroModel pasajeroModel,
            @PathVariable(value = "id") int id) {
        CustomResponse response = new CustomResponse();
        try {
            if (pasajeroService.getPasajeros(id) == null) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                        new CustomResponse(HttpStatus.NO_CONTENT,
                                "", "This action can't execute, not found with id: " + id,
                                204));
            }
            pasajeroService.actualizarDatosPasajero(pasajeroModel, id);
            response.setHttpCode(HttpStatus.OK);
            response.setCode(200);
            response.setMessage("Update sucess");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setMessage("Error: " + e);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }

    @DeleteMapping("/{id}/borrar")
    public ResponseEntity<?> deletePasajero(@PathVariable int id) {
        CustomResponse customResponse = new CustomResponse();
        try {
            pasajeroService.borrarPasajero(id);
            customResponse.setHttpCode(HttpStatus.OK);
            customResponse.setMessage("DELETE SUCESS");
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);
        } catch (Exception e) {
            customResponse.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(customResponse);
        }
    }
}