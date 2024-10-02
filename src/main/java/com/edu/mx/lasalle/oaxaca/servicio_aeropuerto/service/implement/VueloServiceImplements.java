/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.implement;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.VueloModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repositories.VueloRepository;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.VueloService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tokay
 */
@Service
public class VueloServiceImplements implements VueloService {
    @Autowired
    private VueloRepository vueloRepository;
    
    @Override
    public void registrarVuelo(VueloModel vueloModel) {
        vueloRepository.save(vueloModel);
    }

    @Override
    public List<VueloModel> obtenerVuelo() {
        return(List<VueloModel>) vueloRepository.findAll();
    }

    @Override
    public VueloModel getVuelo(int id) {
        return vueloRepository.findById(id);
    }

    @Override
    public void actualizarDatosVuelo(VueloModel vueloModel, int id) {
        vueloModel.setIdVuelo(id);
        vueloRepository.save(vueloModel);
    }

    @Override
    public void borrarVuelo(int id) {
        vueloRepository.deleteById(id);
    }

    @Override
    public void borrarTodosVuelo() {
        vueloRepository.deleteAll();
    }
    
}
