package ru.job4j.oop;

public class Dentist extends Doctor {
    private int toothCounter;

    public Dentist(String name, String surname, String education, String birthday,
                   int anatomySkills, int toothCounter) {
        super(name, surname, education, birthday, anatomySkills);
        this.toothCounter = toothCounter;
    }

    public void cureTooth(Pacient pacient) {

    }
}
