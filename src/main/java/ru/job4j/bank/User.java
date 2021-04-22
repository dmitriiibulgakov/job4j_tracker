package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель пользователя банка.
 * Содержит поля: пасспорт и имя пользователя
 * @author DMITRIY BULGAKOV
 * @version 1.0
 */
public class User {
    private String passport;
    private String username;

    /**
     * Конструктор класса.
     * @param passport - пасспорт пользователя
     * @param username - имя пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * @return возвращает пасспорт пользователя
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Устанавливает паспорт пользователя
     * @param passport - паспорт пользователя
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * @return возвращает имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Устанавливает имя пользователя
     * @param username - имя пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Сравнивает объект данного класса с другим объектом
     * @param o - объект с которым будет проводится сравнение
     * @return возвращает true, если объекты равны, иначе false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * @return возвращает хэш код объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
