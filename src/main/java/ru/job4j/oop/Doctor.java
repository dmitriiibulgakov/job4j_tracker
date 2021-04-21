package ru.job4j.oop;

public class Doctor extends Profession {
    private int anatomySkills;

    public Doctor(String name, String surname, String education,
                  String birthday, int anatomySkills) {
        super(name, surname, education, birthday);
        this.anatomySkills = anatomySkills;
    }

    public Diagnosis heal(Pacient pacient) {
        return null;
    }
}
