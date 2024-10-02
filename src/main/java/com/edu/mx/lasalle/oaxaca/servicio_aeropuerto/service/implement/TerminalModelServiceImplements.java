/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt para cambiar este license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java para editar este template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.implement;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.TerminalModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repositories.TerminalModelRepository;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.TerminalModelService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ferrc
 */
public class TerminalModelServiceImplements implements TerminalModelService {
    
    @Autowired
    private TerminalModelRepository terminalModelRepository;

    @Override
    public void registrarTerminal(TerminalModel terminalModel) {
        terminalModelRepository.save(terminalModel);
    }

    @Override
    public List<TerminalModel> obtenerTerminales() {
        return (List<TerminalModel>) terminalModelRepository.findAll();
    }

    @Override
    public TerminalModel getTerminal(int claveTerminal) {
        return terminalModelRepository.findByClaveTerminal(claveTerminal);
    }

    @Override
    public void actualizarDatosTerminal(TerminalModel terminalModel, int claveTerminal) {
        terminalModel.setClaveTerminal(claveTerminal);
        terminalModelRepository.save(terminalModel);
    }

    @Override
    public void borrarTerminal(int claveTerminal) {
        terminalModelRepository.deleteById(claveTerminal);
    }

    @Override
    public void borrarTodosLasTerminales() {
        terminalModelRepository.deleteAll();
    }
}
