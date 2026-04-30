package com.appmate.service;

import com.appmate.model.Actividad;
import com.appmate.repository.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActividadService {

    @Autowired
    private ActividadRepository actividadRepository;

    public Actividad guardarActividad(Actividad actividad){
        //logica de app
        //ejemplo
        if (actividad.getTitulo() == null || actividad.getTitulo().isEmpty() ){   
            throw new RuntimeException("EL campo titulo esta vacio");
        }
        if (actividad.getEnunciado() == null || actividad.getEnunciado().isEmpty() ){
            throw new RuntimeException("El campo enunciado esta vacio");
        }
        
        if (actividad.getAsignatura() == null){
            throw new RuntimeException("No se a seleccionado ninguna asignatura para la actividad");
        }
        return actividadRepository.save(actividad);

    }

}
