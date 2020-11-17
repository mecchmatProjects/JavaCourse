mport java.net.*;
import java.io.*;
import java.util.*;
class Client{
public static void main(String[] args){
if (args.length != 3){
System.err.println("Usage: Client host port file");
System.exit(0) ;
}
String host = args[0];
int port = Integer.parselnt(args[1]);
String file = args[2];
try{
Socket sock = new Socket(host, port);
PrintWriter pw = new PrintWriter(new OutputStreamWriter(
sock.getOutputStreamf)), true);
pw.println("POST " + file + " HTTP/1.l\n");
BufferedReader br = new BufferedReader(new InputStreamReader(
sock.getlnputStream() ) ) ;
String line = null;
line = br.readLine();
StringTokenizer st = new StringTokenizer(line);
String code = null;
if ((st.countTokens() >= 2) && st.nextToken().equals("POST")){
if ((code = st.nextToken()) != "200") {
System.err.println("File not found, code = " + code);
System.exit (0);
}
}while ((line = br.readLine()) != null)
System.out.println{line);
sock.close();
}catch(Exception e){
System.err.println(e);
}
}
}
