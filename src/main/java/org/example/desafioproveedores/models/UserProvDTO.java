package org.example.desafioproveedores.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor // crea constructor con todos los atributos
@NoArgsConstructor // crea constructor vacio
@Getter
@Setter
public class UserProvDTO {
    private int id;
    private String nombre;
    private String rut;
    private String direccion;
    private String correo;
    private String telefono;
    private String contacto;
    private String telefono_contacto;
}
