package day0304;

/**
 * Singleton pattern이 도입된 클래스
 */
public class Singleton {
	private static Singleton single; //객체를 유지하기 위해서 선언한 클래스 변수

	//1. 클래스외부에서 객체생성을 막기 위해 생성자를 private으로 설정
	private Singleton() {
		
	}//생성자
	
	//2. 클래스외부에서 객체를 얻어갈 수 있도록 method 작성
	public static Singleton getInstance() { //static은 첫 번째로 실행됨 > 인스턴스 있을지 없을지 모름 > 같은 수준으로 되도록 클래스 변수를 static으로 만들어 참조 가능하도록 함
		//객체를 하나로 유지하면서 생성하는 코드 작성.
		if(single == null) {
			single = new Singleton();
		}//end if
		return single;
	}//getInstance
	
	
	
}//class
