
class atmowsitch{

 public static void getPlanetAtmosphere(int seqNumberFromSun) {
    switch (seqNumberFromSun) {
        case 1: System.out.println("Немає атмосфери");
            break;
        case 2:
        case 4: System.out.println("Вуглекислий газ");
            break;
        case 3: System.out.println("Вуглекислий газ,Азот,Кисень");
            break;
        case 5:
        case 6: System.out.println("Водень"+"Гелій");
            break;
        case 7:
        case 8: System.out.println("Метан,Водень Гелий");
            break;
        default:   break;
    }
}

public static void main(String[] a){
    getPlanetAtmosphere(5);

}

}
