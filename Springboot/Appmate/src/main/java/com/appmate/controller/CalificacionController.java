package com.appmate.controller;

import com.appmate.model.Calificacion;
import com.appmate.service.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//url de la app base
@RequestMapping("/api/Calificaciones")
public class CalificacionController {
    @Autowired
    private CalificacionService calificacionService;
    //Metodo POST

    @PostMapping("/Crear")
    public ResponseEntity<?> crearCalificacion(@RequestBody Calificacion calificacion){
        try{
            //llamada al service para verificacion de datos
            Calificacion nuevaCalificacion = calificacionService.guardarCalificacion(calificacion);
            //Si se aplica y guarda la entidad se devuelve estado 200 ok
            return ResponseEntity.ok(nuevaCalificacion);
        } catch (RuntimeException e) {
            //si falla se devuelve un error 
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
