/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt para cambiar este license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java para editar este template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.implement;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.TerminalModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repositories.TerminalModelRepository;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.TerminalModelService;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ferrc
 */
public class TerminalModelServiceImplements implements TerminalModelService {

    @Autowired
    private TerminalModelRepository terminalModelRepository;

    @Transactional
    @Override
    public TerminalModel registrarTerminal(TerminalModel terminalModel) {
        return terminalModelRepository.save(terminalModel);
    }

    @Transactional(readOnly = true)
    @Override
    public List<TerminalModel> obtenerTerminales() {
        return (List<TerminalModel>) terminalModelRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<TerminalModel> getTerminal(int claveTerminal) {
        return terminalModelRepository.findByClaveTerminal(claveTerminal);
    }

    @Transactional
    @Modifying
    @Override
    public Optional<TerminalModel> actualizarDatosTerminal(TerminalModel terminalModel, int claveTerminal) {
        Optional<TerminalModel> terminalOptional = terminalModelRepository.findByClaveTerminal(claveTerminal);
        if (terminalOptional.isPresent()) {
            TerminalModel terminalActualizado = terminalOptional.orElseThrow();
            terminalActualizado.setCapacidad(terminalModel.getCapacidad());
            terminalActualizado.setDisponible(terminalModel.isDisponible());
            terminalActualizado.setVuelo(terminalModel.getVuelo());
            return Optional.of(terminalModelRepository.save(terminalActualizado));
        }
        return Optional.empty();
    }

    @Transactional
    @Modifying
    @Override
    public Optional<TerminalModel> borrarTerminal(int claveTerminal) {
        Optional<TerminalModel> terminalOptional = terminalModelRepository.findByClaveTerminal(claveTerminal);
        if (terminalOptional.isPresent()) {
            terminalModelRepository.delete(terminalOptional.orElseThrow());
            return terminalOptional;
        }
        return Optional.empty();
    }

    @Transactional
    @Modifying
    @Override
    public void borrarTodosLasTerminales() {
        terminalModelRepository.deleteAll();
    }

}
