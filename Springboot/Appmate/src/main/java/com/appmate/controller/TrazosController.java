package com.appmate.controller;

import com.appmate.model.Trazos;
import com.appmate.service.TrazosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//url de la pagina
@RequestMapping("/api/trazos")
public class TrazosController {
    @Autowired

    private TrazosService trazosService;

    //Metodo Post
    @PostMapping("/Crear")
    public ResponseEntity<?> crearPizarra(@RequestBody Trazos trazos){
        try{
            //Llamada al service para verificacion 
            Trazos nuevoTrazo = trazosService.guardarTrazos(trazos);
            return ResponseEntity.ok(nuevoTrazo);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
