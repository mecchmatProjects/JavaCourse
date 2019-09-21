package classes;

class ClassA {

	int i, j;
	public void setIJ(int i, int j){
		this.i=i;
		this.j=j;
	}
	void show(){
		System.out.println("I="+i+" J="+j);
	}
}

class ClassB extends ClassA{
	int k;
	void showK (){
		System.out.println("K="+k);
	}
	
	int sum(){
		return i+j+k;
	}
} 

class ClassUseInheritance{
	
	public static void main(String[] args){
		ClassA A = new ClassA();
		ClassB B = new ClassB();
		A.setIJ(10, 20);
		A.show();
		
		B.setIJ(40, 50);
		B.k = 60;
		B.show(); B.showK();
		System.out.println(B.sum());
		
		
	}
	
}


