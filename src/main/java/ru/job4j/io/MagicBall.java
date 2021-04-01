package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        String question = input.nextLine();
        int answer = new Random().nextInt(3);
        System.out.println(
            switch (answer) {
                case 0 -> "Да";
                case 1 -> "Нет";
                default -> "Не знаю";
            }
        );
    }
}
