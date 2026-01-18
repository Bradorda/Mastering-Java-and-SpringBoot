package com.bradorda.exception_handlers_II.services;

import com.bradorda.exception_handlers_II.dtos.UsuarioDTO;
import com.bradorda.exception_handlers_II.exceptions.PessoaDeveSerInformadaException;
import com.bradorda.exception_handlers_II.models.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    public UsuarioDTO create(Usuario usuario){
        if(usuario.getPessoa() == null){
            throw new PessoaDeveSerInformadaException("Os dados de pessoa devem ser informados.");
        }
        usuario.setId(1L);
        return new UsuarioDTO(usuario.getId(),usuario.getLogin());
    }

}
