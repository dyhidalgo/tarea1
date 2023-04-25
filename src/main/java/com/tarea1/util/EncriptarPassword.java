package com.tarea1.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//Esta clase nos ayuda para generar los password que vayamos a utilizar
public class EncriptarPassword {
    public static void main(String[] args) {
        var password = "12345";
        System.out.println("password: " + password);
        System.out.println("password encriptado: " + encriptarPassword(password));
    }
    
    public static String encriptarPassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
