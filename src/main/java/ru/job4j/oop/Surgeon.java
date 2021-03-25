package ru.job4j.oop;

public class Surgeon extends Doctor {
    private int appendicitisCounter;

    public Surgeon(String name, String surname, String education, String birthday, int anatomySkills, int appendicitisCounter) {
        super(name, surname, education, birthday, anatomySkills);
        this.appendicitisCounter = appendicitisCounter;
    }

    public void cutAppendicitis(Pacient pacient){}
}
