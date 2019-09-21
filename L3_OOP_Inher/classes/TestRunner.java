package classes;
import java.util.Random;

abstract class AbstractQuest {
    private long id;
    private String questContent;
            // конструкторы и методы
    public abstract boolean check(Answer ans);
}
class DragnDropQuest extends AbstractQuest {
            // пол€, конструкторы и методы
    @Override
    public boolean check(Answer ans) {
        System.out.println("Drag'n'Drop quest");
            // проверка корректности ответа (true или false)
        return true; // stub
    }
}
class SingleChoiceQuest extends AbstractQuest {
           // пол€, конструкторы и методы
    @Override
    public boolean check(Answer ans) {
        System.out.println("Single choice quest");
           // проверка корректности ответа true или false
        return true; // stub
    }
}

 class Answer {
    // пол€ и методы
}
 class QuestFactory { // шаблон Factory Method (упрощенный)
public static AbstractQuest getQuestFromFactory(int mode) {
     switch (mode) {
               case 0:
                         return new DragnDropQuest();
               case 1:
                         return new SingleChoiceQuest();
               default :
                         throw new IllegalArgumentException("illegal mode");
                         // assert false; // плохо
                         // return null;  // еще хуже
     }
}
}
 class TestAction {
public AbstractQuest[] generateTest(final int NUMBER_QUESTS, int maxMode) {
     AbstractQuest[ ] test = new AbstractQuest[NUMBER_QUESTS];
     for (int i = 0; i < test.length; i++) {
                  int mode = new Random().nextInt(maxMode); // stub
                  /* заполнение массива объектами-вопросами */
                  test[i] = QuestFactory.getQuestFromFactory(mode);
     }
     return test;
}
public int checkTest(AbstractQuest[] test) {
     int counter = 0;
     for (AbstractQuest s : test) {
               // вызов полиморфного метода
               counter = s.check(new Answer()) ? ++counter : counter;
     }
     return counter;
}
}
public class TestRunner {
public static void main(String[ ] args) {
TestAction bt = new TestAction();
AbstractQuest[ ] test = bt.generateTest(60, 2); // 60 вопросов 2-х видов
// здесь должен быть код процесса прохождени€ теста Е
bt.checkTest(test); // проверка теста
}
}

