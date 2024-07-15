package prj;

import javax.swing.*;

@SuppressWarnings("serial")
public class StudentWorkDesign extends JFrame {
    public StudentWorkDesign() {

        setTitle("학생 작업창");
        setSize(1000, 1000);

        setVisible(true);
        
        // 프레임크기 조절 불가
        setResizable(false);
        
        // 프레임을 화면 중앙에 배치
        setLocationRelativeTo(null);
    }
}

