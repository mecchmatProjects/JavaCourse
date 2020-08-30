import java.util.regex.Matcher;
import java.util.Arrays;
public class DemoRegular {
public static void main(String[ ] args) {
// проверка на соответствие строки шаблону
Pattern p1 = Pattern.compile("a+y");
Matcher m1 = p1.matcher("aaay");
boolean b = m1.matches();
System.out.println(b);
// поиск и выбор подстроки, заданной шаблоном
String regex = "(\\w{6,})@(\\w+\\.)([a-z]{2,4})";
String s = "адреса эл.почты:blinov@gmail.com, romanchik@bsu.by!";
Pattern p2 = Pattern.compile(regex);
Matcher m2 = p2.matcher(s);
while (m2.find()) {
System.out.println("e-mail: " + m2.group());
}
// разбиение строки на подстроки с применением шаблона в качестве разделителя
Pattern p3 = Pattern.compile("\\d+\\s?");
String[ ] words = p3.split("java5tiger 77 java6mustang");
System.out.print(Arrays.toString(words));
}
}
