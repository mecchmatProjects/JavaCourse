public class DemoStringBuffer {
	public static void main(String[] args) {
                StringBuffer sb = new StringBuffer();
		System.out.println("длина —> " + sb.length());
		System.out.println("размер —>" + sb.capacity());
		// sb = "Java"; // ошибка, только для класса String
		sb.append("Java");
		System.out.println("строка —> " + sb);
		System.out.println("длина —> " + sb.length());
		System.out.println("размер —> " + sb.capacity());
		sb.append("Internationalization");
		System.out.println("строка —> " + sb);
		System.out.println("длина —> " + sb.length());
		System.out.println("размер —> " + sb.capacity());
		System.out.println("реверс —> " + sb.reverse());
	}
}
