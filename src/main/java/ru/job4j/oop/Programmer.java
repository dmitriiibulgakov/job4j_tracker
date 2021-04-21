package ru.job4j.oop;

public class Programmer extends Engineer {
    private int coffeePerDay;

    public Programmer(String name, String surname, String education, String birthday,
                      int physicsSkill, int mathsSkill, int coffeePerDay) {
        super(name, surname, education, birthday, physicsSkill, mathsSkill);
        this.coffeePerDay = coffeePerDay;
    }

    public Program makeProgram(Coffee coffee) {
        return null;
    }
}
