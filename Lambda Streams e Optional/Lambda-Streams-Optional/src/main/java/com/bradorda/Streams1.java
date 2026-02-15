package com.bradorda;

import java.util.Arrays;
import java.util.List;

public class Streams1 {
    public static void main(String[] args) {

        List<Integer> lista = Arrays.asList(1,2,4,5,6,3,16,20,14,11,10,9,9,2);

        lista.stream()
                .skip(2)
                .forEach(System.out::println);

        System.out.println("-------------------------");

        lista.stream()
                .limit(2)
                .forEach(System.out::println);

        System.out.println("-------------------------");

        lista.stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println("-------------------------");

        lista.stream()
                .skip(2)
                .limit(3)
                .distinct()
                .forEach(System.out::println);

        System.out.println("-------------------------");

        lista.stream().filter( e -> e % 2 == 0)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        System.out.println("-------------------------");

        lista.stream()
                .limit(3)
                .map(e -> e *2)
                .forEach(System.out::println);

    }
}