package com.bradorda.exception_handlers_II.handlers;

import com.bradorda.exception_handlers_II.exceptions.PessoaDeveSerInformadaException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDate;

@ControllerAdvice
public class PessoaNaoInformadaHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    @ExceptionHandler(PessoaDeveSerInformadaException.class)
    public ErrorHandler handler(PessoaDeveSerInformadaException ex){
        return new ErrorHandler(ex.getMessage(), LocalDate.now(),"Parametros enviados são invalidos.");
    }

}
