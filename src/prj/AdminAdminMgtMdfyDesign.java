package prj;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import eduCourse_prj.VO.LoginVO;

public class AdminAdminMgtMdfyDesign extends JFrame {
	private LoginVO lVO;

	private JButton jbtnModify, jbtnCancel;
	private JLabel jlID, jlPW, jlName, jlEssential, jlLogin, jlPhoto, jlBackground, jlBanner1, jlBanner2;
	private JTextField jtfID, jtfPW, jtfName;

	public AdminAdminMgtMdfyDesign(LoginVO lVO) {
		super("관리자모드_관리자관리_수정");
		
		this.lVO = lVO;

		// 라벨 생성
		jlID = new JLabel("ID");
		jlPW = new JLabel("PW");
		jlName = new JLabel("이름");
		jlEssential = new JLabel("*PW, 이름은 필수입력 사항");
		jlLogin = new JLabel(lVO.getname() + "관리자 로그인 중");

		// 이미지 생성
		ImageIcon backImage = new ImageIcon("src/prj/images/background.png");
		ImageIcon photo = new ImageIcon("src/prj/images/photo.png");

		ImageIcon buttonImage1 = new ImageIcon("src/prj/images/mdfybutton.png");
		ImageIcon buttonImage2 = new ImageIcon("src/prj/images/cancelbutton.png");

		ImageIcon bannerImage1 = new ImageIcon("src/prj/images/adminmgtbanner.png");
		ImageIcon bannerImage2 = new ImageIcon("src/prj/images/mdfybanner.png");

		jlBackground = new JLabel(backImage);
		jlPhoto = new JLabel(photo);
		jlBackground.setSize(984, 620);

		jlBanner1 = new JLabel(bannerImage1);
		jlBanner2 = new JLabel(bannerImage2);

		// 텍스트필드 생성
		jtfID = new JTextField(10);
		jtfPW = new JTextField(10);
		jtfName = new JTextField(3);

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
		jlPhoto.setBounds(215, 210, 198, 233);
		jlID.setBounds(465, 255, 50, 30);
		jlPW.setBounds(465, 310, 50, 30);
		jlName.setBounds(465, 365, 50, 30);
		jlEssential.setBounds(640, 400, 120, 15);
		jlLogin.setBounds(865, 25, 130, 30);
		jlBanner1.setBounds(10, 76, 967, 45);
		jlBanner2.setBounds(10, 121, 967, 45);

		// 텍스트필드 크기와 위치 설정
		jtfID.setBounds(535, 255, 220, 30);
		jtfPW.setBounds(535, 310, 220, 30);
		jtfName.setBounds(535, 365, 220, 30);

		// 버튼 크기와 위치 설정
		jbtnModify.setBounds(380, 490, 90, 50);
		jbtnCancel.setBounds(530, 490, 90, 50);

		// 폰트 설정
		Font newFont = new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 20);
		jlID.setFont(newFont);
		jlPW.setFont(newFont);
		jlName.setFont(newFont);
		Font loginFont = new Font("나눔스퀘어라운드 ExtraBold", Font.BOLD, 15);
		jlLogin.setFont(loginFont);
		jlLogin.setForeground(Color.RED);
		Font sFont = new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 10);
		jlEssential.setFont(sFont);
		jlEssential.setForeground(Color.RED);

		add(jlPhoto);
		add(jlID);
		add(jlPW);
		add(jlName);
		add(jlEssential);
		add(jlLogin);
		add(jlBanner1);
		add(jlBanner2);

		add(jtfID);
		add(jtfPW);
		add(jtfName);

		add(jbtnModify);
		add(jbtnCancel);

		add(jlBackground);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}// 생성자

	public JButton getJbtnModify() {
		return jbtnModify;
	}

	public JButton getJbtnCancel() {
		return jbtnCancel;
	}

	public JTextField getJtfID() {
		return jtfID;
	}

	public JTextField getJtfPW() {
		return jtfPW;
	}

	public JTextField getJtfName() {
		return jtfName;
	}

	public static void main(String[] args) {
		new AdminAdminMgtMdfyDesign();
	}

}