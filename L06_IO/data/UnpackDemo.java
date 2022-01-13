public class UnpackDemo {
   public static void main(String[] args) {
	// расположение и имя архива
       String nameJar = "example.jar";
	// куда файлы будут распакованы
	String destinationPath = "data/";
	new UnPackJar().unpack(destinationPath, nameJar);
	}
}
