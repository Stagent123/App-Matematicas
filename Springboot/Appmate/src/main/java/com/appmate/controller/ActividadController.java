package com.appmate.controller;

import com.appmate.model.Actividad;
import com.appmate.service.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // Indica que la clase manejara peticiones http
// Indicamos la url base para la api
@RequestMapping("/api/actividades")

public class ActividadController {
    @Autowired
    private ActividadService actividadService;

    //Metodo Post
    @PostMapping("/crear")
    public ResponseEntity<?> crearActividad(@RequestBody Actividad actividad){
        try {
            //Llamada al service para aplicar logica
            Actividad nuevaActividad = actividadService.guardarActividad(actividad);
            //Si se aplica y guarda la entidad se devuelve estado 200 ok
            return ResponseEntity.ok(nuevaActividad);
        } catch (RuntimeException e){
            //Si falla el el guardado se manda un error
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}
