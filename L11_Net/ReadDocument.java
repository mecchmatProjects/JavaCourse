import java.net.*;
import java.io.*;
public class ReadDocument {
public static void main(String[] args) {
try {
URL lab = new URL("http://www.matfiz.univ.kiev.ua/library/");
InputStreamReader isr =
new InputStreamReader(lab.openStream());
BufferedReader d = new BufferedReader(isr);
String line = "";
while ((line = d.readLine()) != null) {
System.out.println(line);
}
} catch (MalformedURLException e) {
// некорректно заданы протокол, доменное имя или путь к файлу
e.printStackTrace();
} catch (IOException e) {
e.printStackTrace();
}
}
}
