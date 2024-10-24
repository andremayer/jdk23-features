package com.mayer.jdk23.constructors;

public class MyClass {
	private int value;

	//JDK 23 permits statements that do not reference the instance being created to execute before this() or super() calls in constructors.
	public MyClass(int value) {
		int preInitialization = value * 2; 
		this.value = preInitialization;
	}
}