mport java.io.*;
import java.net.*;
public class MyClientSocket {
public static void main(String[] args) {
Socket socket = null;
try { // получение строки клиентом
socket = new Socket("ИМЯ_СЕРВЕРА", 8030);
/* здесь "ИМЯ_СЕРВЕРА" компьютер,
на котором стоит сервер-сокет"*/
BufferedReader br =
new BufferedReader(
new InputStreamReader(
socket.getInputStream()));
String msg = br.readLine();
System.out.println(msg);
socket.close();
} catch (IOException e) {
System.err.println("ошибка: " + e);
}
}
}
