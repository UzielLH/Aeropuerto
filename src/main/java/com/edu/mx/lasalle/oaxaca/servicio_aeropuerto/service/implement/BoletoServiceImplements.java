/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.implement;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.BoletoModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repositories.BoletoRepository;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.BoletoService;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author tokay
 */
public class BoletoServiceImplements implements BoletoService {
    @Autowired
    private BoletoRepository boletoRepository;

    @Transactional
    @Override
    public BoletoModel registrarBoleto(BoletoModel boletoModel) {
        return boletoRepository.save(boletoModel);
    }

    @Transactional(readOnly = true)
    @Override
    public List<BoletoModel> obtenerBoletos() {
        return (List<BoletoModel>) boletoRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<BoletoModel> getBoleto(int id) {
        return boletoRepository.findByIdBoleto(id);
    }

    @Transactional
    @Modifying
    @Override
    public Optional<BoletoModel> actualizarDatosBoleto(BoletoModel boletoModel, int id) {
        Optional<BoletoModel> boletoOptional = boletoRepository.findById(id);
        if (boletoOptional.isPresent()) {
            BoletoModel boletoActualizado = boletoOptional.orElseThrow();
            boletoActualizado.setAsiento(boletoModel.getAsiento());
            boletoActualizado.setCosto(boletoModel.getCosto());
            boletoActualizado.setVueloModel(boletoModel.getVueloModel());
            return Optional.of(boletoRepository.save(boletoActualizado));
        }
        return Optional.empty();
    }

    @Transactional
    @Modifying
    @Override
    public Optional<BoletoModel> borrarBoleto(int id) {
        Optional<BoletoModel> boletoOptional = boletoRepository.findById(id);
        if (boletoOptional.isPresent()) {
            boletoRepository.deleteById(id);
            return boletoOptional;
        }
        return Optional.empty();
    }

    @Transactional
    @Modifying
    @Override
    public void borrarTodosLosBoletos() {
        boletoRepository.deleteAll();
    }
}
