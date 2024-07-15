package day0304hw;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.dao.DbConnection;
import kr.co.sist.statement.vo.EmployeeVO;

public class TableDAO {

	private static TableDAO tDAO;

	// 싱글턴 패턴 적용
	private TableDAO() {

	}// 생성자

	public static TableDAO getInstance() {
		if (tDAO == null) {
			tDAO = new TableDAO();
		} // end if
		return tDAO;
	}// getInstance
	
	
	//////////////////////계정 테이블 조회////////////////////////
	public List<String> selectAllTab() throws SQLException { // 모든 레코드를 가져오기 때문에 매개변수 없음
		List<String> resultList = new ArrayList<>();

		DbConnection dbCon = DbConnection.getInstance();

		//1. 드라이버 로딩
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			//2. 커넥션 얻기
			String id = "scott";
			String pass = "tiger";
			con = dbCon.getConnection(id, pass);

			//3. 쿼리문 생성객체 얻기
			String searchTableList = "select * from tab";

			pstmt = con.prepareStatement(searchTableList);

			//4. 바인드 변수에 값 설정 - 없음

			//5. 쿼리문 수행 후 결과 얻기
			rs = pstmt.executeQuery(); // 커서의 제어권을 받음

			EmployeeVO eVO = null;
			while (rs.next()) { // 조회된 레코드가 존재하면
				//VO에 검색결과를 저장하고
				resultList = new ArrayList<String>(); // 원래 hiredate의 자리엔 null

				list.add(eVO);
			} // end while
		} finally {
			//6. 연결 끊기
			dbCon.dbClose(rs, pstmt, con);
		} // end finally

		return list;
	}// selectAllEmp

}//class
