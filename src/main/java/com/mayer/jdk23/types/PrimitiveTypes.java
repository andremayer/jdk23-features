package com.mayer.jdk23.types;

public class PrimitiveTypes {

	public static void main(String[] args) {
		Object obj = 42;
		switch (obj) {
		    case Integer i -> System.out.println("Integer: " + i);
		    case Long l    -> System.out.println("Long: " + l);
		    default        -> System.out.println("Other: " + obj);
		}
	}

}
