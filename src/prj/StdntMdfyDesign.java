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

public class StdntMdfyDesign extends JFrame {

	private JButton jbtnModify, jbtnCancel;
	private JLabel jlStdntNum, jlAddress, jlPW, jlEmail, jlEssential, jlLogin, jlPhoto, jlBackground, jlBanner1;
	private JTextField jtfStdntNum, jtfEmail, jtfAddress;
	private JPasswordField jpfPW;

	public StdntMdfyDesign() {
		super("학생모드_정보수정");

		String imagePath = "src/prj/images/";

		// 라벨 생성
		jlStdntNum = new JLabel("학번");
		jlPW = new JLabel("PW");
		jlEmail = new JLabel("이메일");
		jlAddress = new JLabel("주소");
		jlEssential = new JLabel("*PW, 이메일은 필수입력 사항");
		jlLogin = new JLabel("학생 로그인 중");

		// 이미지 생성
		ImageIcon backImage = new ImageIcon(imagePath + "background.png");
		ImageIcon photo = new ImageIcon(imagePath + "photo.png");

		ImageIcon buttonImage1 = new ImageIcon(imagePath + "mdfybutton.png");
		ImageIcon buttonImage2 = new ImageIcon(imagePath + "cancelbutton.png");

		ImageIcon bannerImage1 = new ImageIcon(imagePath + "infomdfybanner.png");

		jlBackground = new JLabel(backImage);
		jlPhoto = new JLabel(photo);
		jlBackground.setSize(984, 620);

		jlBanner1 = new JLabel(bannerImage1);

		// 텍스트필드 생성
		jtfStdntNum = new JTextField(10);
		jtfEmail = new JTextField(10);
		jtfAddress = new JTextField(3);

		// 패스워드필드 생성
		jpfPW = new JPasswordField(10);

		// 버튼 생성
		jbtnModify = new JButton(buttonImage1);
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
		jlStdntNum.setBounds(465, 230, 50, 30);
		jlPW.setBounds(465, 280, 50, 30);
		jlEmail.setBounds(465, 330, 70, 30);
		jlAddress.setBounds(465, 380, 100, 30);
		jlEssential.setBounds(655, 415, 150, 15);
		jlLogin.setBounds(880, 25, 130, 30);
		jlBanner1.setBounds(10, 76, 967, 45);

		// 텍스트필드 크기와 위치 설정
		jtfStdntNum.setBounds(560, 230, 220, 30);
		jtfEmail.setBounds(560, 280, 220, 30);
		jpfPW.setBounds(560, 330, 220, 30);
		jtfAddress.setBounds(560, 380, 220, 30);
		
		// 버튼 크기와 위치 설정
		jbtnModify.setBounds(380, 490, 90, 50);
		jbtnCancel.setBounds(530, 490, 90, 50);

		// 폰트 설정
		Font newFont = new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 20);
		jlStdntNum.setFont(newFont);
		jlAddress.setFont(newFont);
		jlPW.setFont(newFont);
		jlEmail.setFont(newFont);
		Font loginFont = new Font("나눔스퀘어라운드 ExtraBold", Font.BOLD, 15);
		jlLogin.setFont(loginFont);
		jlLogin.setForeground(Color.GREEN);
		Font sFont = new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 10);
		jlEssential.setFont(sFont);
		jlEssential.setForeground(Color.RED);

		add(jlPhoto);
		add(jlStdntNum);
		add(jlPW);
		add(jlEmail);
		add(jlAddress);
		add(jlEssential);
		add(jlLogin);
		add(jlBanner1);

		add(jtfStdntNum);
		add(jtfEmail);
		add(jpfPW);
		add(jtfAddress);
		
		add(jbtnModify);
		add(jbtnCancel);

		add(jlBackground);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}// 생성자

	public static void main(String[] args) {
		new StdntMdfyDesign();
	}// main

}// class
