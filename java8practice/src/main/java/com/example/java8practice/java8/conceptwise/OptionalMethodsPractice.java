package com.example.java8practice.java8.conceptwise;

import java.util.Optional;

public class OptionalMethodsPractice {

	public static void main(String[] args) {

		Optional<String> optionalStr = getName(2);
		Optional<String> optionalUpper = optionalStr.map(String::toUpperCase);

		// Usage of isPresent and ifPresent methods of Optional.
		System.out.println("1" + optionalStr); // ------>print Optional[Bala] when value is present and 1Optional.empty
												// when we send empty or null.
		// System.out.println("2" + optionalStr.get()); // .get() prints Bala, if
		// present, else throws null pointer exception ----> gives body of the getName

		if (optionalStr.isEmpty()) {
		}

		if (optionalStr.isPresent()) {
			System.out.println("3" + optionalStr.get());
		}

		// single line code. concise code, preferred.
		optionalStr.ifPresent(x -> System.out.println("4" + x));
		optionalStr.ifPresent(x -> x.toCharArray());
		optionalStr.ifPresentOrElse(x -> System.out.println("5" + x),
				() -> System.out.println("From line 26 Null Pointer Exceptions are well handled, Not found"));
		// --> ifPresent is better than isPresent,
		// ifPresent takes a consumer, takes input and does something.

		// Usage of .orElse ---> Use if you have single line of code.
		// and optional.orElseGet()---> Use when you need to multiple lines of code.

		String str1 = optionalStr.isPresent() ? optionalStr.get() : "From line 34 Null Pointer Exceptions are well handled, Not found";
		System.out.println("6" + str1);

		// --> write same with orElse() ---> prints the same
		String str2 = optionalStr.orElse("From line 39 Null Pointer Exceptions are well handled, Not found");
		System.out.println("7" + str2);

		// String str3 = optionalStr.orElseThrow(()-> new NullPointerException("Fix this
		// null pointer shit"));

	}

	// Return Optional value to make the method return Optional<String>
	// This helps us understand that the method can return null values, so we need
	// to handle the null values.
	public static Optional<String> getName(int id) {
		String str = "bala";
		// db code to get name
		// return "bala";
		// return Optional.of("bala"); ---> this is valid, but fials for null.
		// return Optional.of(null);
		// return Optional.of(str); ---> when str is null, this .of() can not handle,
		// thrwos null pointer Exception. So go for .ofNullable()
		// return Optional.empty(); //---> to return null
		// return Optional.of(str);
		return Optional.ofNullable(str); //----> Options.ofNullable tells the method that this valus can be null, the line does not break when null comes. you need to handle it later when you apply methods on top of it using isPresent or ifPresent. 
		// return Optional.ofNullable(null);
	}

}
