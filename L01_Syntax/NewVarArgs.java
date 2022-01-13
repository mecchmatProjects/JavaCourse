public class NewVarArgs {
static void printArray(Object... args) {
for(0bject obj : args)
System.out.print(obj + ” ”);
System.out.println();
}
public static void main(String[] args) {
// Can take individual elements:
printArray(47, (float) 3.14, 11.11);
printArray(47, 3.14F, 11.11);
printArray("one", ”two”, ”three");
printArray(new A(), new A(), new A());
// Or an array:
printArray((Object[])new Integer[]{ 1, 2, 3, 4 });
printArray(); // Empty list is OK
}
}
/* Output:
47 3.14 11.11
47 3.14 11.11
one two three
A@15db9742 A@6d06d69c A@7852e922
1 2 3 4
*/
