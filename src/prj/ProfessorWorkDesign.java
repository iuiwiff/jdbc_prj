package prj;

import javax.swing.*;

@SuppressWarnings("serial")
public class ProfessorWorkDesign extends JFrame {
    public ProfessorWorkDesign() {

        setTitle("교수 작업창");
        setSize(1000, 1000);

        setVisible(true);
        
        // 프레임크기 조절 불가
        setResizable(false);
        
        // 프레임을 화면 중앙에 배치
        setLocationRelativeTo(null);
    }
}

