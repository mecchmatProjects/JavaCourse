import java.io.InvalidObjectException;
public class RunnerSerialization {
	
public static void main(String[] args) {
		// создание и запись объекта
		Student ob = new Student("MMF", "Goncharenko", 1, "G017s9");
		System.out.println(ob);
		
                String file = "data//demo.data";
		
                Serializator sz = new Serializator();
		boolean b = sz.serialization(ob, file);
		Student.faculty = "GEO"; // изменение значения static-поля
		// чтение и вывод объекта
		Student res = null;
		try {
			res = sz.deserialization(file);
		} catch (InvalidObjectException e) {
			// обработка
			e.printStackTrace();
		}
		System.out.println(res);
	}
}
