package com.challenge.forohub.entity;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String contrasena;

}
