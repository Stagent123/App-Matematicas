package com.appmate.model;

import jakarta.persistence.*;
@Entity
@Table(name = "Calificaciones")
public class Calificacion {

    //Datos de la Tabla
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String valor;

    @Column(nullable = false)
    private String comentario;
    // Relaciones de
    @OneToOne
    @JoinColumn(name = "entrega_id", unique = true)
    private Entrega entrega;

    public Calificacion(){
    }
     //Id
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    //Valor
    public String getValor(){
        return valor;
    }
    public void setValor(String valor){
        this.valor = valor;
    }

    //Comentario
    public String getComentario(){
        return comentario;
    }
    public void setComentario(String comentario){
        this.comentario = comentario;
    }  

    //Entrega
    public Entrega getEntrega(){
        return entrega;
    }
    public void setEntrega(Entrega entrega){
        this.entrega = entrega;
    } 
}



