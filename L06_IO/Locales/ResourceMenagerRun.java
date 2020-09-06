package class1;
import java.util.Locale;

public class ResourceMenagerRun {

	public static void main(String[ ] args) {
	   ResourceManager manager = ResourceManager.INSTANCE;
	   System.out.println(manager.getString("str1"));
	   manager.changeResource(new Locale("ua","UA"));
	   System.out.println(manager.getString("str1"));
	  }
}

