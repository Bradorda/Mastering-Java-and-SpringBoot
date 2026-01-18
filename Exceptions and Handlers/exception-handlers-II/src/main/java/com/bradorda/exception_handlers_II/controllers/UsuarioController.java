package com.bradorda.exception_handlers_II.controllers;

import com.bradorda.exception_handlers_II.dtos.UsuarioDTO;
import com.bradorda.exception_handlers_II.models.Usuario;
import com.bradorda.exception_handlers_II.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public UsuarioDTO createUser(@RequestBody Usuario usuario){
       return usuarioService.create(usuario);
    }

}
