/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt para cambiar este license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java para editar este template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.TerminalModel;
import java.util.*;
import org.springframework.stereotype.Service;

/**
 *
 * @author ferrc
 */
@Service
public interface TerminalModelService {
    TerminalModel registrarTerminal(TerminalModel terminalModel);

    List<TerminalModel> obtenerTerminales();

    Optional<TerminalModel> getTerminal(int claveTerminal);

    Optional<TerminalModel> actualizarDatosTerminal(TerminalModel terminalModel, int claveTerminal);

    Optional<TerminalModel> borrarTerminal(int claveTerminal);

    void borrarTodosLasTerminales();
}
