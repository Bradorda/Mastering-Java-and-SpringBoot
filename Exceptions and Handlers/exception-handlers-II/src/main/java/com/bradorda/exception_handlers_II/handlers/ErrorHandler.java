package com.bradorda.exception_handlers_II.handlers;

import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;

public record ErrorHandler(String message, LocalDate data,String detalhe){

}
