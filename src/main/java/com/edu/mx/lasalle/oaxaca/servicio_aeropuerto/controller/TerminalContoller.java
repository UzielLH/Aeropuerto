package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.controller;

import java.util.*;

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

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.TerminalModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.TerminalModelService;

@RestController
@RequestMapping("/api/terminal")
public class TerminalContoller {

    @Autowired
    private TerminalModelService terminalService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        List<TerminalModel> terminal = terminalService.obtenerTerminales();
        if (terminal.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay terminales registradas");
        }
        return ResponseEntity.status(HttpStatus.OK).body(terminal);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getTerminal(@PathVariable int id) {
        Optional<TerminalModel> terminal = terminalService.getTerminal(id);
        if (terminal.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro la terminal");
        }
        return ResponseEntity.status(HttpStatus.OK).body(terminal);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createTerminal(@RequestBody TerminalModel terminalModel) {
        TerminalModel terminal = terminalService.registrarTerminal(terminalModel);
        if (terminal == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo registrar la terminal");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(terminal);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTerminal(@PathVariable int id, @RequestBody TerminalModel terminalModel) {
        Optional<TerminalModel> terminal = terminalService.actualizarDatosTerminal(terminalModel, id);
        if (terminal.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo actualizar la terminal");
        }
        return ResponseEntity.status(HttpStatus.OK).body(terminal);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTerminal(@PathVariable int id) {
        Optional<TerminalModel> terminal = terminalService.borrarTerminal(id);
        if (terminal.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo borrar la terminal");
        }
        return ResponseEntity.status(HttpStatus.OK).body(terminal);
    }
}
