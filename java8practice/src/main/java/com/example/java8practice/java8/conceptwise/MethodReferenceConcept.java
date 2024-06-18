package com.example.java8practice.java8.conceptwise;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
Consumer:
Functions like forEach in streams (Stream.forEach(Consumer<? super T> action)), accept in CompletableFuture, etc., take Consumer as arguments.

Predicate:
Functions like filter in streams (Stream.filter(Predicate<? super T> predicate)), removeIf in collections (Collection.removeIf(Predicate<? super E> filter)), etc., take Predicate as arguments.

Function:
Functions like map in streams (Stream.map(Function<? super T, ? extends R> mapper)), compute in ConcurrentMap, etc., take Function as arguments.

Supplier:
Functions like generate in streams (Stream.generate(Supplier<T> s)), supplyAsync in CompletableFuture, etc., take Supplier as arguments.*/
public class MethodReferenceConcept {

	public static void main(String[] args) {
		// Predicate
		Predicate<String> predicate1 = MethodReferenceConcept::isNotEmpty;
		System.out.println(predicate1.test("Hello")); // Output: true

		Predicate<String> predicate2 = "test"::startsWith;
		System.out.println(predicate2.test("tes")); // Output: true

		// Function
		Function<String, Integer> function1 = Integer::parseInt;
		System.out.println(function1.apply("123")); // Output: 123

		String prefix = "Hello";
		Function<Integer, String> function2 = prefix::substring;
		System.out.println(function2.apply(1)); // Output: "ello"

		// Consumer
		Consumer<String> consumer1 = System.out::println;
		consumer1.accept("Hello"); // Output: Hello

		List<String> list = new ArrayList<>();
		Consumer<String> consumer2 = list::add;
		consumer2.accept("Item 1");
		consumer2.accept("Item 2");
		System.out.println(list); // Output: [Item 1, Item 2]

		// Supplier
		Supplier<Double> supplier1 = Math::random;
		System.out.println(supplier1.get()); // Output: a random number

		Random random = new Random();
		Supplier<Integer> supplier2 = random::nextInt;
		System.out.println(supplier2.get()); // Output: a random integer
	}

	// Additional method for Predicate example
	public static boolean isNotEmpty(String str) {
		return str != null && !str.isEmpty();
	}
}
