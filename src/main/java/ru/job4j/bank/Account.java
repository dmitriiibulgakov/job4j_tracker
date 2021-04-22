package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель банковского счёта.
 * Модель содержит поля: баланс и реквизиты.
 * @author DMITRIY BULGAKOV
 * @version 1.0
 */
public class Account {
    private String requisite;
    private double balance;

    /**
     * Конструктор класса
     * @param requisite - реквизиты счёта
     * @param balance   - баланс счёта
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * @return возвращает реквизиты счёта
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Устанавливает новые реквизиты счёта
     * @param requisite - реквизиты счёта
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * @return возвращает баланс счёта
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Изменяет баланс на счёте
     * @param balance - новый баланс счёта
     */
    public void setBalance(double balance) {
        this.balance = balance;
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
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * @return возвращает хэш код объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
