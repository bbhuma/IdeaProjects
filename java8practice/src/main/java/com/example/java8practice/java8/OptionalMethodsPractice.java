package com.example.java8practice.java8;

import java.util.Optional;

public class OptionalMethodsPractice {

	public static void main(String[] args) {

		Optional<String> optionalStr = getName(2);
		Optional<String> optionalUpper = optionalStr.map(String::toUpperCase);

		// Usage of isPresent and ifPresent methods of Optional.
		System.out.println("1" + optionalStr); // ------>print Optional[Bala] when value is present and 1Optional.empty when we send empty or null.
		System.out.println("2" + optionalStr.get()); // .get() prints Bala, if present, else throws null pointer exception ----> gives body of the getName

		if (optionalStr.isEmpty()) {
		}

		if (optionalStr.isPresent()) {
			System.out.println("3" + optionalStr.get());
		}
		
		//single line code. concise code, preferred.
		optionalStr.ifPresent(x -> System.out.println(x));
		// --> ifPresent is better than isPresent,
		// ifPresent takes a consumer, takes input and does something.

		//Usage of .orElse ---> Use if you have single line of code. 
		// and optional.orElseGet()---> Use when you need to multiple lines of code. 
		
		String str1 = optionalStr.isPresent() ? optionalStr.get() : "NA"; 
		System.out.println("4"+ str1);
		
		//--> write same with orElse() ---> prints the same
		String str2 = optionalStr.orElse("NA");
		System.out.println("5"+ str2);
		

		//String str3 = optionalStr.orElseThrow(()-> new NullPointerException("Fix this null pointer shit"));

		
	}

	// Return Optional value to make the method return Optional<String>
	// This helps us understand that the method can return null values, so we need
	// to handle the null values.
	public static Optional<String> getName(int id) {
		String str= null;
		// db code to get name
		// return "bala";
		//return Optional.of("bala"); ---> this is valid, but fials for null. 
		// return Optional.of(str); ---> when str is null, this .of() can not handle, thrwos null pointer Exception. So go for .ofNullable()
		// return Optional.empty(); //---> to return null
		// return Optional.of("Bala");
		return Optional.ofNullable("bala");
		//return Optional.ofNullable(null);
	}

}
