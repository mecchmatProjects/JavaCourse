public class RefString {
	public static void changeStr(String s) {
		s = s.concat(" Certified"); // создается новая строка
		// или s.concat(" Certified");
		// или s += " Certified";
        }
	public static void main(String[ ] args) {
	        String str = new String("Java");
		changeStr(str);
		System.out.print(str);
	}
}
