import java.net.*;
public class InetLogic {
 public static void main(String[] args) {
 InetAddress myIP = null;
 InetAddress knuIP = null;
 try {
  myIP = InetAddress.getLocalHost();// вывод IP-адреса локального компьютера
  System.out.println("Мой IP -> "+ myIP.getHostAddress());
  knuIP = InetAddress.getByName("www.matfiz.univ.kiev.ua");// 
  System.out.println("KNU -> "+ knuIP.getHostAddress());
  }
  catch (UnknownHostException e) {
   // если не удается найти IP
  e.printStackTrace();
  }
 }
}
