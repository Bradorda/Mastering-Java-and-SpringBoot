package com.bradorda;

import java.util.*;
import java.util.stream.Collectors;

public class Collect1 {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        //fornecedor - acumulação - combinação
        ArrayList<Integer> collect = list.stream()
                .collect(
                        () -> new ArrayList<>(),
                        (lista, elemento) -> lista.add(elemento),
                        (lista1, lista2) -> lista1.addAll(lista2)
                );
        System.out.println(collect);

        //toList / toSet / toCollection
        List<Integer> collect1 = list.stream()
                .filter((n) -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(collect1);

        //joining
        String join = list.stream()
                .map(n -> n.toString())
                .collect(Collectors.joining("f"));
        System.out.println(join);

        //media
        Double media = list.stream()
                .collect(Collectors.averagingInt(n -> n.intValue()));
        System.out.println(media);

        //sum
        Integer sum = list.stream()
                .collect(Collectors.summingInt(n -> n.intValue()));
        System.out.println(sum);

        IntSummaryStatistics status = list.stream()
                .collect(Collectors.summarizingInt(n -> n.intValue()));
        System.out.println(status);

        //count
        Long collect2 = list.stream()
                .filter(n-> n % 2 == 0)
                .collect(Collectors.counting());
        System.out.println(collect2);

        //max mix
        list.stream()
                .filter( n-> n % 2 == 0)
                .collect(Collectors.maxBy(Comparator.naturalOrder()))
                .ifPresent(System.out::println);

        //groupingBy
        Map<Integer, List<Integer>> collect3 = list.stream()
                .collect(Collectors.groupingBy((n) -> n % 3));
        System.out.println(collect3);

        //partitioningBy
        Map<Boolean, List<Integer>> collect4 = list.stream()
                .collect(Collectors.partitioningBy((n) -> n % 3 == 0));
        System.out.println(collect4);

        //toMap
        Map<Integer, Integer> collect5 = list.stream()
                .collect(Collectors.toMap(n -> n, n -> n * 2));
        System.out.println(collect5);



    }
}
