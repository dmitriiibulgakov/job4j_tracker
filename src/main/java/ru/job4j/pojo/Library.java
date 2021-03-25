package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book maths = new Book("Maths", 55);
        Book warAndPeace = new Book("War and Peace", 1000000);
        Book bible = new Book("Holy bible", 1000);
        Book cleanCode = new Book("Clean Code", 500);

        Book[] books = new Book[4];
        books[0] = maths;
        books[1] = warAndPeace;
        books[2] = bible;
        books[3] = cleanCode;

        for (Book book : books) {
            System.out.println(book.getName() + " " + book.getPages());
        }

        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;

        for (Book book : books) {
            System.out.println(book.getName() + " " + book.getPages());
        }

        for (Book book : books) {
            if (book.getName().equals("Clean Code")) {
                System.out.println(book.getName() + " " + book.getPages());
            }
        }

    }
}
