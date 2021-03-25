package ru.job4j.oop;

public class Doctor extends Profession{
    private int anatomySkills;

    public Doctor(){}

    public Doctor(int anatomySkills) {
        this.anatomySkills = anatomySkills;
    }

    public Diagnosis heal(Pacient pacient){
        return null;
    }
}
