import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
public class UnPackJar {
private File destFile;
// размер буфера для распаковки
public final int BUFFER = 2_048;
public void unpack(String destinationDirectory, String nameJar) {
		
File sourceJarFile = new File(nameJar);
try (JarFile jFile = new JarFile(sourceJarFile)) {
File unzipDir = new File(destinationDirectory);
// открытие jar-архива для распаковки
Enumeration<JarEntry>
			
jarFileEntries = jFile.entries();
while (jarFileEntries.hasMoreElements()) {
// извлечение текущей записи из архива
JarEntry entry = jarFileEntries.nextElement();
String entryname = entry.getName();
System.out.println("Extracting: " + entry);
destFile = new File(unzipDir, entryname);
// определение каталога
File destinationParent = destFile.getParentFile();
// создание структуры каталогов
destinationParent.mkdirs();
// распаковывание записи, если она не каталог
if (!entry.isDirectory()) {
writeFile(jFile, entry);
}
}

} catch (IOException e) {

}
}
private void writeFile(JarFile jFile, JarEntry entry) {
int currentByte;
byte data[] = new byte[BUFFER];
try (BufferedInputStream is = new BufferedInputStream(jFile.getInputStream(entry));
FileOutputStream fos = new FileOutputStream(destFile);
BufferedOutputStream dest = new BufferedOutputStream(fos,BUFFER)) {
// запись файла на диск
while ((currentByte = is.read(data, 0, BUFFER)) > 0) {
dest.write(data, 0, currentByte);
}
dest.flush();
} catch (IOException e) {
e.printStackTrace();
}
}
}
