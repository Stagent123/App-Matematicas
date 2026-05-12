package com.appmate.service;

import com.appmate.model.Trazos;
import com.appmate.repository.TrazosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrazosService {
    @Autowired

    private TrazosRepository trazosRepository;

    public Trazos guardarTrazos(Trazos trazos){
        //Logica de la App
        //Ejemplo

        if(trazos.getTipo() != "STROKE" || trazos.getTipo() != "FORMULA"){
            throw new RuntimeException("Error Tipo no Valido");
        }
        if(trazos.getInfo() == null || trazos.getInfo().trim().isEmpty()){
            throw new RuntimeException("error campo info vacio");
        }
        
        return trazosRepository.save(trazos);
    }
}
