package com.challenge.forohub.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table (name = "tbl_Topico")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private Date fecha_creacion;
    private Boolean status;
    private Long id_autor;
    private Long id_curso;
}
