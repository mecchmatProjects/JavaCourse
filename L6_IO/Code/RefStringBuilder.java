public class RefStringBuilder {
	public static void changeStr(StringBuilder s) {
		s.append(" Certified");
	}
	public static void main(String[ ] args) {
		
                StringBuilder str = new StringBuilder("Oracle");
		changeStr(str);
		System.out.println(str);
             
                StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer(48);
		sb1.append("Java");
		sb2.append("Java");
		System.out.print(sb1.equals(sb2));
		System.out.print(sb1.hashCode() == sb2.hashCode()); 

                System.out.println(sb1.toString().contentEquals(sb2));

	}
}
