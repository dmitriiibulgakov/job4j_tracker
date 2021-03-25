package ru.job4j.pojo;

import java.time.LocalDateTime;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Ivanov Ivan Ivanovich");
        student.setGroup("A-47");
        student.setAcceptedDate(LocalDateTime.now());

        System.out.println("Student: " + student.getFio() + System.lineSeparator() +
                "Group: " + student.getGroup() + System.lineSeparator() +
                "AcceptedDate: " + student.getAcceptedDate());

    }
}
