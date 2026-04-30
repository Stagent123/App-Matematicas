package com.appmate.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pizarra_eventos") // Nombre de tabla en snake_case es estándar
public class Trazos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Long objeto es mejor que long primitivo para JPA

    @Column(nullable = false)
    private String tipo; // Ejemplo: "STROKE", "FORMULA"

    @Column(nullable = false, columnDefinition = "TEXT") 
    private String info; // Usamos TEXT para que el JSON del trazo no tenga límite de 255 caracteres

    @Column(nullable = false)
    private LocalDateTime horaCreacion;

    @ManyToOne
    @JoinColumn(name = "entrega_id") // Define explícitamente el nombre de la columna FK
    private Entrega entrega;

    // Constructor para asignar la hora automáticamente
    public Trazos() {
    }

    @PrePersist
    protected void onCreate() {
        this.horaCreacion = LocalDateTime.now();
    }
    //Constructu
    // Getters y Setters...

    //Id
    public Long getId(){
        return id;
    }
    protected void setId(Long id){
        this.id = id;
    }
    //Tipo

    public String getTipo(){
        return tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    // Info
    public String getInfo(){
        return info;
    }
    public void setInfo(String info){
        this.info = info;
    }
    // LocalTime
    public LocalDateTime getHoraCreacion(){
        return horaCreacion;
    }

    public void setHoraCreacion(LocalDateTime horaCreacion){
        this.horaCreacion = horaCreacion;
    }
    
    // Entrega
    public Entrega getEntrega(){
        return entrega;
    }

    public void setEntrega(Entrega entrega){
        this.entrega = entrega;
    }
}