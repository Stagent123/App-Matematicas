package com.appmate.repository;

import com.appmate.model.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActividadRepository extends JpaRepository<Actividad, Long> {
    // Aquí puedes agregar métodos personalizados después
}