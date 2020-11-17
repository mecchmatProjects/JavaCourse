import java.io.*;
public class SynchroThreads {
public static void main(String[] args) {
try {
Synchro s = new Synchro("c:\\temp\\data.txt");
MyThread t1 = new MyThread("First", s);
MyThread t2 = new MyThread("Second", s);
t1.start();
t2.start();
t1.join();
t2.join();
s.close();
} catch (IOException e) {
System.err.print("ошибка файла");
e.printStackTrace();
} catch (InterruptedException e) {
System.err.print("ошибка потока");
e.printStackTrace();
}
}
}
