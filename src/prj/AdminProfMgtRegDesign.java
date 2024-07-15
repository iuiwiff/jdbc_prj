package prj;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AdminProfMgtRegDesign extends JFrame {

	private JButton jbtnReg, jbtnCancel;
	private JLabel jlProfNum, jlName, jlPW, jlEmail, jlDept, jlEssential, jlLogin, jlPhoto, jlBackground, jlBanner1,
			jlBanner2;
	private JTextField jtfProfNum, jtfName, jtfEmail;
	private JPasswordField jpfPW;
	private JComboBox<String> jcbDept;

	public AdminProfMgtRegDesign() {
		super("관리자모드_교수관리_수정");

		String imagePath = "src/prj/images/";

		// 라벨 생성
		jlProfNum = new JLabel("교번");
		jlName = new JLabel("이름");
		jlPW = new JLabel("PW");
		jlEmail = new JLabel("이메일");
		jlDept = new JLabel("소속 학과");
		jlEssential = new JLabel("*교번, 이름, PW는 필수입력 사항");
		jlLogin = new JLabel("관리자 로그인 중");

		// Model객체 생성
		DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<String>();
		
		// Model객체와 has a 관계 View 생성
		jcbDept = new JComboBox<String>(dcbm);
		
		// 데이터 추가
		//dcbm.addElement();

		// 이미지 생성
		ImageIcon backImage = new ImageIcon(imagePath + "background.png");
		ImageIcon photo = new ImageIcon(imagePath + "photo.png");

		ImageIcon buttonImage1 = new ImageIcon(imagePath + "regbutton.png");
		ImageIcon buttonImage2 = new ImageIcon(imagePath + "cancelbutton.png");

		ImageIcon bannerImage1 = new ImageIcon(imagePath + "profmgtbanner.png");
		ImageIcon bannerImage2 = new ImageIcon(imagePath + "regbanner.png");

		jlBackground = new JLabel(backImage);
		jlPhoto = new JLabel(photo);
		jlBackground.setSize(984, 620);

		jlBanner1 = new JLabel(bannerImage1);
		jlBanner2 = new JLabel(bannerImage2);

		// 텍스트필드 생성
		jtfProfNum = new JTextField(10);
		jtfName = new JTextField(10);
		jtfEmail = new JTextField(3);

		// 패스워드필드 생성
		jpfPW = new JPasswordField(10);

		// 버튼 생성
		jbtnReg = new JButton(buttonImage1);
		jbtnCancel = new JButton(buttonImage2);

		// 프레임 크기
		setSize(1000, 650);

		// 프레임 크기 변경 불가
		setResizable(false);

		// 프레임 화면 중앙 표시
		setLocationRelativeTo(null);

		// 수동 레이아웃
		setLayout(null);

		// 라벨 크기와 위치 설정
		jlPhoto.setBounds(215, 205, 198, 233);
		jlProfNum.setBounds(465, 210, 50, 30);
		jlName.setBounds(465, 260, 50, 30);
		jlPW.setBounds(465, 310, 50, 30);
		jlEmail.setBounds(465, 360, 100, 30);
		jlDept.setBounds(465, 410, 100, 30);
		jlEssential.setBounds(642, 445, 150, 15);
		jlLogin.setBounds(865, 25, 130, 30);
		jlBanner1.setBounds(10, 76, 967, 45);
		jlBanner2.setBounds(10, 121, 967, 45);

		// 텍스트필드 크기와 위치 설정
		jtfProfNum.setBounds(560, 210, 220, 30);
		jtfName.setBounds(560, 260, 220, 30);
		jpfPW.setBounds(560, 310, 220, 30);
		jtfEmail.setBounds(560, 360, 220, 30);
		
		// 콤보박스 크기와 위치 설정
		jcbDept.setBounds(560, 410, 220, 30);

		// 버튼 크기와 위치 설정
		jbtnReg.setBounds(380, 490, 90, 50);
		jbtnCancel.setBounds(530, 490, 90, 50);

		// 폰트 설정
		Font newFont = new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 20);
		jlProfNum.setFont(newFont);
		jlName.setFont(newFont);
		jlPW.setFont(newFont);
		jlEmail.setFont(newFont);
		jlDept.setFont(newFont);
		Font loginFont = new Font("나눔스퀘어라운드 ExtraBold", Font.BOLD, 15);
		jlLogin.setFont(loginFont);
		jlLogin.setForeground(Color.RED);
		Font sFont = new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 10);
		jlEssential.setFont(sFont);
		jlEssential.setForeground(Color.RED);

		add(jlPhoto);
		add(jlProfNum);
		add(jlName);
		add(jlPW);
		add(jlEmail);
		add(jlDept);
		add(jlEssential);
		add(jlLogin);
		add(jlBanner1);
		add(jlBanner2);

		add(jtfProfNum);
		add(jtfName);
		add(jpfPW);
		add(jtfEmail);
		
		add(jcbDept);

		add(jbtnReg);
		add(jbtnCancel);

		add(jlBackground);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}// 생성자

	public static void main(String[] args) {
		new AdminProfMgtRegDesign();
	}// main

}// class
