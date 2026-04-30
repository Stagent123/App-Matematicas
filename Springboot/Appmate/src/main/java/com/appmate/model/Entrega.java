package com.appmate.model;
import jakarta.persistence.*;

@Entity
@Table(name = "entregas")
public class Entrega { // Recomendado: nombre en singular

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // Corregido: @Column con C mayúscula
    private String estado; // Ejemplo: "EN_PROGRESO", "ENTREGADA"

    @ManyToOne
    @JoinColumn(name = "alumno_id")
    private Usuario alumno; // Usamos tu clase Usuario (que tiene el rol ALUMNO)
    
    @ManyToOne
    @JoinColumn(name = "actividad_id")
    private Actividad actividad; // Corregido: nombre de variable en minúscula

    @OneToOne(mappedBy = "entrega")
    private Calificacion calificacion;

    // Constructor vacío
    public Entrega() {

    }

    // Getters y Setters...

     //Id
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    //Estado
    public String getEstado(){
        return estado;
    }
    public void setEstado(String estado){
        this.estado = estado;
    }

    //Alumno
    public Usuario getAlumno(){
        return alumno;
    }
    public void setAlumno (Usuario alumno){
        this.alumno = alumno ;
    }  

    //Actividad
    public Actividad getActividad(){
        return actividad;
    }
    public void setActividad(Actividad actividad){
        this.actividad = actividad;
    }  

    //Calificacion
    public Calificacion getCalificacion(){
        return calificacion;
    }
    public void setCalificacion(Calificacion calificacion){
        this.calificacion = calificacion;
    }  

}