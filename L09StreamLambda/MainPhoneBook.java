import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;


class PhoneBook {
    private final Map<String, Collection<PhoneNumber>> nameToPhoneNumbersMap = new HashMap<>();

    public void addNewPhoneNumbers(String name, Collection<PhoneNumber> numbers) {
        // write your code here
		
		nameToPhoneNumbersMap.putIfAbsent(name, numbers); // 
		//nameToPhoneNumbersMap.computeIfPresent(name, (nam, numb) -> numb.add(numbers)); // 
    }

    public void printPhoneBook() {
        // write your code here
	nameToPhoneNumbersMap.entrySet().stream().forEach(e -> {
		System.out.println(e.getKey());
		e.getValue().forEach(x->{
				System.out.println(x.getType() + " " + x.getNumber());
			});
	});
    }
}

enum PhoneNumberType {
    MOBILE, HOME, WORK,
}

class PhoneNumber {

    private PhoneNumberType type;
    private String number;

    public PhoneNumber(PhoneNumberType type, String number) {
        this.type = type;
        this.number = number;
    }

    public PhoneNumberType getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }
}

class MainPhoneBook{

 public static void main(String[] args){
	PhoneBook phoneBook = new PhoneBook();

	phoneBook.addNewPhoneNumbers("Clara", List.of(new PhoneNumber(PhoneNumberType.WORK, "34535")));

	List<PhoneNumber> claraPhoneNumbers = new ArrayList<>();
	claraPhoneNumbers.add(new PhoneNumber(PhoneNumberType.HOME, "723324324"));
	phoneBook.addNewPhoneNumbers("Clara", claraPhoneNumbers);

	List<PhoneNumber> kevinPhoneNumbers = new ArrayList<>();
	kevinPhoneNumbers.add(new PhoneNumber(PhoneNumberType.WORK, "1231"));
	phoneBook.addNewPhoneNumbers("Kevin", kevinPhoneNumbers);

	phoneBook.addNewPhoneNumbers("Clara", List.of(new PhoneNumber(PhoneNumberType.MOBILE, "23424279")));
	phoneBook.addNewPhoneNumbers("Paul", List.of(new PhoneNumber(PhoneNumberType.WORK, "56756335")));

	phoneBook.printPhoneBook();

	}

}
