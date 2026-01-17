package com.bradorda.exceptionhandlers.services;

import com.bradorda.exceptionhandlers.dtos.FinanceiroDTO;
import com.bradorda.exceptionhandlers.exceptions.ValorZeroException;
import org.springframework.stereotype.Service;

@Service
public class FinanceiroService {

    public FinanceiroDTO salvar(FinanceiroDTO financeiro){
        validarValores(financeiro);
        financeiro.setId(1L);

        return financeiro;
    }

    private void validarValores(FinanceiroDTO financeiro) {
        if(financeiro.getValor() == null || financeiro.getValor().doubleValue() == 0){
            throw new ValorZeroException("O valor do lançamento não pode ser zero", financeiro.getLancamento());
        }
    }
}
