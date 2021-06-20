package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает главный сервис банка
 * @author DMITRIY BULGAKOV
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение всех пользователей осуществляется в коллекции HashMap
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляет нового пользователя в систему банка
     * @param user - пользователь банка
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Добавляет новый счёт пользователю банка
     * @param passport - номер паспорта пользователя банка
     * @param account  - добавляемый счёт
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Находит пользователя по паспорту
     * @param passport - номер паспорта пользователя банка
     * @return возвращает найденного пользователя банка
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Ищет по реквизитам счёт пользователя
     * @param passport - номер паспорта
     * @param requisite - реквизиты счёта
     * @return возвращает найденный счёт
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return user.flatMap(value -> users.get(value).stream()
                .filter(account -> account.getRequisite().equals(requisite))
                .findFirst());
    }

    /**
     * Перечисляет деньги с одного счёта на другой
     * @param srcPassport - номер паспорта плательщика
     * @param srcRequisite - реквизиты счёта плательщика
     * @param destPassport - номер паспорта получателя
     * @param destRequisite - реквизиты счёта получателя
     * @param amount - перечисляемая сумм
     * @return возвращает true, если деньги были перечислены, иначе false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && destAccount.isPresent()
                && srcAccount.get().getBalance() >= amount) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            return true;
        }
        return false;
    }
}
