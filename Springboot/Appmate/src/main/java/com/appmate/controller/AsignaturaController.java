package com.appmate.controller;

import com.appmate.model.Asignatura;
import com.appmate.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//url base de la pagina
@RequestMapping("/api/asignaturas")
public class AsignaturaController {
    @Autowired
    private AsignaturaService asignaturaService;
    
    //Metodo Post

    @PostMapping("/Crear")
    public ResponseEntity<?> crearAsignatura(@RequestBody Asignatura asignatura){
        try{
            //llamada al service para verificacion de datos
            Asignatura nuevaAsignatura = asignaturaService.guardarAsignatura(asignatura);
            //Si se aplica y guarda la entidad se devuelve estado 200 ok
            return ResponseEntity.ok(nuevaAsignatura);
        } catch (RuntimeException e) {
            //si falla se devuelve un error 
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    
}
