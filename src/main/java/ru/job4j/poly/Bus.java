package ru.job4j.poly;

public class Bus implements Transport {
    private int passengers;

    @Override
    public void go() {
        System.out.println("Go go go");
    }

    @Override
    public void passengers(int number) {
        passengers = number;
    }

    @Override
    public float refuel(int fuel) {
        return fuel * 55.34f;
    }
}
