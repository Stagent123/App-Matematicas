package com.appmate.model;

import jakarta.persistence.*; // Importa Entity, Id, Table, Column y GeneratedValue de una vez
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Recomendado Long con L mayúscula

    @Column(nullable = false, unique = true) // Añadido 'unique' porque no puede haber dos DNI iguales
    private String dni; // En Java usamos minúsculas para atributos (dni)

    @Column(nullable = false)
    private String nombre; // 'Name' es palabra reservada en algunas DB, mejor usar 'nombre'

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String pass;

    @Column(nullable = false)
    private String rol; // "PROFESOR" o "ALUMNO"

    public Usuario(){
        
    }
    //Getters Setters por variable
    //ID
    public Long getId() {
        return id;
    }
    //Protected para evitar que se alteren los datos unicos 
    protected void setId(Long id) {
        this.id = id;
    }

    //Dni
    public String getDni(){
        return dni;
    }
    public void setDni(String dni){
        this.dni = dni;
    }
    //Nombre

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    //email
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    //pass
    public String getPass(){
        return pass;
    }
    public void setPass(String pass){
        this.pass = pass;
    }  
    //rol
    public String getRol(){
        return rol;
    }
    public void setRol(String rol){
        this.rol = rol;
    }  


    
}