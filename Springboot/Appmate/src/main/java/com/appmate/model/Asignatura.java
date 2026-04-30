package com.appmate.model;

import jakarta.persistence.*; // Simplifica los imports de JPA
import java.util.List; // Necesario para la interfaz List

@Entity
@Table(name = "asignaturas") // Por estándar las tablas van en minúscula/plural
public class Asignatura {

    // Datos de la Tabla
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Usar Long (objeto) es mejor práctica que long (primitivo)

    @Column(nullable = false) // Corregido: @Column con C mayúscula
    private String nombre; // Corregido: String con S mayúscula

    @Column(nullable = false, unique = true) // Corregido: @Column con C mayúscula
    private String codigoAcceso; // CamelCase: codigoAcceso en lugar de codigo_acceso


    // Relaciones
    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Usuario profesor;

    // mappedBy debe coincidir EXACTAMENTE con el nombre del atributo en la clase Actividad
    @OneToMany(mappedBy = "asignatura", cascade = CascadeType.ALL)
    private List<Actividad> actividades;

    // Constructor vacío obligatorio
    public Asignatura() {}
    // Getters y Setters...

     //Id
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    //nombre
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    //codigoAcceso
    public String getCodigoAcceso(){
        return codigoAcceso;
    }
    public void setCodigoAcceso(String codigoAcceso){
        this.codigoAcceso = codigoAcceso;
    }  

    //Usuario
    public Usuario getProfesor(){
        return profesor;
    }
    public void setProfesor(Usuario profesor){
        this.profesor = profesor;
    } 

    //Actividad
    public java.util.List<Actividad> getActividades() {
        return actividades;
    }
    public void setActividad(List<Actividad> actividades){
        this.actividades = actividades;
    } 
}