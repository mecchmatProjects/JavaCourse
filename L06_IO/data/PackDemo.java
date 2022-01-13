import java.io.FileNotFoundException;
public class PackDemo {
public static void main(String[] args) {
String dirName = "."; //"путь_к_директории";
PackJar pj = new PackJar("example.jar");
try {
pj.pack(dirName);
} catch (FileNotFoundException e) {
e.printStackTrace();
}
}
}
