package com.tarea1.controller;

import com.tarea1.entity.Usuario;
import com.tarea1.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistroController {

    private final Logger log = LoggerFactory.getLogger(RegistroController.class);

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String iniciarSesion(HttpSession session) {
        return "login";
    }

    @GetMapping("/")
    public String verPaginaInicio() {
        return "principal";
    }
}
