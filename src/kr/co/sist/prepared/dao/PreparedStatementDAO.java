package kr.co.sist.prepared.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.dao.DbConnection;
import kr.co.sist.statement.vo.EmployeeVO;

public class PreparedStatementDAO {
	
	private static PreparedStatementDAO psDAO;

	//싱글턴 패턴을 적용
	////////////////////////생성자///////////////////////
	private PreparedStatementDAO() {
		
	}//생성자
	
	public static PreparedStatementDAO getInstance() { //static은 메모리에 먼저 진입
		if(psDAO == null) {
			psDAO = new PreparedStatementDAO();
		}//end if
		return psDAO;
	}//getInstance
	
	
	
	/////////////////////////INSERT////////////////////////
	public void insertEmp(EmployeeVO eVO) throws SQLException {
		
		DbConnection dbCon = DbConnection.getInstance();
		
		//1. 드라이버 로딩 - DbConnection 안에 있음
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			//2. 커넥션 얻기
			String id = "scott";
			String pass = "tiger";
			con = dbCon.getConnection(id, pass);
			
			//3. 쿼리문 생성 객체 얻기 (값이 들어가는 위치는 바인드변수 '?'를 사용한다.)
			String insertEmp = 
					"insert into employee(empno, ename, job, sal) values(?, ?, ?, ?)";
			pstmt = con.prepareStatement(insertEmp);
			
			//4. 바인드변수 값 설정
			pstmt.setInt(1, eVO.getEmpno());
			pstmt.setString(2, eVO.getEname());
			pstmt.setString(3, eVO.getJob());
			pstmt.setDouble(4, eVO.getSal());
			
			//5. 쿼리문 수행 후 결과 얻기 (주의: Statement의 excuteXxx(SQL)는 절대로 사용하지 않는다!)
			pstmt.executeUpdate();
			
			
		}finally {
		//6. 연결 끊기 - DbConnection 안에 있음
			dbCon.dbClose(null, pstmt, con);
		}//end finally
		
	}//insertEmp
	
	
	
	//////////////////////////UPDATE//////////////////////////
	public int updateEmp(EmployeeVO eVO) throws SQLException {
		int cnt = 0;
		
		DbConnection dbCon = DbConnection.getInstance(); //싱글턴
		
		//1. 드라이버 로딩
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
		//2. 커넥션 얻기
			String id = "scott";
			String pass = "tiger";
			con = dbCon.getConnection(id, pass);
			
		//3. 쿼리문 생성객체 얻기
			//String updateEmp = "update employee set job=?, sal=? where empno=?";
			StringBuilder updateEmp = new StringBuilder();
			updateEmp
			.append("update employee ")
			.append("set job=?, sal=? ")
			.append("where empno=? ");
			
			pstmt = con.prepareStatement(updateEmp.toString());
			
		//4. 바인드 변수에 값 설정하기
			pstmt.setString(1, eVO.getJob());
			pstmt.setDouble(2, eVO.getSal());
			pstmt.setInt(3, eVO.getEmpno());
			
		//5. 쿼리문 수행 후 결과 얻기
			cnt = pstmt.executeUpdate();
		}finally {
			
			//6. 연결 끊기
			dbCon.dbClose(null, pstmt, con);
		}//end finally
		
		return cnt;
	
	}//updateEmp
	
	
	
	//////////////////////////DELETE///////////////////////// - update랑 완전 같음
	/**
	 * 사원번호를 입력받아 해당 사원을 삭제
	 * @param empno
	 * @return
	 * @throws SQLException
	 */
	public int deleteEmp(int empno) throws SQLException{
		int cnt = 0;
		
		DbConnection dbCon = DbConnection.getInstance();
		
		//1.
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
		//2.
			String id = "scott";
			String pass = "tiger";
			con = dbCon.getConnection(id, pass);
			
		//3.
			String deleteEmp = "delete from employee where empno=?";
			pstmt = con.prepareStatement(deleteEmp);
					
		//4.
			pstmt.setInt(1, empno);
			
		//5.
			cnt = pstmt.executeUpdate();
		}finally {
			
		//6.
			dbCon.dbClose(null, pstmt, con);
		}//end finally
		return cnt;
		
	}//deleteEmp
	
	
	
	/////////////////////SELECT 한 행 조회//////////////////////
	public EmployeeVO selectOneEmp(int empno) throws SQLException {
		EmployeeVO eVO = null;
		
		DbConnection dbCon = DbConnection.getInstance();
		
		//1.
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		//2.
			String id = "scott";
			String pass = "tiger";
			con = dbCon.getConnection(id, pass);
			
		//3.
			StringBuilder selectOneEmp = new StringBuilder();
			selectOneEmp
			.append("	select ename, job, sal, hiredate, to_char(hiredate,'yyyy-mm-dd') hiredate2	")
			.append("	from employee	")
			.append("	where empno=?	"); //tab 2번은 띄어쓰기 때문에 발생하는 오류 방지
			
			pstmt = con.prepareStatement(selectOneEmp.toString());
			
		//4.
			pstmt.setInt(1, empno);
			
		//5.
			rs = pstmt.executeQuery(); //조회된 결과를 움직일 수 있는 커서의 제어권을 받는다.
			//조회결과가 있다면
			if(rs.next()) { //조회 결과 있음
				eVO = new EmployeeVO(empno, rs.getString("ename")
						, rs.getString("job"), rs.getDouble("sal")
						, rs.getDate("hiredate"), rs.getString("hiredate2"));
			}//end if
		}finally {
		//6.
			dbCon.dbClose(rs, pstmt, con);
		}//end finally
		
		return eVO;
	}//selectOneEmp
	
	
	
	//////////////////////SELECT 여러행 조회////////////////////////
	public List<EmployeeVO> selectAllEmp() throws SQLException { //모든 레코드를 가져오기 때문에 매개변수 없음
		List<EmployeeVO> list = new ArrayList<EmployeeVO>();
		
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
			String selectAllEmp 
			= "select empno, ename, job, sal, to_char(hiredate, 'yyyy-mm-dd q\"분기\"') hiredate from employee";
			
			pstmt = con.prepareStatement(selectAllEmp);
			
		//4. 바인드 변수에 값 설정 - 없음
			
		//5. 쿼리문 수행 후 결과 얻기
			rs = pstmt.executeQuery(); //커서의 제어권을 받음
			
			EmployeeVO eVO = null;
			while(rs.next()) { //조회된 레코드가 존재하면
				//VO에 검색결과를 저장하고
				eVO = new EmployeeVO(rs.getInt("empno"), rs.getString("ename"),
						rs.getString("job"), rs.getDouble("sal"), 
						null, rs.getString("hiredate")); //원래 hiredate의 자리엔 null
				
			list.add(eVO);	
			}//end while
		}finally {
		//6. 연결 끊기
			dbCon.dbClose(rs, pstmt, con);
		}//end finally
		
		return list;
	}//selectAllEmp
	
	
	
}//class
