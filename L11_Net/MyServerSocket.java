mport java.io.*;
import java.net.*;
public class MyServerSocket {
public static void main(String[] args) {
Socket s = null;
try { // отправка строки клиенту
//создание объекта и назначение номера порта
ServerSocket server = new ServerSocket(8030);
s = server.accept();//ожидание соединения
PrintStream ps =
new PrintStream(s.getOutputStream());
// помещение строки "привет!" в буфер
ps.println("привет!");
// отправка содержимого буфера клиенту и его очищение
ps.flush();
ps.close();
} catch (IOException e) {
System.err.println("Ошибка: " + e);} finally {
if (s != null)
s.close(); // разрыв соединения
}
}
}
