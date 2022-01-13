import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.FileNotFoundException;
import java.io.NotSerializableException;

public class Serializator {
	
public boolean serialization(Student s, String fileName) {
		boolean flag = false;
		
File f = new File(fileName);
		
ObjectOutputStream ostream = null;
		try {
			FileOutputStream fos = new FileOutputStream(f);
			if (fos != null) {
				ostream = new ObjectOutputStream(fos);
				ostream.writeObject(s); // сериализация
				flag = true;
			}
		} catch (FileNotFoundException e) {
			System.err.println("Файл не может быть создан: "+ e);
		} catch (NotSerializableException e) {
			System.err.println("Класс не поддерживает сериализацию: " + e);
		} catch (IOException e) {
			System.err.println(e);
		} finally {
			try {
				if (ostream != null) {
					ostream.close();
				}
			} catch (IOException e) {
				System.err.println("ошибка закрытия потока");
			}
		}
		return flag;
	}
	
public Student deserialization(String fileName) throws InvalidObjectException {
		
File fr = new File(fileName);
		
ObjectInputStream istream = null;
		try {
			FileInputStream fis = new FileInputStream(fr);
			istream = new ObjectInputStream(fis);
			// десериализация
			
Student st = (Student) istream.readObject();
			return st;
		} catch (ClassNotFoundException ce) {	System.err.println("Класс не существует: " + ce);
		} catch (FileNotFoundException e) {
			System.err.println("Файл для десериализации не существует: "+ e);
		} catch (InvalidClassException ioe) {
			System.err.println("Несовпадение версий классов: " + ioe);
		} catch (IOException ioe) {
			System.err.println("Общая I/O ошибка: " + ioe);
		} finally {
			try {
				if (istream != null) {
					istream.close();
				}
			} catch (IOException e) {
				System.err.println("ошибка закрытия потока ");
			}
		}
		throw new InvalidObjectException("объект не восстановлен");
	
}
}
