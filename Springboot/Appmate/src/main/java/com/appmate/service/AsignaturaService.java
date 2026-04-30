package com.appmate.service;

import com.appmate.model.Asignatura;
import com.appmate.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignaturaService {
    @Autowired
    private AsignaturaRepository asignaturaRepository;

    public Asignatura guardarAsignatura(Asignatura asignatura){
        //logica de la pp
        //ejemplo 
        if (asignatura.getId() == null){
            throw new RuntimeException("Error Id inexistente");
        }
        if (asignatura.getNombre() == null || asignatura.getNombre().isEmpty()){
            throw new RuntimeException("Error el campo nombre esta vacio");
        }
        if (asignatura.getCodigoAcceso() == null || asignatura.getCodigoAcceso().isEmpty()){
            throw new RuntimeException("Error no se a definido un codigo de acceso");
        }
        if (asignatura.getProfesor() == null){
            throw new RuntimeException("Error el campo Profesor esta incompleto");
        }

        return asignaturaRepository.save(asignatura);
    }
}
