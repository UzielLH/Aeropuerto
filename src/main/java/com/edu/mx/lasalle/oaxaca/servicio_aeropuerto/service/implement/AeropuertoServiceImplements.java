/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit este template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.implement;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.Aeropuerto;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repositories.AeropuertoRepository;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.AeropuertoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ferrc
 */
public class AeropuertoServiceImplements implements AeropuertoService {
    
    @Autowired
    private AeropuertoRepository aeropuertoRepository;

    @Override
    public void registrarAeropuerto(Aeropuerto aeropuerto) {
        aeropuertoRepository.save(aeropuerto);
    }

    @Override
    public List<Aeropuerto> obtenerAeropuertos() {
        return (List<Aeropuerto>) aeropuertoRepository.findAll();
    }

    @Override
    public Aeropuerto getAeropuerto(int claveAeropuerto) {
        return aeropuertoRepository.findByClaveAeropuerto(claveAeropuerto);
    }

    @Override
    public void actualizarDatosAeropuerto(Aeropuerto aeropuerto, int claveAeropuerto) {
        aeropuerto.setClaveAeropuerto(claveAeropuerto);
        aeropuertoRepository.save(aeropuerto);
    }

    @Override
    public void borrarAeropuerto(int claveAeropuerto) {
        aeropuertoRepository.deleteById(claveAeropuerto);
    }

    @Override
    public void borrarTodosLosAeropuertos() {
        aeropuertoRepository.deleteAll();
    }
}
