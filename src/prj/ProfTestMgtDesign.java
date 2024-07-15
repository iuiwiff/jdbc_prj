package prj;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ProfTestMgtDesign extends JFrame {

	private JButton jbtnSubmit, jbtnMdfy;
	private JLabel jlLogin, jlPhoto, jlBackground, jlBanner1;
	private JTextField jtfProfNum, jtfEmail;
	private JPasswordField jpfPW;
	private JRadioButton jrbActivate, jrbDeactivate;

	public ProfTestMgtDesign() {
		super("교수모드_시험관리");

		String imagePath = "src/prj/images/";

		// 라벨 생성
		jlLogin = new JLabel("교수 로그인 중");
		
		// 라디오 버튼을 그룹화 하기위한 객체 생성
		ButtonGroup jrbgroup = new ButtonGroup();
		
		// 라디오 컴포넌트 생성
		jrbActivate = new JRadioButton("활성화");
		jrbDeactivate = new JRadioButton("비활성화");
		
		// 그룹에 라디오 버튼 삽입
		jrbgroup.add(jrbActivate);
		jrbgroup.add(jrbDeactivate);
		
		// 특정 라디오 버튼 눌러져있도록
		jrbDeactivate.setSelected(true);

		this.add(jrbActivate);
	 	this.add(jrbDeactivate);
		
		// 이미지 생성
		ImageIcon backImage = new ImageIcon(imagePath + "background.png");

		ImageIcon buttonImage1 = new ImageIcon(imagePath + "submitbutton.png");
		ImageIcon buttonImage2 = new ImageIcon(imagePath + "mdfybutton.png");

		ImageIcon bannerImage1 = new ImageIcon(imagePath + "testMgtBanner.png");

		jlBackground = new JLabel(backImage);
		jlBackground.setSize(984, 620);

		jlBanner1 = new JLabel(bannerImage1);
		
		jbtnSubmit = new JButton(buttonImage1);
		jbtnMdfy = new JButton(buttonImage2);

		// 텍스트필드 생성
		jtfProfNum = new JTextField(10);
		jtfEmail = new JTextField(10);

		// 패스워드필드 생성
		jpfPW = new JPasswordField(10);

		// 버튼 생성

		// 프레임 크기
		setSize(1000, 650);

		// 프레임 크기 변경 불가
		setResizable(false);

		// 프레임 화면 중앙 표시
		setLocationRelativeTo(null);

		// 수동 레이아웃
		setLayout(null);

		// 라벨 크기와 위치 설정
		jlBanner1.setBounds(10, 76, 967, 45);

		// 텍스트필드 크기와 위치 설정
		
		// 버튼 크기와 위치 설정
		jbtnSubmit.setBounds(500, 490, 90, 50);
		jbtnMdfy.setBounds(630, 490, 90, 50);
		
		// 라디오 버튼 크기와 위치 설정
		jrbActivate.setBounds(150, 490, 90, 50);
		jrbDeactivate.setBounds(300, 490, 90, 50);
		
		// 폰트 설정
		Font loginFont = new Font("나눔스퀘어라운드 ExtraBold", Font.BOLD, 15);
		jlLogin.setFont(loginFont);
		jlLogin.setForeground(Color.GREEN);

		add(jlBanner1);
		add(jbtnSubmit);
		add(jbtnMdfy);
		add(jrbActivate);
		add(jrbDeactivate);
		add(jlBackground);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}// 생성자

	public static void main(String[] args) {
		new ProfTestMgtDesign();
	}// main

}// class
