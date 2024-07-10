package com.pachas.infraccionservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.pachas.infraccionservice.entity.Infraccion;
import com.pachas.infraccionservice.repository.InfraccionRepository;

@Service
public class InfraccionService {

    @Autowired
    private InfraccionRepository infraccionRepository;

    public Infraccion registrarInfraccion(Infraccion infraccion) {
        return infraccionRepository.save(infraccion);
    }

    public List<Infraccion> obtenerInfracciones(int offset, int limit) {
        return infraccionRepository.findAll(PageRequest.of(offset, limit)).getContent();
    }

    public Infraccion obtenerInfraccion(Long id) {
        return infraccionRepository.findById(id).orElse(null);
    }

    public List<Infraccion> obtenerInfraccionesPorUsuario(String dni) {
        return infraccionRepository.findByDni(dni);
    }

    public Infraccion anularInfraccion(Long id) {
        return infraccionRepository.findById(id)
                .map(infraccion -> {
                    infraccion.setEstado("Anulada");
                    return infraccionRepository.save(infraccion);
                })
                .orElse(null);
    }
}
