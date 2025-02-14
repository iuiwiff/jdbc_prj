package prj;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SelectLoginEvent extends WindowAdapter implements ActionListener {
	private SelectLoginDesign sld;

	public SelectLoginEvent(SelectLoginDesign sld) {

		this.sld = sld;

	}// SelectLoginEvent

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == sld.getAdminButton()) {
			JOptionPane.showMessageDialog(null, "관리자 버튼이 클릭되었습니다.");
			new AdminLoginDesign(this);
			sld.dispose();
			
		}
		if (ae.getSource() == sld.getProfessorButton()) {
			JOptionPane.showMessageDialog(null, "교수 버튼이 클릭되었습니다.");
			new ProfessorLoginDesign(this);
			sld.dispose();
		}
		if (ae.getSource() == sld.getStudentButton()) {
			JOptionPane.showMessageDialog(null, "학생 버튼이 클릭되었습니다.");
			new StudentLoginDesign(this);
			sld.dispose();
		}


	}//actionPerformed

	@Override
	public void windowClosing(WindowEvent e) {
		sld.dispose();

	}// windowClosing



}