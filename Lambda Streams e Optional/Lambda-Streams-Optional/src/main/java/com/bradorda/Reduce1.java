package com.bradorda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;

public class Reduce1 {

    public static void main(String[] args) {

        String s = "Testando novamente duas vezes pela primeira vez";
        String[] split = s.split(" ");
        List<String> stringList = Arrays.asList(split);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        Optional<Integer> soma = list.stream()
                .parallel()
                .reduce((n1, n2) -> n1 + n2);
        System.out.println(soma.get());
        System.out.println("--------------------------------------");

        Optional<Integer> multiplicacao = list.stream()
                .parallel()
                .reduce((n1, n2) -> n1 * n2);
        System.out.println(multiplicacao.get());
        System.out.println("--------------------------------------");

        Optional<String> concatenacao = stringList.stream()
                .parallel()
                .reduce((s1, s2) -> s1.concat(s2));
        System.out.println(concatenacao.get());
        System.out.println("--------------------------------------");

        // não faça.
        Optional<Integer> sub = list.stream()
                .parallel()
                .reduce((n1, n2) -> n1 - n2);
        System.out.println(sub.get());
        System.out.println("--------------------------------------");

        //utilizando identity.
        Integer soma2 = list.stream()
                .reduce(0, (n1, n2) -> n1 + n2);
        System.out.println(soma2);
        System.out.println("--------------------------------------");

        Integer multiplicacao2 = list.stream()
                .reduce(1, (n1, n2) -> n1 * n2);
        System.out.println(multiplicacao2);
        System.out.println("--------------------------------------");

        String concatenacao2 = stringList.stream()
                .reduce("",(s1, s2) -> s1.concat(s2));
        System.out.println(concatenacao2);
        System.out.println("--------------------------------------");

        // reduce do menor valor
        DoubleStream.of(1.5,2.9,6.7)
                .forEach(System.out::println);
        System.out.println("--------------------------------------");

        double menorValor = DoubleStream.of(1.5, 2.9, 6.7)
                .reduce(Double.POSITIVE_INFINITY, (d1, d2) -> Math.min(d1, d2));
        System.out.println(menorValor);
        System.out.println("--------------------------------------");

        Integer soma3 = list.stream()
                .reduce(0,(n1, n2) -> n1 + n2, (n1, n2) -> n1 + n2);
        System.out.println(soma3);
        System.out.println("--------------------------------------");


        // reduce - map + combiner
        Optional<String> reduce = list.stream()
                .map(n1 -> n1.toString())
                .reduce((n1, n2) -> n1.concat(n2));
        System.out.println(reduce);
        System.out.println("--------------------------------------");

        String reduce2 = list.stream()
                .reduce(
                        "",
                        (n1, n2) -> n1.concat(n2.toString()),
                        String::concat
                );
        System.out.println(reduce2);

    }

}
