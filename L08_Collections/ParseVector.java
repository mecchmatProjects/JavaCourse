import java.util.*;
class Parse{
public static void main(String[] args){
Vector v = new Vector(); 
String s = "String, that we want to decompose in words."; 

StringTokenizer st = new StringTokenizer(s, " \t\n\r,."); 

while (st.hasMoreTokens()){ 
 // Одержуємо слово і заносимо у вектор 
 v.add(st.nextToken()); // Додаємо в кінець вектора 
} 
System.out.println(v.firstElement()); // Перший елемент 
System.out.println(v.lastElement()); // Останній елемент 
v.setSize(4); // Зменшуємо число елементів 
v.add("compose"); // Додаємо в кінець вкороченого вектора 
v.set(3, "again"); // Ставимо в позицію 3 
for (int i = 0; i < v.size(); i++)// Перебираємо весь вектор 
System.out.print(v.get(i) + " "); 
System.out.println(); 
}
}
