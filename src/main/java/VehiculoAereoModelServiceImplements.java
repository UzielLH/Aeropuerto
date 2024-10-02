/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt para cambiar este license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java para editar este template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.implement;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.VehiculoAereoModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repositories.VehiculoAereoModelRepository;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.VehiculoAereoModelService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ferrc
 */
public class VehiculoAereoModelServiceImplements implements VehiculoAereoModelService {
    
    @Autowired
    private VehiculoAereoModelRepository vehiculoAereoModelRepository;

    @Override
    public void registrarVehiculoAereo(VehiculoAereoModel vehiculoAereoModel) {
        vehiculoAereoModelRepository.save(vehiculoAereoModel);
    }

    @Override
    public List<VehiculoAereoModel> obtenerVehiculosAereos() {
        return (List<VehiculoAereoModel>) vehiculoAereoModelRepository.findAll();
    }

    @Override
    public VehiculoAereoModel getVehiculoAereo(int matricula) {
        return vehiculoAereoModelRepository.findByMatricula(matricula);
    }

    @Override
    public void actualizarDatosVehiculoAereo(VehiculoAereoModel vehiculoAereoModel, int matricula) {
        vehiculoAereoModel.setMatricula(matricula);
        vehiculoAereoModelRepository.save(vehiculoAereoModel);
    }

    @Override
    public void borrarVehiculoAereo(int matricula) {
        vehiculoAereoModelRepository.deleteById(matricula);
    }

    @Override
    public void borrarTodosLosVehiculosAereos() {
        vehiculoAereoModelRepository.deleteAll();
    }
}
