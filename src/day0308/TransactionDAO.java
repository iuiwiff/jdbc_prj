package day0308;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.co.sist.dao.DbConnection;

/**
 * 여러개의 쿼리문이 하나의 Transaction으로 구성되는 경우
 */
public class TransactionDAO {
	
	private Connection con;
	
	/**
	 * 쿼리문을 수행하고 수행된 쿼리문의 모든 행수(개발자가 목표로하는 행수)를 반환
	 * @return
	 * @throws SQLException
	 */
	public int transaction(String name, String addr) throws SQLException{
		int returnCnt = 0;
		
		DbConnection dbCon = DbConnection.getInstance();
		//1. 드라이버 로딩
		
		//2. 커넥션 얻기
		String id = "scott";
		String pass = "tiger";
		con = dbCon.getConnection(id, pass);
		//autocommit 해제
		con.setAutoCommit(false);
		
		//3. 쿼리문 생성객체 얻기
		String insertTransaction = "insert into test_transaction(name,addr) values(?,?)";
		PreparedStatement pstmt = con.prepareStatement(insertTransaction);
		
		//4. 바인드 변수 값 설정
		pstmt.setString(1, name);
		pstmt.setString(2, addr);
		
		//5. 쿼리문 수행 후 결과 얻기
		returnCnt += pstmt.executeUpdate();
		
		
		//////////////////////////반복/////////////////////////
		//3. 쿼리문 생성객체 얻기
		String insertTransaction2 = "insert into test_transaction2(name,addr) values(?,?)";
		PreparedStatement pstmt2 = con.prepareStatement(insertTransaction2);
				
		//4. 바인드 변수 값 설정
		pstmt2.setString(1, name);
		pstmt2.setString(2, addr);
				
		//5. 쿼리문 수행 후 결과 얻기
		returnCnt += pstmt2.executeUpdate();
				
		
		return returnCnt;
	}//transaction
	
	
	
	/**
	 * 목표로하는 행수를 받아서 commit 또는 rollback을 수행하고, 연결 끊기
	 */
	public void useTransaction() {
		String name = "윤웅찬";
		String addr = "수원시 영통동";
		
		try {
			int cnt = transaction(name, addr);
			if(cnt == 2) {
				System.out.println("레코드 추가 성공");
				con.commit();
			}
		} catch (SQLException e) {
			try {
				System.out.println("앗! 작업취소!! 일관성 유지");
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				con.close(); //연결 종료되면 정상종료라고 판단하여 예외가 발생하기 전까지는 commit이 된다. => 일관성
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}//useTransaction
	
	
	

	public static void main(String[] args) {
		TransactionDAO tDAO = new TransactionDAO();
		tDAO.useTransaction();
	}//main

}//class
