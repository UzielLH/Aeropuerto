/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.implement;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.PilotoModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.TripulacionModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repositories.PilotoRepository;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.PilotoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tokay
 */
@Service
public class PilotoServiceImplements implements PilotoService {

    @Autowired
    private PilotoRepository pilotoRepository;
    @Override
    public void registrarPiloto(PilotoModel pilotoModel) {
        pilotoRepository.save(pilotoModel);
    }

    @Override
    public List<PilotoModel> obtenerPilotos() {
        return(List<PilotoModel>) pilotoRepository.findAll();
    }

    @Override
    public PilotoModel getPilotos(int id) {
        return pilotoRepository.findById(id);
    }

    @Override
    public void actualizarDatosPiloto(PilotoModel pilotoModel, int id) {
        pilotoModel.setIdTripulacion(id);
        pilotoRepository.save(pilotoModel);
    }

    @Override
    public void borrarPiloto(int id) {
        pilotoRepository.deleteById(id);
    }

    @Override
    public void borrarTodosLosPilotos() {
        pilotoRepository.deleteAll();
    }
    
}
