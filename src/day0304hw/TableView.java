package day0304hw;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class TableView extends JFrame{

	public TableView() {
		super("테이블 조회");
		
		//1. Model객체 생성
		DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<String>();
		
		//2. Model객체와 has a 관계 View객체 생성
		JComboBox<String> jcb = new JComboBox<String>(dcbm);
		
		//데이터 추가
		//dcbm.addElement("고한별");
		
		
		JPanel jp = new JPanel();
		jp.setBorder(new TitledBorder("테이블을 선택하세요"));
		jp.add(jcb);
		
		add("North", jp);
		
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		
	}//main
	
}//class
