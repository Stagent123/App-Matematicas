package com.appmate.service;

import com.appmate.model.Entrega;
import com.appmate.repository.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EntregaService {
    @Autowired
    private EntregaRepository entregaRepository;

    public Entrega guardarEntrega(Entrega entrega){
        if (entrega.getEstado() != "EN_PROGRESO" || entrega.getEstado() != "ENTREGADA"){
            throw new RuntimeException("Error Estado no valido");
        } 
        if (entrega.getAlumno() == null ){
            throw new RuntimeException("Consigna de Alumno vacio");
        }
        if (entrega.getActividad() == null){
            throw new RuntimeException("No se encuentra la Actividad");
        }
        return entregaRepository.save(entrega);
    }
}
