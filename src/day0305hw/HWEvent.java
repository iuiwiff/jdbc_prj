package day0305hw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HWEvent extends WindowAdapter implements ActionListener {

	private HWView hwv;
	
	public HWEvent(HWView hwv) {
		this.hwv = hwv;
	}//생성자
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		/////////////////추가 버튼 클릭 시////////////////
		if(ae.getSource() == hwv.getJbtnAdd()) {
			int num = Integer.parseInt(hwv.getJtfNum().getText());
			
		}//end if
		
		////////////////변경 버튼 클릭 시/////////////////
		if(ae.getSource() == hwv.getJbtnAlter()) {
			
		}
		
		///////////////삭제 버튼 클릭 시//////////////////
		if(ae.getSource() == hwv.getJbtnDelete()) {
			
		}
		
		//////////////종료 버튼 클릭 시//////////////////
		if(ae.getSource() == hwv.getJbtnExit()) {
			
		}
		
	}//actionPerformed

	@Override
	public void windowClosing(WindowEvent we) {
		hwv.dispose();
	}

	
	
}
