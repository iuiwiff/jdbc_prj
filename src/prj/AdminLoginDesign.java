package prj;

import javax.swing.*;


@SuppressWarnings("serial")
public class AdminLoginDesign extends JFrame {
	
	private SelectLoginEvent sle;
    private JTextField jtfId;
    private JPasswordField jpfPass;

    
    JButton loginButton ;


    

    AdminLoginDesign(SelectLoginEvent sle) {

        setTitle("관리자 로그인");
        this.sle = sle;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 180);
        setLocationRelativeTo(null);

        // 사용자 이름 입력 필드
        JLabel jlbId = new JLabel("관리자 ID:");
        jtfId = new JTextField(20);
        jlbId.setBounds(20, 20, 100, 30);
        jtfId.setBounds(120, 20, 150, 30);

        // 패스워드 입력 필드
        JLabel jlbPass = new JLabel("PassWord:");
        jpfPass = new JPasswordField(20);
        jlbPass.setBounds(20, 50, 100, 30);
        jpfPass.setBounds(120, 50, 150, 30);

        // 로그인 버튼
        loginButton = new JButton("로그인");
        loginButton.setBounds(120, 90, 100, 30);
        
   
        AdminLoginEvent ale = new AdminLoginEvent(this);
        
        
        
        addWindowListener(ale);
        loginButton.addActionListener(ale);
        jtfId.addActionListener(ale);
        jpfPass.addActionListener(ale);
        
        
        
        

        // 프레임에 컴포넌트 추가
        add(jlbId);
        add(jtfId);
        add(jlbPass);
        add(jpfPass);
        add(loginButton);

        // 레이아웃 매니저 설정 비활성화
        setLayout(null);

        // 프레임 표시
        setVisible(true);
    }




	public SelectLoginEvent getSle() {
		return sle;
	}




	public JTextField getJtfId() {
		return jtfId;
	}




	public JPasswordField getJpfPass() {
		return jpfPass;
	}




	public JButton getLoginButton() {
		return loginButton;
	}



}