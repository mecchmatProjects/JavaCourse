import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
/*
In this exercise, you need to write some code with predicates to filter a list of account objects (List<Account>) in two different ways.

Here is the definition of the Account class:

class Account {
    private String number;
    private long balance;
    private boolean locked;

    // constructor, getters and setters
}

There is also a method that can filter the list filter(List<T> elems, Predicate<T> predicate). It takes a list and a predicate containing the filtering condition.

Write code for filtering the accounts list using the filter method in two ways:

    get all non-empty accounts (balance > 0) and save it to the variable nonEmptyAccounts
    get all non-locked accounts with too much money (balance >= 100 000 000) and save it to the variable accountsWithTooMuchMoney

Use the given code template for your solution. Please, do not change it.

There is an example of using the filter method. The code below gets only even numbers from a list.

List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
List<Integer> evenNumbers = filter(numbers, number -> number % 2 == 0); // 2, 4, 6
*/

class MainAccount2 {

    public static void printFilteredAccounts(List<Account> accounts) {
        List<Account> nonEmptyAccounts = filter(accounts, account->account.getBalance()>0);// write your code here
        List<Account> accountsWithTooMuchMoney = filter(accounts, account->{ return ((account.getBalance()>=100_000_000) && !account.isLocked());});// write your code here

        // Please, do not change the code below
        nonEmptyAccounts.forEach(a -> System.out.print(a.getNumber() + " "));
        accountsWithTooMuchMoney.forEach(a -> System.out.print(a.getNumber() + " "));
    }

    public static <T> List<T> filter(List<T> elems, Predicate<T> predicate) {
        return elems.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Account> accounts = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] values = scanner.nextLine().split("\\s+");
            Account acc = new Account(
                    values[0], 
                    Long.parseLong(values[1]), 
                    Boolean.parseBoolean(values[2])
            );
            accounts.add(acc);
        }

        printFilteredAccounts(accounts);
    }

    static class Account {
        private String number;
        private long balance;
        private boolean locked;

        public Account(String number, long balance, boolean locked) {
            this.number = number;
            this.balance = balance;
            this.locked = locked;
        }

        public long getBalance() {
            return balance;
        }

        public void setBalance(long balance) {
            this.balance = balance;
        }

        public boolean isLocked() {
            return locked;
        }

        public void setLocked(boolean locked) {
            this.locked = locked;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        @Override
        public String toString() {
            return "Account{" +
                    "number='" + number + '\'' +
                    ", balance=" + balance +
                    ", isLocked=" + locked +
                    '}';
        }
    }
}
