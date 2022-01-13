import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


class Transaction {

    String uuid;
    Long sum;
    Account account;

    public Transaction(String uuid, Long sum, Account account) {
        this.uuid = uuid;
        this.sum = sum;
        this.account = account;
    }

    public String getUuid() {
        return uuid;
    }

    public Long getSum() {
        return sum;
    }

    public Account getAccount() {
        return account;
    }
}

class Account {
    String number;
    Long balance;

    public Account(String number, Long balance) {
        this.number = number;
        this.balance = balance;
    }

    public Long getBalance() {
        return balance;
    }

    public String getNumber() {
        return number;
    }
}


public class Test_Collector {
   static Map<String, Long> totalSum (List<Transaction> transactions ){
        Map<String, Long> msl = transactions.stream()
        .collect( Collectors.groupingBy(tr -> tr.getAccount().getNumber(), Collectors.summingLong(Transaction::getSum))); 
// Collectors.groupingBy(tr -> tr.getAccount().getNumber(), Collectors.summingLong(Transaction::getSum))
        return msl;
    }

    public static void main(String[] args) {
        List <Transaction> ara = new ArrayList<>();
        Account ac1 = new Account("101", 2000L);
        Account ac2 = new Account("102", 2500L);
        Account ac3 = new Account("103", 3000L);
        ara.add(new Transaction("101_1", 5000L, ac1)); 
        ara.add(new Transaction("101_2", 5000L, ac1));
        ara.add(new Transaction("102_1", 10000L, ac2));
        ara.add(new Transaction("102_2", 10000L, ac2));
        ara.add(new Transaction("103_1", 15000L, ac3));
        ara.add(new Transaction("103_2", 15000L, ac3));
        for(Map.Entry<String, Long> msl : totalSum(ara).entrySet()){
            System.out.println(msl.toString());
        }
    }
}
/*
Must be output: 
100=10000
102=20000
103=30000*/
