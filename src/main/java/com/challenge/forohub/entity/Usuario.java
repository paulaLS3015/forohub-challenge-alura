package com.challenge.forohub.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@Table (name = "tbl_Usuario")
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Column(name = "email", unique = true)
    private String correo;
    private String contrasena;
    private String perfil; //estudiante o profesor
}
