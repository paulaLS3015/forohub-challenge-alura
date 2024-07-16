package com.challenge.forohub.repository;

import com.challenge.forohub.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Usuario findByNombre(String nombre);
    public Usuario findByCorreo(String correo);
}
