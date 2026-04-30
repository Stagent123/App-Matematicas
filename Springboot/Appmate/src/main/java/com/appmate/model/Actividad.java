package com.appmate.model;


import jakarta.persistence.*; // Importa todas las anotaciones de JPA (Entity, Id, Column, etc.)
import java.time.LocalDateTime; // Necesario para la fecha

@Entity
@Table(name = "Actividades")
public class Actividad { // IMPORTANTE: Clase en Mayúscula (CamelCase)

    // Datos de la Tabla
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Corregido: @GeneratedValue con G mayúscula
    private Long id; // Recomendado: Long con L mayúscula

    @Column(nullable = false)
    private String titulo; // Corregido: String con S mayúscula

    @Column(nullable = false, columnDefinition = "TEXT") // TEXT para enunciados largos
    private String enunciado; // Corregido: @Column con C mayúscula

    @Column(nullable = false)
    private LocalDateTime fechaCreacion; // Corregido: LocalDateTime con L mayúscula y camelCase

    // Relaciones 

    @ManyToOne
    @JoinColumn(name = "asignatura_id", nullable = false)
    private Asignatura asignatura;

    // Constructor vacío (Obligatorio para JPA)
    public Actividad() {
    }

    @PrePersist
    protected void OnCreate(){
        this.fechaCreacion = LocalDateTime.now(); // Asigna la fecha actual al crearla
    }

    // Getters y Setters...
    
    //ID
    public Long getId() {
        return id;
    }
    //Protected para evitar que se alteren los datos unicos 
    protected void setId(Long id) {
        this.id = id;
    }

    //titulo
    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    //Enunciado

    public String getEnunciado(){
        return enunciado;
    }
    public void setEnunciado(String enunciado){
        this.enunciado = enunciado;
    }

    //fecha Creacion
    public LocalDateTime getFechaCreacion(){
        return fechaCreacion;
    }
    public void setFechaCreacion(LocalDateTime fechaCreacion){
        this.fechaCreacion = fechaCreacion;
    }
    //Asignatura
    public Asignatura getAsignatura(){
        return asignatura;
    }
    public void setAsignatura(Asignatura asignatura){
        this.asignatura = asignatura;
    }  
   
   
}