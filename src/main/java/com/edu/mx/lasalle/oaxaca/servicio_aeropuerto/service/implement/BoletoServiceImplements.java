/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.implement;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.BoletoModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repositories.BoletoRepository;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.BoletoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author tokay
 */
public class BoletoServiceImplements implements BoletoService {
    @Autowired
    private BoletoRepository boletoRepository;
    @Override
    public void registrarBoleto(BoletoModel boletoModel) {
        boletoRepository.save(boletoModel);
    }

    @Override
    public List<BoletoModel> obtenerBoletos() {
        return (List<BoletoModel>) boletoRepository.findAll();
    }

    @Override
    public BoletoModel getBoleto(int id) {
        return boletoRepository.findById(id);
    }

    @Override
    public void actualizarDatosBoleto(BoletoModel boletoModel, int id) {
        boletoModel.setIdBoleto(id);
        boletoRepository.save(boletoModel);
    }

    @Override
    public void borrarBoleto(int id) {
        boletoRepository.deleteById(id);
    }

    @Override
    public void borrarTodosLosBoletos() {
        boletoRepository.deleteAll();
    }
    
}
