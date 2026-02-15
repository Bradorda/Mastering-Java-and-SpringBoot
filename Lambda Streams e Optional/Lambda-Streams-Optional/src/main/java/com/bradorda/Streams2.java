package com.bradorda;

import java.util.*;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams2 {
    public static void main(String[] args) {

        List<Integer> lista = Arrays.asList(1,2,4,5,6,3,16,20,14,11,10,9,9,2);

        lista.stream()
                .limit(3)
                .map(e -> e * 2)
                .forEach(System.out::println);

        System.out.println("-------------------------------------");

        long count = lista.stream()
                .filter( e-> e % 2 == 0)
                .count();

        System.out.println(count);

        System.out.println("-------------------------------------");

        Optional<Integer> value = lista.stream()
                .filter(e -> e % 2 == 0)
                .min(Comparator.naturalOrder());
             // .max(Comparator.naturalOrder());

        System.out.println(value.get());

        System.out.println("-------------------------------------");

        List<Integer> collect = lista.stream()
                .filter(e -> e % 2 == 0)
                .map( e -> e * 3)
                .collect(Collectors.toList());

        System.out.println(collect);

        System.out.println("-------------------------------------");


        Map<Boolean, List<Integer>> mapa = lista.stream()
                .map(e -> e * 3)
                .distinct()
                .collect(Collectors.groupingBy(e -> e % 2 == 0));

        System.out.println(mapa);

        System.out.println("-------------------------------------");

        //Mapa de numeros agrupados pelo resto da divisão por 3
        Map<Integer, List<Integer>> mapa2 = lista.stream()
                .collect(Collectors.groupingBy(e -> e % 3));
        System.out.println(mapa2);

        System.out.println("-------------------------------------");

        String collectString = lista.parallelStream()
                .map(String::valueOf)// (e -> String.valueOf(e))
                .collect(Collectors.joining(";"));
        System.out.println(collectString);

        System.out.println("-------------------------------------");



        System.out.println("-------------------------------------");

    }
}
