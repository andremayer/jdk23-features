package com.mayer.jdk23.sealed;
public final class Car extends Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a car");
    }
}