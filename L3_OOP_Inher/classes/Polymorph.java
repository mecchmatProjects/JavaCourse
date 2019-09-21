package classes;

class CardAction {
    float amount;
    public void doPayment(double d) {
             // реалізация
             System.out.println("complete from debt card");
             amount -= d; 
    }
}
class CreditCardAction extends CardAction {
	final float payLimit = 1000.0f;
    public boolean checkCreditLimit() { // новий метод
             return (amount>0); // stub
    }
    @Override // ця анотація вказує на поліморфізм 
    public void doPayment(double amountPayment) { // перевизначений метод
            System.out.println("complete from credit card");
            if (checkCreditLimit()){
            	amount -= amountPayment; 
            }
    }
}


public class Polymorph {
    public static void main(String[ ] args) {
        CardAction dc1 = new CardAction();
        CardAction dc2 = new CreditCardAction();
        CreditCardAction cc = new CreditCardAction();
        // CreditCardAction cca = new CardAction(); // помилка компіляції
        dc1.doPayment(15.5); // метод класу CardAction
        dc2.doPayment(21.2); // поліморфний метод класу CreditCardAction
        cc.doPayment(7.0); // поліморфний метод класу CreditCardAction
        cc.checkCreditLimit(); // неполіморфний метод класу CreditCardAction
        // dc2.checkCreditLimit(); // помилка компиляции – неполіморфний метод
        ((CreditCardAction)dc1).checkCreditLimit(); // помилка під час виконання
        ((CreditCardAction)dc2).checkCreditLimit(); // ок
   }
}
