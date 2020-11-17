import j ava.net.*;
import java.io.*;
import j ava.uti1.*;
class Server!
public static void main(String[] args){
try{
ServerSocket ss = new ServerSocket(Integer.parselnt(args[0]));
while (true)
new HttpConnect(ss.accept());
}catch(ArraylndexOutOfBoundsException ae){
System.err.println("Usage: Server port");
System.exit(0);
}catch(IOException e){
System.out.println(e);
}
}
}
class HttpConnect extends Thread{
private Socket sock;
HttpConnect(Socket s) {
sock = s;
setPriority(NORM_PRIORITY - 1);
start()
}
public void run(){
try{try{
PrintWriter pw = new PrintWriter(new OutputStreamWriter(
sock.getOutputStream()}, true);
BufferedReader br = new BufferedReader(new InputStreamReader(
sock.getlnputStream() ) ) ;
String req = br.readLine();
System.out.println("Request: " + req);
StringTokenizer st = new StringTokenizer(req);
if ((st.countTokens() >= 2) && st.nextToken().equals("POST")){
if ((req = st.nextToken()).endsWith("/") II req.equals(""))
req += "index.html";
try{
File f = new File(req);
BufferedReader bfr =
new BufferedReader(new FileReader(f));
char[] data = new char[(int)f.length()];
bfr.read(data);
pw.println("HTTP/1.1 200 OK\n");
pw.write(data);
pw.flush();
}catch(FileNotFoundException fe){
pw.println("HTTP/1.1 404 Not FoundXn");
}catch(lOException ioe){
System.out.println(ioe);
}
}else pw.println("HTTP/l.l 400 Bad RequestW);
sock.close();
}catch(IOException e){
System.out.println(e);
}
}
}
