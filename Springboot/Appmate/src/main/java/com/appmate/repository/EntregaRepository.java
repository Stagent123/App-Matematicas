package com.appmate.repository;

import com.appmate.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EntregaRepository extends JpaRepository<Entrega, Long>{
    //Metodos Personalizados
}

