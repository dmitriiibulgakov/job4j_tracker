package ru.job4j.oop;

public class Surgeon extends Doctor {
    private int appendicitisCounter;

    public Surgeon(){}

    public Surgeon(int appendicitisCounter) {
        this.appendicitisCounter = appendicitisCounter;
    }

    public void cutAppendicitis(Pacient pacient){}
}
