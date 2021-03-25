package ru.job4j.oop;

public class Builder extends Engineer {
    private int foodPerDay;

    public Builder(String name, String surname, String education, String birthday, int physicsSkill, int mathsSkill, int foodPerDay) {
        super(name, surname, education, birthday, physicsSkill, mathsSkill);
        this.foodPerDay = foodPerDay;
    }

    public Building buildBuilding(Food food){
        return null;
    }
}
