package com.appmate.repository;

import com.appmate.model.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AsignaturaRepository extends JpaRepository<Asignatura, Long>{
    //Metodos Personalizados
}

