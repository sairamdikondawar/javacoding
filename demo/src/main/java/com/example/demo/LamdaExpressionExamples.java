package com.example.demo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LamdaExpressionExamples {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate nextWednesday =
                today.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
        System.out.println("Next Wednesday on : " + nextWednesday);


        List<Integer> numbers = Arrays.asList(5, 4, 10, 12, 87, 33, 75, 7, 17);


        Integer stats = numbers.stream().collect(Collectors.summingInt(Integer::intValue));
        System.out.println("Sum of all numbers : " + stats);

        Long count = numbers.stream().collect(Collectors.counting());
        System.out.println("Count of all numbers : " + count);

        Integer reducedCount = numbers.stream().peek(System.out::println).collect(Collectors.reducing(1, (a, b) -> (a * b)));

        System.out.println("Multiplication of all numbers : " + reducedCount);

        Optional<Integer> maxNumber = numbers.stream().collect(Collectors.maxBy((a, b) -> (a - b)));
        System.out.println("maxNumber of all numbers : " + maxNumber.get());

        Optional<Integer> minNUmber = numbers.stream().collect(Collectors.minBy((a, b) -> (a - b)));
        System.out.println("minNUmber of all numbers : " + minNUmber.get());

        List<Integer> evenNumber = numbers.stream().filter(e -> e % 2 == 0).collect(Collectors.toList());
        System.out.println("Even Number  : ");
        evenNumber.stream().forEach(e -> System.out.println(e));

        List<Integer> oddNumbers = numbers.stream().filter(e -> e % 2 != 0).collect(Collectors.toList());
        System.out.println("Odd Number  : ");
        oddNumbers.stream().forEach(e -> System.out.println(e));

        System.out.println("Prime Numbers  : ");
        numbers.stream().filter(e -> isPrime(e) == true).collect(Collectors.toList()).stream().forEach(e -> {
            System.out.println(e);
        });

        System.out.println(" Two Prime Numbers  : ");
        numbers.stream().filter(e -> isPrime(e) == true).skip(0).limit(2).collect(Collectors.toList()).stream().forEach(e -> {
            System.out.println(e);
        });

        System.out.println("First Prime Numbers  : ");
        System.out.println(numbers.stream().filter(e -> isPrime(e) == true).findFirst());

        System.out.println("FindAny Prime Numbers  : ");
        System.out.println(numbers.stream().filter(e -> isPrime(e) == true).findAny());

        System.out.println("Factorial Of Number  : 5 is");

        System.out.println(IntStream.rangeClosed(1, 5).reduce(1, (a, b) -> (a * b)));

        int n = 5;
        System.out.println("fibonacci Series  Of Number  : 5 is");
        Stream.iterate(new long[]{0, 1}, f -> new long[]{f[1], f[0] + f[1]})
                .limit(n).map((a) -> a[0]).forEach(e -> System.out.println(e));


    }

    public static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);
    }

}