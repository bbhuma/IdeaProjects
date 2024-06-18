package com.example.java8practice.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsAPImethodsPractice {
	public static void main(String[] args) {
		// Creating stream from arrays.
		String[] array = {"Bala","Bhuma","Gangadhar","Reddy"};
		//print array using Array.toString(array)
		// System.out.println(Arrays.deepToString(array)); ---> if you have arrays inside array.

		System.out.println("String Array printed then comes the stream from it: " + Arrays.toString(array));
		Stream<String> stream1 = Arrays.stream(array);
		List<String> arrayListStream =  stream1.map(t -> t.toUpperCase()).collect(Collectors.toList());
		System.out.println(arrayListStream);
		
		//Create Stream using iterate method, which takes seed and unary operator, which is a fucntion of type T,T
		List<Integer> stream2 = Stream.iterate(0, n ->n+1).limit(100).skip(1).collect(Collectors.toList());
		System.out.println(stream2);
		
		//Create Stream using Stream.of()
		Stream.of("Bala ","niha ","amma ","nanna ").forEach(System.out::print);
		
		//Create Stream using Stream.generate() ---> takes an supplier
		//Operator precendence of * is the highest more than (int),so be careful with brackets. 
		Stream<Integer> stream3 = Stream.generate(()-> (int)(Math.random()*100)).limit(100);
		System.out.println(stream3.collect(Collectors.toList()));
		
		Stream<String> stream4 = Stream.generate(()->"I am loving java8").limit(5);
		System.out.println(stream4.collect(Collectors.toList()));
		
		List<String> listStr = List.of("Bala", "bhuma", "gangadhar", "reddy");
		listStr.stream().filter(x -> x.toLowerCase().startsWith("b")).forEach(System.out::println);
		// you need to use forEach instead of map.
		// Map always goes with .collect which is a terminal operator.

		List<Integer> listInt = List.of(1,1,2,3, 2, 53,3,3, 4, 5,5,6, 6, 7, 8667, 455, 677, 1234);
		System.out.println("Actual List: " + listInt);
		List<Integer> collect = listInt.stream()
				.distinct()
				.sorted((a, b) -> b - a)
				.peek(x->System.out.println(x))
				.filter(x -> x % 2 == 0)
				.map(x-> x/2)
				.limit(3) // starting 4 elements is needed
				.skip(1) // how many elements from start needs to be skipped.
				//.min((a,b)-> a-b).get(); returns integer and not list 
				//.max((a,b)-> a-b).get();
				.collect(Collectors.toList());
		System.out.println("Only Distinct, DESC sorted & Even Numbers of List :"+ collect);
		
		
	}
}
