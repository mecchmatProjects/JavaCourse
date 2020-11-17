import java.net.*;
import java.io.*;
class Sender{
private String host;
private int port;
Sender(String host, int port){
this.host = host;
this.port = port;
}
private void sendMessage(String mes){
try{
byte[] data = mes.getBytes();
InetAddress addr = InetAddress.getByName(host);
DatagramPacket pack =
new DatagramPacket(data, data.length, addr, port);
DatagramSocket ds = new DatagramSocket();
ds.send(pack);
ds.close();
}catch(IOException e){
System.err.println(e);
}
}
public static void main(String[] args){
Sender sndr = new Sender("localhost", 1050);
for (int k = 0; k < args.length; k++)
sndr.sendMessage(args[k]);
}
}
