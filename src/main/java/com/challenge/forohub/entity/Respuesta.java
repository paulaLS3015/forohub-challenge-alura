package com.challenge.forohub.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table (name = "tbl_Respuesta")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long id_topico;
    private String mensaje;
    private Date fecha_creacion;
    private Long id_autor;
}
