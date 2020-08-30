package tr;

import java.util.Formatter;
public class FormatterDemoFlags {
  public static void main(String[] args) {
   Formatter f = new Formatter();
   // выравнивание вправо
   f.format("|%10.2f|", 123.123);
   System.out.println(f);
   // выравнивание влево
   // применение флага '-'
   f = new Formatter();
   f.format("|%-10.2f|", 123.123);
   System.out.println(f);
   f = new Formatter();
   f.format("% (d", -100);
   // применение флага ' ' и '('
   System.out.println(f);
   f = new Formatter();
   f.format("%,.2f", 123456789.34);
   // применение флага ','
   System.out.println(f);
   f = new Formatter();
   f.format("%.4f", 1111.1111111);
   // задание точности представления для чисел
   System.out.println(f);
   f = new Formatter();
   f.format("%.16s", "Now I know class java.util.Formatter");
   // задание точности представления для строк
   System.out.println(f);
  }
}
