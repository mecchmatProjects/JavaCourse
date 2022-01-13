import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

record Account(String number, long balance, boolean locked) { }

class Main {
    private static final long TOO_MUCH_MONEY_LIMIT = 100_000_000L;

    public static void printFilteredAccounts(List<Account> accounts) {
        List<Account> nonEmptyAccounts = filter(accounts, account -> account.balance() > 0);
        List<Account> accountsWithTooMuchMoney = filter(accounts, 
            account -> account.balance() >= TOO_MUCH_MONEY_LIMIT && !account.locked());

        // Please, do not change the code below
        nonEmptyAccounts.forEach(a -> System.out.print(a.number() + " "));
        accountsWithTooMuchMoney.forEach(a -> System.out.print(a.number() + " "));
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
}
