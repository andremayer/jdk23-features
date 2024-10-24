package com.mayer.jdk23.streams;

import java.util.List;
import java.util.stream.Stream;

public class Streams {
	
	public static void main(String[] args) {
		List<String> result = Stream.of("a", "b", "c", "d")
	            .map(String::toUpperCase)
	            .toList();
		
		System.out.println(result);
	}
	
}

