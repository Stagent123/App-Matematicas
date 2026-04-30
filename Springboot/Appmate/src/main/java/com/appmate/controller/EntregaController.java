package com.appmate.controller;

import com.appmate.model.Entrega;
import com.appmate.service.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//url de la pagina
@RequestMapping("/api/entregas")
public class EntregaController {
    @Autowired

    private EntregaService entregaService;

    //Metodo Post
    @PostMapping("/Crear")
    public ResponseEntity<?> crearEntrega(@RequestBody Entrega entrega){
        try{
            //llamada al service para verificacion de datos
            Entrega nuevaEntrega = entregaService.guardarEntrega(entrega);
            //Si se aplica y guarda la entidad se devuelve estado 200 ok
            return ResponseEntity.ok(nuevaEntrega);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
