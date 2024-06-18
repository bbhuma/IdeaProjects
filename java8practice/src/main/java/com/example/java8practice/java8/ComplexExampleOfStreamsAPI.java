package com.example.java8practice.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Product {
	private String name;
	private double price;

	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Product{" + "name='" + name + '\'' + ", price=" + price + '}';
	}
}

public class ComplexExampleOfStreamsAPI {

	public static void main(String[] args) {
		List<Product> products = Arrays.asList(
		        new Product("Laptop", 1200),
		        new Product("Phone", 800),
		        new Product("Headphones", 150),
		        new Product("Mouse", 40),
		        new Product("Keyboard", 60)
		);

		List<String> filteredProducts = products.stream()
		        .filter(product -> product.getPrice() > 100)
		        .map(product -> new Product(product.getName(), product.getPrice() * 2))
		        .map(Product :: getName) // Extract product names
		        .collect(Collectors.toList());

		System.out.println("\nProducts: ");
		//products.forEach(product->System.out.println(product));
		products.forEach(System.out::println);
		System.out.println("\nFiltered Product_Names: " + filteredProducts);
}
}
