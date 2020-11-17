import java.io.*;
import java.net.*;
public class NetClientThread {
public static void main(String[] args) {
try {
// установка соединения с сервером
Socket s = new Socket(InetAddress.getLocalHost(), 8071);
//или Socket s = new Socket("ИМЯ_СЕРВЕРА", 8071);
PrintStream ps = new PrintStream(s.getOutputStream());
BufferedReader br = new BufferedReader(
new InputStreamReader(s.getInputStream()));
for (int i = 1; i <= 10; i++) {
ps.println("PING");
System.out.println(br.readLine());
Thread.sleep(1000);
}
s.close();
} catch (UnknownHostException e) {
// если не удалось соединиться с сервером
System.out.println("адрес недоступен");
e.printStackTrace();} catch (IOException e) {
System.out.println("ошибка I/О потока");
e.printStackTrace();
} catch (InterruptedException e) {
System.out.println(
"ошибка потока выполнения");
e.printStackTrace();
}
}
}
