package prj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class ProfessorLoginDAO {
	private static ProfessorLoginDAO plDAO;

	private ProfessorLoginDAO() {

	}

	public static ProfessorLoginDAO getInstance() {
		if (plDAO == null) {
			plDAO = new ProfessorLoginDAO();

		} // end if

		return plDAO;
	}
	
	
	public LoginVO professorLogin(LoginVO lVO) throws SQLException {
	    LoginVO lresultVO = null;
	    DbConnection dbcon = DbConnection.getInstance();
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        // 1. 데이터베이스 접속 정보
	        String id = "scott";
	        String pass = "tiger";

	        // 2. 데이터베이스 연결
	        con = dbcon.getConnection(id, pass);

	        // 3. SQL 쿼리 준비
	        String selectQuery = "SELECT professor_number, password FROM professor WHERE  professor_number = ? AND password = ?";
	        pstmt = con.prepareStatement(selectQuery);

	        // 4. SQL 쿼리에 파라미터 설정

	        pstmt.setString(1, lVO.getId());
	        pstmt.setString(2, lVO.getPassword());

	        // 5. 쿼리 실행 및 결과 처리
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	        	
	            lresultVO = new LoginVO(rs.getString("professor_number"), rs.getString("password"));
	        }
	    } finally {
	        // 6. 리소스 해제
	        dbcon.dbClose(rs, pstmt, con);
	    }

	  
	    return lresultVO;
	}
}