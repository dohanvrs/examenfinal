package com.pachas.infraccionservice.repository;

import com.pachas.infraccionservice.entity.Infraccion;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface InfraccionRepository extends JpaRepository<Infraccion, Long> {
    List<Infraccion> findByDni(String dni);
}
