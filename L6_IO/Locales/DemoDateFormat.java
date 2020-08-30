package tr;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class DemoDateFormat {
	  public static void main(String[] args) {
	   DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.US);
	   Date d = null; 
	   String str = "April 9, 2012";
	      try {
	    d = df.parse(str);
	    System.out.println(d); 
	      } catch (ParseException e) {
	    System.err.print("Error position: " + e.getErrorOffset());
	      }
	      df = DateFormat.getDateInstance(DateFormat.LONG, new Locale("ru","RU"));
	      System.out.println(df.format(d));
	      df = DateFormat.getDateInstance(DateFormat.FULL,Locale.GERMAN);
	      System.out.println(df.format(d));
	      
	      Date d2 = new Date(); 
	      Locale[ ] locales = DateFormat.getAvailableLocales();
	        for (Locale loc : locales) {
	         DateFormat df2 = DateFormat.getDateInstance(DateFormat.FULL, loc);
	         System.out.println(loc.toString() + "---> " + df2.format(d2));
	        }
	      
	}
}