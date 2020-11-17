mport java.net.*;
import java.io.*;
class PostURL{
public static void main(String[] args){
String req = "This text is posting to URL";
try{
// Указываем URL нужной CGI-программы
URL url = new URL(" http://www.bhv.ru/cgi-bin/some.pl ");
// Создаем объект uc
URLConnection uc = url.openConnection();
// Собираемся отправлять
uc.setDoOutput(true);
// и получать сообщения
uc.setDoInput(true);
// без кэширования
uc.setUseCaches(false);
// Задаем тип
uc.setRequestProperty("content-type",
"application/octet-stream");
// и длину сообщения
uc.setRequestProperty("content-length", "" + req.length());
// Устанавливаем соединение
uc.connect();
// Открываем выходной поток
DataOutputStream dos = new DataOutputStream( uc.getOutputStreamO);
// и выводим в него сообщение, посылая его на адрес
URL dos.writeBytes(req);
// Закрываем выходной поток
dos.close();
// Открываем входной поток для ответа сервера
BufferedReader br = new BufferedReader(new InputStreamReader(
uc.getlnputStream() )) ;
String res = null;
// Читаем ответ сервера и выводим его на консоль
while ((res = br.readLine()) != null)
System.out.println(res);
br.close () ;
}catch(MalformedURLException me){
System.err.println(me);
}catch(UnknownHostException he){
System.err.println(he);
}catch(UnknownServiceException se){
System.err.println(se);
}catch(IOException ioe){
System.err.println(ioe);
}
}
}
