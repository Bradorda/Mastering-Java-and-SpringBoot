package com.bradorda.exceptionhandlers.handlers;

import com.bradorda.exceptionhandlers.dtos.ErrorDTO;
import com.bradorda.exceptionhandlers.exceptions.ValorZeroException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ValorZeroExceptionHandler {

    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    @ResponseBody
    @ExceptionHandler(ValorZeroException.class)
    public ErrorDTO handler(ValorZeroException ex){
        return new ErrorDTO(ex.getMessage(),ex.getLancamento());
    }

}
