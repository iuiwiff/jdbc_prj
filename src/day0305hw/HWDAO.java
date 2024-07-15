package day0305hw;

public class HWDAO {
	
	private HWDAO hwDAO;

	private HWDAO() {
		
	}//생성자
	
	private HWDAO getInstance() {
		if(hwDAO == null) {
			hwDAO = new HWDAO();
		}//end if
		return hwDAO;
	}//getInstance
	
	
}//class
