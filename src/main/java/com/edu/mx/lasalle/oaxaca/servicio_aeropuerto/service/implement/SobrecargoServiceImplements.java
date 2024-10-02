/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.implement;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.SobrecargoModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repositories.SobrecargoRepository;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.SobrecargoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tokay
 */
@Service
public class SobrecargoServiceImplements implements SobrecargoService{
    @Autowired
    private SobrecargoRepository sobrecargoRepository;
    @Override
    public void registrarSobrecargo(SobrecargoModel sobrecargoModel) {
        sobrecargoRepository.save(sobrecargoModel);
    }

    @Override
    public List<SobrecargoModel> obtenerSobrecargos() {
        return (List<SobrecargoModel>) sobrecargoRepository.findAll();
    }

    @Override
    public SobrecargoModel getSobrecargos(int id) {
        return sobrecargoRepository.findById(id);
    }

    @Override
    public void actualizarDatosSobrecargo(SobrecargoModel sobrecargoModel, int id) {
        sobrecargoModel.setIdTripulacion(id);
        sobrecargoRepository.save(sobrecargoModel);
    }

    @Override
    public void borrarCopiloto(int id) {
        sobrecargoRepository.deleteById(id);
    }

    @Override
    public void borrarTodosLosCopilotos() {
        sobrecargoRepository.deleteAll();
    }
    
}
