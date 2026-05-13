package com.appmate.service;

import com.appmate.model.Usuario;
import com.appmate.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class UsuarioService {
    @Autowired

    private UsuarioRepository usuarioRepository;

    public List<Usuario> obtenerTodos(){
        return usuarioRepository.findAll();
    }
    public Optional<Usuario> BuscarPorEmail(String email){
        return usuarioRepository.findByEmail(email);
    }
    

    @Transactional
    public Usuario eliminarUsuarioPorEmail(String email) {
        // 1. Buscamos al usuario para tener sus datos
        Usuario usuario = usuarioRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("No se encontró el usuario para borrar"));

        // 2. Lo borramos
        usuarioRepository.delete(usuario); // Es más seguro usar el objeto directamente

        // 3. Devolvemos el objeto que teníamos en memoria
        return usuario; 
    }
    @Transactional
    public Usuario GuardarUsuario(Usuario usuario){
        // Logica de la app
        // Ejemplo
        if (usuario.getDni().isEmpty()){
            throw new RuntimeException ("Campo dni Vacio");
        }
        if (usuario.getNombre().isEmpty()){
            throw new RuntimeException ("Campo nombre Vacio");
        }
        if (usuario.getEmail().isEmpty()){
            throw new RuntimeException ("Campo email Vacio");
        }
        
        if (usuario.getPass().isEmpty()){
            throw new RuntimeException ("Campo contraseña Vacio");
        }

        if (!"PROFESOR".equals(usuario.getRol()) && !"ALUMNO".equals(usuario.getRol())) {
            throw new RuntimeException("Campo rol con datos invalidos");
        }
        if (usuario.getId() == null && usuarioRepository.existsByEmail(usuario.getEmail())){
            throw new RuntimeException ("Este email ya esta en uso");    
        }
        return usuarioRepository.save(usuario);
    }

}
