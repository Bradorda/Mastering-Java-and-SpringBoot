package com.bradorda;

import java.util.Optional;
import java.util.stream.Stream;

public class Optional1 {
    public static void main(String[] args) {

        //
        String s = "1";
        convertEmNumero(s)
                .ifPresent(System.out::println);

        //
        Integer integer = convertEmNumero("a").orElse(2);
        System.out.println(integer);

        //
        integer = convertEmNumero("ss").orElseGet(()-> 5 * 3);
        System.out.println(integer);

        //
        Stream.of(100,23,39)
                .findFirst()
                .ifPresent(System.out::println);


        //
        integer = convertEmNumero("x")
                .orElseThrow(()-> new NullPointerException("Valor Vazio"));

        //


    }

    public static Optional<Integer> convertEmNumero(String numero){
        try {
            Integer integer = Integer.valueOf(numero);
            return Optional.of(integer);
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

}
