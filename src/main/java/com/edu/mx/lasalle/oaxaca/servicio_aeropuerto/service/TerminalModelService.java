/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt para cambiar este license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java para editar este template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.TerminalModel;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ferrc
 */
@Service
public interface TerminalModelService {
    public void registrarTerminal(TerminalModel terminalModel);
    public List<TerminalModel> obtenerTerminales();
    public TerminalModel getTerminal(int claveTerminal);
    public void actualizarDatosTerminal(TerminalModel terminalModel, int claveTerminal);
    public void borrarTerminal(int claveTerminal);
    public void borrarTodosLasTerminales();
}
