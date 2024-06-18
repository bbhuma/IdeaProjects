package com.example.java8practice.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapVsForEachExample {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Enters number list : "+numbers);
      
        // Map does not return anything, it just transforms the same list inot a new one, 
        // ForEach iterates over the List and does some function on each element. 

        // Using map to double each number and collect them into a new list
        List<Integer> doubledNumbers = numbers.stream()
                                              .map(n -> n * 2)
                                              .collect(Collectors.toList());
        System.out.println("Doubled Numbers: " + doubledNumbers);

        // Using forEach to print each doubled number
        numbers.stream()
               .map(n -> n * 2)
               .forEach(System.out::println);
    }
}