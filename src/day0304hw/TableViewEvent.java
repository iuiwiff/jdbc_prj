package day0304hw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TableViewEvent extends WindowAdapter implements ActionListener {

	private TableView tv;
	
	public TableViewEvent(TableView tv) {
		this.tv = tv;
	}//생성자

	@Override
	public void actionPerformed(ActionEvent ae) {
		
	}//actionPerformed

	@Override
	public void windowClosing(WindowEvent we) {
		tv.dispose();
	}//windowClosing
	
	
}//class
