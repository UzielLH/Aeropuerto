/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change este license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java para editar este template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.implement;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.AvionModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repositories.AvionModelRepository;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.AvionModelService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ferrc
 */
public class AvionModelServiceImplements implements AvionModelService {
    
    @Autowired
    private AvionModelRepository avionModelRepository;

    @Override
    public void registrarAvion(AvionModel avionModel) {
        avionModelRepository.save(avionModel);
    }

    @Override
    public List<AvionModel> obtenerAviones() {
        return (List<AvionModel>) avionModelRepository.findAll();
    }

    @Override
    public AvionModel getAvion(int matricula) {
        return avionModelRepository.findByMatricula(matricula);
    }

    @Override
    public void actualizarDatosAvion(AvionModel avionModel, int matricula) {
        avionModel.setMatricula(matricula);
        avionModelRepository.save(avionModel);
    }

    @Override
    public void borrarAvion(int matricula) {
        avionModelRepository.deleteById(matricula);
    }

    @Override
    public void borrarTodosLosAviones() {
        avionModelRepository.deleteAll();
    }
}
