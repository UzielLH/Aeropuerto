/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.implement;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.TripulacionModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repositories.TripulacionRepository;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.TripulacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tokay
 */
@Service
public class TripulacionServiceImplements implements TripulacionService{
    @Autowired
    private TripulacionRepository tripulacionRepository;
    
    @Override
    public void registrarTripulacion(TripulacionModel tripulacionModel) {
        tripulacionRepository.save(tripulacionModel);
    }

    @Override
    public List<TripulacionModel> obtenerTripulacion() {
        return(List<TripulacionModel>) tripulacionRepository.findAll();
    }

    @Override
    public TripulacionModel getTripulacion(int id) {
        return tripulacionRepository.findById(id);
    }

    @Override
    public void actualizarDatosTripulacion(TripulacionModel tripulacionModel, int id) {
        tripulacionModel.setIdTripulacion(id);
        tripulacionRepository.save(tripulacionModel);
    }

    @Override
    public void borrarTripulacion(int id) {
        tripulacionRepository.deleteById(id);
    }

    @Override
    public void borrarTodosTripulacion() {
        tripulacionRepository.deleteAll();
    }
    
}
