package ru.job4j.oop;

public class Engineer extends Profession {
    private int physicsSkill;
    private int mathsSkill;

    public Engineer(String name, String surname, String education, String birthday, int physicsSkill, int mathsSkill) {
        super(name, surname, education, birthday);
        this.physicsSkill = physicsSkill;
        this.mathsSkill = mathsSkill;
    }

    public Documentation makeDocumentation(){
        return null;
    }

    public int calcSquare(int a, int b){
        return 0;
    }
}
