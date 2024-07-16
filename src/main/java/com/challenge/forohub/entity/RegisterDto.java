package com.challenge.forohub.entity;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterDto {
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String correo;
    @NotEmpty
    private String contrasena;
    @NotEmpty
    private String perfil;

}
