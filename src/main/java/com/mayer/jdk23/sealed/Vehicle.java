package com.mayer.jdk23.sealed;

public sealed abstract class Vehicle permits Car, Truck {
    public abstract void drive();
}