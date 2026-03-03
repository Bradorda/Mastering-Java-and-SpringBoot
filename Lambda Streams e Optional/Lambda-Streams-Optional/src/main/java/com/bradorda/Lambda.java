package com.bradorda;

import java.util.stream.IntStream;

public class Lambda {

    public static void main(String[] args) {

        // interface sem parametro.
        Runnable runnable = () -> System.out.println("test");

        IntStream.range(0,5)
                //caso 2 parametro obrigatório declaração de tipo.
                .filter((int n) -> n % 2 == 0)

                //caso 3 mais de um parametro.
                .reduce((n1, n2) -> n1+ n2)
                .ifPresent(System.out::println);

        //usando chave {}
        IntStream.range(0,5)
                .filter(n -> {
                    System.out.println("x");
                    return n % 2 ==0;
                })
                .forEach(System.out::println);


    }

}
