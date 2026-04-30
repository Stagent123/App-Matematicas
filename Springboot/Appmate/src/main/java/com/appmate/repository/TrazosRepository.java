package com.appmate.repository;

import com.appmate.model.Trazos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrazosRepository extends JpaRepository<Trazos, Long> {
    // Aquí puedes agregar métodos personalizados después
}