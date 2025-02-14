package kr.co.sist.prepared.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.dao.DbConnection;
import kr.co.sist.vo.ZipcodeVO;

public class ZipcodeDAO {
	private static ZipcodeDAO zDAO;
	
	private ZipcodeDAO() {
		
	}//생성자
	
	public static ZipcodeDAO getInstance() {
		if(zDAO == null) {
			zDAO = new ZipcodeDAO();
		}//end if
		
		return zDAO;
		
	}//getInstance
	
	public List<ZipcodeVO> selectZipcode(String dong) throws SQLException{
		List<ZipcodeVO> list = new ArrayList<ZipcodeVO>();
		
		DbConnection dbCon = DbConnection.getInstance();

		//1.
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; //데이터가 아니라 커서의 제어권을 가지고 있음

		try {
		//2.
			String id = "scott";
			String pass = "tiger";
			con = dbCon.getConnection(id, pass);
			
		//3.
			StringBuilder selectZipcode = new StringBuilder();
			selectZipcode
			.append("	select zipcode, sido, gugun, dong, nvl(bunji, ' ') bunji	")
			.append("	from zipcode	")
			.append("	where dong like ?||'%'	");
			
			pstmt = con.prepareStatement(selectZipcode.toString());
			
		//4.
			pstmt.setString(1, dong);
			
		//5.
			rs = pstmt.executeQuery();
			
			ZipcodeVO zVO = null;
			while(rs.next()) { //조회된 결과에서 다음 레코드가 존재?
				zVO = new ZipcodeVO(rs.getString("zipcode"), 
						rs.getString("sido"), rs.getString("gugun"), 
						rs.getString("dong"), rs.getString("dong"));
//						rs.getString(5)); //인덱스 사용 지양, 어떤 컬럼을 가져오는지 알 수 있는 컬럼명 사용 > 가독성 상승
				
				list.add(zVO);
			}//end while
			
		}finally {
			
		//6.
			dbCon.dbClose(rs, pstmt, con);
		}//end finally
			
		return list;
	}//selectZipcode
	
	public List<ZipcodeVO> selectStatementZipcode(String dong) throws SQLException{
		List<ZipcodeVO> list = new ArrayList<ZipcodeVO>();
		
		DbConnection dbCon = DbConnection.getInstance();

		//1.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null; //데이터가 아니라 커서의 제어권을 가지고 있음

		try {
		//2.
			String id = "scott";
			String pass = "tiger";
			con = dbCon.getConnection(id, pass);
			
		//3.
			
			stmt = con.createStatement();
			
		//4.
			StringBuilder selectZipcode = new StringBuilder();
			selectZipcode
			.append("	select zipcode, sido, gugun, dong, nvl(bunji, ' ') bunji	")
			.append("	from zipcode	")
			.append("	where dong like '" + dong + "%'	");
			
			rs = stmt.executeQuery(selectZipcode.toString());
			
			ZipcodeVO zVO = null;
			while(rs.next()) { //조회된 결과에서 다음 레코드가 존재?
				zVO = new ZipcodeVO(rs.getString("zipcode"), 
						rs.getString("sido"), rs.getString("gugun"), 
						rs.getString("dong"), rs.getString("bunji"));
//						rs.getString(5)); //인덱스 사용 지양, 어떤 컬럼을 가져오는지 알 수 있는 컬럼명 사용 > 가독성 상승
				
				list.add(zVO);
			}//end while
			
		}finally {
			
		//6.
			dbCon.dbClose(rs, stmt, con);
		}//end finally
			
		return list;
	}//selectStatementZipcode
	
	
	
//	public static void main(String[] args) {
//		ZipcodeDAO zD = ZipcodeDAO.getInstance();
//		try {
//			System.out.println(zD.selectZipcode("역삼1동"));
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}//end catch
//	}//main
	
}//class
