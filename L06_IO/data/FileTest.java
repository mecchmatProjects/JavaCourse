import java.io.File;
import java.util.Date;
import java.io.IOException;

public class FileTest {
public static void main(String[] args) {
// c объектом типа File ассоциируется файл на диске FileTest2.java
File fp = new File("FileTest2.java");
if(fp.exists()) {
System.out.println(fp.getName() + " существует");
if(fp.isFile()) { // если объект - дисковый файл
	
System.out.println("Путь к файлу:\t" + fp.getPath());
System.out.println("Абсолютный путь:\t" + fp.getAbsolutePath());
System.out.println("Размер файла:\t" + fp.length());
System.out.println("Последняя модификация :\t"+ new Date(fp.lastModified()));
System.out.println("Файл доступен для чтения:\t" + fp.canRead());
System.out.println("Файл доступен для записи:\t" + fp.canWrite());
System.out.println("Файл удален:\t"	+ fp.delete());
}
	} else
	
System.out.println("файл " + fp.getName() + " не существует");
try {if(fp.createNewFile()) {
System.out.println("Файл " + fp.getName() + " создан");
}
} catch(IOException e) {
	
System.err.println(e);
}
// в объект типа File помещается каталог\директория
// в корне проекта должен быть создан каталог com.learn с несколькими файлами
File dir = new File("com" + File.separator + "learn");
if (dir.exists() && dir.isDirectory()) { /*если объект является каталогом и если этот		
каталог существует */
	
System.out.println("каталог " + dir.getName() + " существует");
}
	
File[] files = dir.listFiles();
	
for(int i = 0; i < files.length; i++) {
	
Date date = new Date(files[i].lastModified());
	
System.out.print("\n"+files[i].getPath()+" \t| "+files[i].length()+"\t|"+date);
	
// использовать toLocaleString() или toGMTString()
	
}
	
// метод listRoots() возвращает доступные корневые каталоги
	
 File[] roots = File.listRoots();
 for(File root: roots){
	System.out.printf("\n%s %,d из %,d свободно.", root.getPath(), root.getUsableSpace(),			
     root.getTotalSpace());
  }
 }
}
