import java.io.*;
public class DemoReader {
	
public static void main(String[ ] args) {
		
BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("data\\res.txt"));
			
String tmp = "";
			while ((tmp = br.readLine()) != null) {	
                             // пробел использовать как разделитель
				String[] s = tmp.split("\\s");
				// вывод полученных строк
				for (String res : s) {
					System.out.println(res);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
