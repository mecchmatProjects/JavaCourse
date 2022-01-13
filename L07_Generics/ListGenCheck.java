

class A<T extends List<Number>>{}

class B{
  public static <T> T  getFirstValue(T[] array){return array[0];} 
} 

class ListGenCheck{

	public static void main(String[] args){
 ///Какие объекты можно создать?
	 A< List < Number >> a;
A< LinkedList < Long >> a;
A< List < Long >> a;
A< LinkedList < Object >> a;
A< ArrayList < Number >> a; 


 Long[] a = {1L, 2L}; long b = B. getFirstValue (a);
int[] a = {1}; int b = B. getFirstValue (a);
Object[] a = new Object[10]; Object b = B. getFirstValue(a);
Set< Integer> a = new HashSet<>(); Integer b = B. getFirstValue(a);
List< Integer> a = new ArrayList<>(); Integer b = B. getFirstValue(a); 
}

}
