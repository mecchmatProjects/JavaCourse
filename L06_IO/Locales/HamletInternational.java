package class1;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
public class HamletInternational {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 for (int j = 0; j < 3; j++) {
			   System.out.println("1 Ч английский /n 2 Ч белорусский \n любой Ч русский ");
			   char i = 0;
			   try {
			    i = (char) System.in.read();
			    System.out.println(i);
			   } catch (IOException e) {
				    e.printStackTrace();
				   }
				   String country = "";
				   String language = "";
				   switch (i) {
				       case '1':
				    country = "US";
				    language = "EN";
				    break;
				       case '2':
				    country = "Ukraine";
				    language = "UA";
				    break;
				   }
				   Locale current = new Locale(language, country);
				   ResourceBundle rb = ResourceBundle.getBundle("property.text", current);
				    String s1 = rb.getString("str1");
				    System.out.println(s1);
				    String s2 = rb.getString("str2");
				    System.out.println(s2);
				       }
	
	}

}
