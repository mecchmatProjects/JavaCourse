import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class Accounts{

	static class Account{

		String number;
		Long balance;
		boolean isLocked;

		List<Account> accounts;

		public String getNumber() {
			return number;
		}

		public Long getBalance() {
			return balance;
		}

		public boolean isLocked() {
			return isLocked;
		}

		public Account() {
			Random r = new Random();
			this.number = Integer.toString(Math.abs(r.nextInt(1000)));
			this.balance = r.nextLong();
			this.isLocked = (r.nextInt() >= 0) ? true : false;
		}

		@Override
		public String toString() {
			return "Account [number=" + number + ", balance=" + balance + ", isLocked=" + isLocked + "]";
		}
	}

	public static ArrayList<Account> randomAccountsList(int size){
		ArrayList<Account> accounts = new ArrayList<>();
		for(int i = 1;i <= size;i++) accounts.add(new Account());
		return accounts;
	}

	public static <T> List<T> filter(List<T> elems, Predicate<T> predicate) {
		List<T> filtered = new ArrayList<>();
		for(T element : elems) {
			if(predicate.test(element))filtered.add(element);
		}
		return filtered;
	}

	public static void main(String[] args) {
		ArrayList<Account> acsList = randomAccountsList(15);
		acsList.forEach(System.out::println);

		List<Account> nonEmptyAccounts = filter(acsList, predicate-> predicate.balance > 0);
		System.out.println("-------------------------------------------------------------");
		nonEmptyAccounts.forEach(System.out::println);

		List<Account> accountsWithTooMuchMoney = filter(acsList, predicate -> !predicate.isLocked);
		accountsWithTooMuchMoney = filter(accountsWithTooMuchMoney, predicate -> predicate.balance > 100000);
		System.out.println("-------------------------------------------------------------");
		accountsWithTooMuchMoney.forEach(System.out::println);
	}
}
/*
// you need to filter List<Account> accounts

List<Account> nonEmptyAccounts = filter(accounts, predicate-> predicate.balance > 0);

List<Account> accountsWithTooMuchMoney = filter(accounts, predicate -> !predicate.isLocked);
accountsWithTooMuchMoney = filter(accountsWithTooMuchMoney, predicate -> predicate.balance >= 100000000);

// just an example
// List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
// List<Integer> evenNumbers = filter(numbers, number -> number % 2 == 0);

*/
