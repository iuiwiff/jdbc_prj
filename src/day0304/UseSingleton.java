package day0304;

public class UseSingleton {

	public static void main(String[] args) {
		
//		Singleton single = new Singleton();
		Singleton single = Singleton.getInstance();
		Singleton single2 = Singleton.getInstance();
		Singleton single3 = Singleton.getInstance();
		
		System.out.println(single);
		System.out.println(single2);
		System.out.println(single3);
		//객체는 다르지만 모두 동일한 주소가 나옴
		
	}//main

}//class
