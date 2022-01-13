import java.io.*;
public class DemoWriter {
	
public static void main(String[] args) {
		
File f = new File("data" + File.separator +"res.txt");
		double[ ] v = { 1.10, 1.2, 1.401, 5.01, 6.017, 7, 8 };
		
FileWriter fw = null;
		
BufferedWriter bw = null;
		
PrintWriter pw = null;
		try {
			fw = new FileWriter(f, true);
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);
			for (double version : v) {
                            pw.printf("Java %.2g%n", version);// запись прямо в файл
			}
		} catch (IOException e) {
			System.err.println("ошибка открытия потока " + e);
		} finally {
			if (pw != null) {				
                               // try { // закрывать нужно только внешний поток
					pw.close();
				//} catch (IOException e) {
				//	e.printStackTrace();
				//}
			}
		}
	}
}
