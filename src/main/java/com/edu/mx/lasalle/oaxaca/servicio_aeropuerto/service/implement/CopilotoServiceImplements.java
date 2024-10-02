/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.implement;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.CopilotoModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repositories.CopilotoRepository;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.CopilotoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tokay
 */
@Service
public class CopilotoServiceImplements implements CopilotoService {
    @Autowired
    private CopilotoRepository copilotoRepository;
    @Override
    public void registrarCopiloto(CopilotoModel copilotoModel) {
        copilotoRepository.save(copilotoModel);
    }

    @Override
    public List<CopilotoModel> obtenerCopilotos() {
        return(List<CopilotoModel>) copilotoRepository.findAll();
    }

    @Override
    public CopilotoModel getCopiloto(int id) {
        return copilotoRepository.findById(id);
    }

    @Override
    public void actualizarDatosCopiloto(CopilotoModel copilotoModel, int id) {
        copilotoModel.setIdTripulacion(id);
        copilotoRepository.save(copilotoModel);
    }

    @Override
    public void borrarCopiloto(int id) {
        copilotoRepository.deleteById(id);
    }

    @Override
    public void borrarTodosLosCopilotos() {
        copilotoRepository.deleteAll();
    }
    
}
