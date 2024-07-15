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

public class AdminCsrMgtReg extends JFrame {

	private JButton jbtnModify, jbtnCancel;
	private JLabel jlDept, jlCrs, jlCrsCode, jlProf, jlLect, jlCapa, jlCredit, jlEssential, jlLogin, jlBackground, jlBanner1,
			jlBanner2;
	private JTextField jtfCrs, jtfCrsCode, jtfCredit;
	private JComboBox<String> jcbDept, jcbProf;

	public AdminCsrMgtReg() {
		super("관리자모드_과목관리_등록");

		String imagePath = "src/prj/images/";

		// 라벨 생성
		jlDept = new JLabel("학과");
		jlCrs = new JLabel("과목");
		jlCrsCode = new JLabel("과목 코드");
		jlProf = new JLabel("교수");
		jlLect = new JLabel("강의실");
		jlCapa = new JLabel("정원");
		jlCredit = new JLabel("학점");
		jlEssential = new JLabel("*과목, 과목 코드, 학점은 필수입력 사항");
		jlLogin = new JLabel("관리자 로그인 중");

		// Model객체 생성
		DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<String>();
		DefaultComboBoxModel<String> dcbm2 = new DefaultComboBoxModel<String>();
		
		// Model객체와 has a 관계 View 생성
		jcbDept = new JComboBox<String>(dcbm);
		jcbProf = new JComboBox<String>(dcbm2);
		
		// 데이터 추가
		//dcbm.addElement();

		// 이미지 생성
		ImageIcon backImage = new ImageIcon(imagePath + "background.png");

		ImageIcon buttonImage1 = new ImageIcon(imagePath + "regbutton.png");
		ImageIcon buttonImage2 = new ImageIcon(imagePath + "cancelbutton.png");

		ImageIcon bannerImage1 = new ImageIcon(imagePath + "crsbanner.png");
		ImageIcon bannerImage2 = new ImageIcon(imagePath + "regbanner.png");

		jlBackground = new JLabel(backImage);
		jlBackground.setSize(984, 620);

		jlBanner1 = new JLabel(bannerImage1);
		jlBanner2 = new JLabel(bannerImage2);

		// 텍스트필드 생성
		jtfCrs = new JTextField(10);
		jtfCrsCode = new JTextField(10);
		jtfCredit = new JTextField(10);

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
		jlDept.setBounds(350, 210, 50, 30);
		jlCrs.setBounds(350, 260, 50, 30);
		jlCrsCode.setBounds(350, 310, 100, 30);
		jlProf.setBounds(350, 360, 100, 30);
		jlCredit.setBounds(350, 410, 100, 30);
		jlEssential.setBounds(507, 445, 200, 15);
		jlLogin.setBounds(865, 25, 130, 30);
		jlBanner1.setBounds(10, 76, 967, 45);
		jlBanner2.setBounds(10, 121, 967, 45);

		// 텍스트필드 크기와 위치 설정
		jtfCrs.setBounds(450, 260, 220, 30);
		jtfCrsCode.setBounds(450, 310, 220, 30);
		jtfCredit.setBounds(450, 410, 220, 30);
		
		// 콤보박스 크기와 위치 설정
		jcbDept.setBounds(450, 210, 220, 30);
		jcbProf.setBounds(450, 360, 220, 30);

		// 버튼 크기와 위치 설정
		jbtnModify.setBounds(380, 490, 90, 50);
		jbtnCancel.setBounds(530, 490, 90, 50);

		// 폰트 설정
		Font newFont = new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 20);
		jlDept.setFont(newFont);
		jlCrs.setFont(newFont);
		jlCrsCode.setFont(newFont);
		jlProf.setFont(newFont);
		jlCredit.setFont(newFont);
		Font loginFont = new Font("나눔스퀘어라운드 ExtraBold", Font.BOLD, 15);
		jlLogin.setFont(loginFont);
		jlLogin.setForeground(Color.RED);
		Font sFont = new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 10);
		jlEssential.setFont(sFont);
		jlEssential.setForeground(Color.RED);

		add(jlDept);
		add(jlCrs);
		add(jlCrsCode);
		add(jlProf);
		add(jlLect);
		add(jlCapa);
		add(jlCredit);
		add(jlEssential);
		add(jlLogin);
		add(jlBanner1);
		add(jlBanner2);

		add(jcbDept);
		add(jtfCrs);
		add(jtfCrsCode);
		add(jcbProf);
		add(jtfCredit);
		
		add(jbtnModify);
		add(jbtnCancel);

		add(jlBackground);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}// 생성자

	public static void main(String[] args) {
		new AdminCsrMgtReg();
	}// main

}// class
