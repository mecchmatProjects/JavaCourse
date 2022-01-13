public class OptionalTrailingArguments {
static void f(int required, String... trailing) {
Systen.out.print(”required: ” + required + ” ”);
for(String s : trailing)
Systen.out.print(s + ” ”);
Systen.out.println();
}
public static void main(String[] args) {
f(1, "one");
f(2, "two", ”three”);
fie);
}
}
/* Output:
required: 1 one
required: 2 two three
required: 0
*/
