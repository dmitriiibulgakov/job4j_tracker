package ru.job4j.oop;

public class Builder extends Engineer {
    private int foodPerDay;

    public Builder(){}

    public Builder(int foodPerDay) {
        this.foodPerDay = foodPerDay;
    }

    public Building buildBuilding(Food food){
        return null;
    }
}
