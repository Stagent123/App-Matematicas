package com.appmate.service;

import com.appmate.model.Calificacion;
import com.appmate.repository.CalificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalificacionService {
    @Autowired

    private CalificacionRepository calificacionRepository;

    public Calificacion guardarCalificacion(Calificacion calificacion){
        //logica de la App
        //Ejemplo
        if (calificacion.getValor().isEmpty()){
            throw new RuntimeException("No se a asignado ningun valor a la evaluacion");
        }
        return calificacionRepository.save(calificacion);
    }

}
