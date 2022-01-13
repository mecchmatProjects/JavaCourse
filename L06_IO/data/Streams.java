import java.io.*;

class Streams{

    final static String dataFile = "invoicedata";
    static final double[] prices = { 19.99, 9.99, 15.99, 3.99, 4.99 };
    static final int[] units = { 12, 8, 13, 29, 50 };

   public static void input() throws IOException {

   final String[] descs = {
    "Java T-shirt",
    "Java Mug",
    "Duke Juggling Dolls",
    "Java Pin",
    "Java Key Chain"
};

    DataOutputStream  out = new DataOutputStream(new BufferedOutputStream(
              new FileOutputStream(dataFile)));
   // DataStreams writes out the records and closes the output stream.
for (int i = 0; i < prices.length; i ++) {
    out.writeDouble(prices[i]);
    out.writeInt(units[i]);
    out.writeUTF(descs[i]);
}
  out.close();
}

public static void output() throws IOException {

 DataInputStream in = new DataInputStream(new
            BufferedInputStream(new FileInputStream(dataFile)));

double price;
int unit;
String desc;
double total = 0.0;

try {
    while (true) {
        price = in.readDouble();
        unit = in.readInt();
        desc = in.readUTF();
        System.out.format("You ordered %d" + " units of %s at $%.2f%n",
            unit, desc, price);
        total += unit * price;
    }
} catch (EOFException e) {
}

 in.close();
}

public static void main(String[] args){
  try{
  input();
 output();
 } catch (IOException e){
 }

}

}
