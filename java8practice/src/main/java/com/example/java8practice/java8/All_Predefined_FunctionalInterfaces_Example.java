package com.example.java8practice.java8;

import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class All_Predefined_FunctionalInterfaces_Example {

    // Example Predicate: Check if a string is a palindrome
    public static Predicate<String> isPalindrome = str -> {
        String cleanStr = str.replaceAll("\\s+", "").toLowerCase();
        return cleanStr.equals(new StringBuilder(cleanStr).reverse().toString());
    };

    // Example Function: Convert a string to its length
    public static Function<String, Integer> stringLength = String::length;

    // Example Consumer: Print a string with a prefix
    public static Consumer<String> printWithPrefix = str -> System.out.println("Prefix: " + str);

    // Example Supplier: Supply a default greeting message
    public static Supplier<String> defaultGreeting = () -> "Hello, World!";

    // Function that uses all four functional interfaces
    public static void processString(String str) {
        // Predicate usage
        if (isPalindrome.test(str)) {
            System.out.println(str + " is a palindrome.");
        } else {
            System.out.println(str + " is not a palindrome.");
        }

        // Function usage
        int length = stringLength.apply(str);
        System.out.println("The length of the string is: " + length);

        // Consumer usage
        printWithPrefix.accept(str);

        // Supplier usage
        String greeting = defaultGreeting.get();
        System.out.println("Greeting: " + greeting);
    }

    public static void main(String[] args) {
        // Testing individual functional interfaces
        System.out.println(isPalindrome.test("A man a plan a canal Panama")); // Output: true
        System.out.println(stringLength.apply("Hello")); // Output: 5
        printWithPrefix.accept("Sample String"); // Output: Prefix: Sample String
        System.out.println(defaultGreeting.get()); // Output: Hello, World!

        // Testing the processString method
        processString("A man a plan a canal Panama");
        processString("Hello");
    }
}
