
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


class Account {
    Long balance;
    List<Transaction> transactions;

    public Account(Long balance, List<Transaction> transactions) {
        this.balance = balance;
        this.transactions = transactions;
    }

    public Long getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}

enum State {
    CANCELED,
    FINISHED
}

public class Ex2_24 {

    /**
     * Calculates the general sum of canceled transactions for all non empty accounts in the list
     */
    public static long calcSumOfCanceledTransOnNonEmptyAccounts(List<Account> accounts) {
       return accounts.stream()
        .filter(x->x.getBalance()>0)
        .flatMap(x -> x.getTransactions().stream())
        .filter(y->y.getState()==State.CANCELED)
        .mapToLong(y->y.getSum())
	.sum();
    }

    public static void main(String[] args) {
        final Transaction t1 = new Transaction(State.CANCELED, 1000L);
        final Account a1 = new Account(0L, Collections.singletonList(t1));

        final Transaction t2 = new Transaction(State.FINISHED, 8000L);
        final Transaction t3 = new Transaction(State.CANCELED, 10_000L);
        final Account a2 = new Account(8000L, Arrays.asList(t2, t3));

        final Transaction t4 = new Transaction(State.FINISHED, 9000L);
        final Transaction t5 = new Transaction(State.CANCELED, 3000L);
        final Account a3 = new Account(8000L, Arrays.asList(t4, t5));

        // 13000 expected
        System.out.println(calcSumOfCanceledTransOnNonEmptyAccounts(Arrays.asList(a1, a2, a3)));
/*
  ArrayList <Account> ara = new ArrayList<>();
 ara.add(new Account("1", -15000, new ArrayList<Transaction>()));
 ara.add(new Account("2", -10000, new ArrayList<Transaction>()));
 ara.add(new Account("3", -5000, new ArrayList<Transaction>()));
 ara.add(new Account("4", 0, new ArrayList<Transaction>()));
 ara.add(new Account("5", 5000, new ArrayList<Transaction>()));
 ara.add(new Account("6", 10000, new ArrayList<Transaction>()));
 ara.add(new Account("7", 15000, new ArrayList<Transaction>()));
 ara.add(new Account("8", 20000, new ArrayList<Transaction>()));
 ara.add(new Account("9", 25000, new ArrayList<Transaction>()));
ara.forEach(
   a->a.getTransactions().add(new Transaction("12", 13000, new Date(), State.CANCELED))//every acc get one transaction with 13000 
 ) ;
 System.out.println(calcSumOfCanceledTransOnNonEmptyAccounts(ara));*/
//Correct output: 65000
//65 000 = 13 000 * 5 cause only accounts from 5 to 9 have balance > 0;


    }
}

class Transaction {
    State state;
    Long sum;

    public Transaction(State state, Long sum) {
        this.state = state;
        this.sum = sum;
    }

    public State getState() {
        return state;
    }

    public Long getSum() {
        return sum;
    }
}



