package prj;
import javax.swing.*;


@SuppressWarnings("serial")
public class SelectLoginDesign extends JFrame {
    private JButton adminButton;
    private JButton studentButton;
    private JButton professorButton;



    public SelectLoginDesign() {
        super("로그인 모드 선택");


        // 버튼 생성
        adminButton = new JButton("관리자 로그인");
        studentButton = new JButton("학생 로그인");
        professorButton = new JButton("교수 로그인");

        // 버튼 크기 및 위치 설정
        adminButton.setBounds(100, 150, 180, 200);

        professorButton.setBounds(300, 150, 180, 200);
        studentButton.setBounds(500, 150, 180, 200);

        // 프레임에 버튼 추가
        add(adminButton);
        add(studentButton);
        add(professorButton);
        

        // 프레임 크기 설정
        setSize(800, 800);

        // 프레임을 화면 중앙에 표시
        setLocationRelativeTo(null);
        
        SelectLoginEvent sle = new SelectLoginEvent(this);
        addWindowListener(sle);
        adminButton.addActionListener(sle);
        studentButton.addActionListener(sle);
        professorButton.addActionListener(sle);
        
        
        

        // 레이아웃 매니저 설정 비활성화
        setLayout(null);
        
        // 프레임 크기 조절 불가설정
        setResizable(false);
        
        setVisible(true);
        
    }

    public JButton getProfessorButton() {
		return professorButton;
	}

	public JButton getAdminButton() {
        return adminButton;
    }

    public JButton getStudentButton() {
        return studentButton;
    }

    public static void main(String[] args) {
    	
    	new SelectLoginDesign();


    	
    	
    	

       
    }
}