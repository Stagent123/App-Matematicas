package com.appmate.repository;

import com.appmate.model.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CalificacionRepository extends JpaRepository<Calificacion, Long>{
    //Metodos Personalizados
}

