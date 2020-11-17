import java.net.*;
import java.io.*;
class SimpleURL{
public static void main(String[] args){
try{
 URL bhv = new URL(" http://www.matfiz.univ.kiev.ua/");
BufferedReader br = new BufferedReader(
new InputStreamReader(bhv.openStream()));
String line;
while ((line = br.readLine()) != null)
System.out.println(line);
br.close();
}catch(MalformedURLException me){
System.err.println("Unknown host: " + me);
System.exit(0);
}catch(IOException ioe){
System.err.println("Input error: " + ioe);
}
}
}
