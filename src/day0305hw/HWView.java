package day0305hw;

import java.awt.Image;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

//테이블, 시퀀스

public class HWView extends JFrame{

	private JLabel jlNum, jlName, jlImage, jlShowImage, jlAge, jlInputDate;
	private JTextField jtfNum, jtfName, jtfAge, jtfInputdate;
	private JButton jbtnAdd, jbtnAlter, jbtnDelete, jbtnExit;
	private JList<String> jl;
	private JComboBox<String> jcbImage;
	private JScrollPane jsp;
	
	public HWView() {
		super("DAY0305HW");
		
		jlNum = new JLabel("번호");
		jlName = new JLabel("이름");
		jlImage = new JLabel("이미지");
		jlAge = new JLabel("나이");
		jlInputDate = new JLabel("입력일");
		
		ImageIcon ii = new ImageIcon("E:/E/dev/workspace/java_se/src/day0125/images/img1.png");
		Image img = ii.getImage();
		Image newImg = img.getScaledInstance(190, 170, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(newImg);
		jlShowImage = new JLabel(scaledIcon);
		
		jtfNum = new JTextField(2);
		jtfName = new JTextField(4);
		jtfAge = new JTextField(3);
		jtfInputdate = new JTextField(10);
		
		jbtnAdd = new JButton("추가");
		jbtnAlter = new JButton("변경");
		jbtnDelete = new JButton("삭제");
		jbtnExit = new JButton("종료");
		
		//Model객체 생성
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<String>();
				
		//Model객체와 has a 관계 View 생성
		jl = new JList<String>(dlm);
		jcbImage = new JComboBox<String>(dcbm);
				
		//데이터 추가
		dcbm.addElement("img1.png");
		dcbm.addElement("img2.png");
		dcbm.addElement("img3.png");
		dcbm.addElement("img4.png");
		
		jsp = new JScrollPane(jl);
		
		setLayout(null);
		setBounds(400, 100, 700, 700);
		jlNum.setBounds(40, 30, 110, 30);
		jlName.setBounds(40, 70, 110, 30);
		jlImage.setBounds(40, 110, 110, 30);
		jlAge.setBounds(40, 150, 110, 30);
		jlInputDate.setBounds(40, 190, 110, 30);
		
		jtfNum.setBounds(100, 30, 130, 30);
		jtfName.setBounds(100, 70, 130, 30);
		jcbImage.setBounds(100, 110, 130, 30);
		jtfAge.setBounds(100, 150, 130, 30);
		jtfInputdate.setBounds(100, 190, 130, 30);
		
		jbtnAdd.setBounds(210, 280, 70, 40);
		jbtnAlter.setBounds(290, 280, 70, 40);
		jbtnDelete.setBounds(370, 280, 70, 40);
		jbtnExit.setBounds(450, 280, 70, 40);
		
		jsp.setBounds(245, 30, 250, 190);
		jlShowImage.setBounds(510, 30, 190, 150);
		
		add(jlNum);
		add(jlName);
		add(jlImage);
		add(jlAge);
		add(jlInputDate);
		
		add(jtfNum);
		add(jtfName);
		add(jcbImage);
		add(jtfAge);
		add(jtfInputdate);
		
		add(jbtnAdd);
		add(jbtnAlter);
		add(jbtnDelete);
		add(jbtnExit);
		
		add(jsp);
		add(jlShowImage);
		
		setSize(750, 400);
		setVisible(true);
		setResizable(false);
		
		HWEvent hwe = new HWEvent(this);
		
		addWindowListener(hwe);
		jbtnAdd.addActionListener(hwe);
		jbtnAlter.addActionListener(hwe);
		jbtnDelete.addActionListener(hwe);
		jbtnExit.addActionListener(hwe);
		
		
	}//생성자
	
	
	public JButton getJbtnAdd() {
		return jbtnAdd;
	}


	public void setJbtnAdd(JButton jbtnAdd) {
		this.jbtnAdd = jbtnAdd;
	}


	public JButton getJbtnAlter() {
		return jbtnAlter;
	}


	public void setJbtnAlter(JButton jbtnAlter) {
		this.jbtnAlter = jbtnAlter;
	}


	public JButton getJbtnDelete() {
		return jbtnDelete;
	}

	
	public void setJbtnDelete(JButton jbtnDelete) {
		this.jbtnDelete = jbtnDelete;
	}


	public JButton getJbtnExit() {
		return jbtnExit;
	}

	
	public void setJbtnExit(JButton jbtnExit) {
		this.jbtnExit = jbtnExit;
	}


	public static void main(String[] args) {
		new HWView();
	}


	public JLabel getJlShowImage() {
		return jlShowImage;
	}


	public void setJlShowImage(JLabel jlShowImage) {
		this.jlShowImage = jlShowImage;
	}


	public JTextField getJtfNum() {
		return jtfNum;
	}


	public void setJtfNum(JTextField jtfNum) {
		this.jtfNum = jtfNum;
	}


	public JTextField getJtfName() {
		return jtfName;
	}


	public void setJtfName(JTextField jtfName) {
		this.jtfName = jtfName;
	}


	public JTextField getJtfAge() {
		return jtfAge;
	}


	public void setJtfAge(JTextField jtfAge) {
		this.jtfAge = jtfAge;
	}


	public JTextField getJtfInputdate() {
		return jtfInputdate;
	}


	public void setJtfInputdate(JTextField jtfInputdate) {
		this.jtfInputdate = jtfInputdate;
	}
	
	
	
	
}//class
