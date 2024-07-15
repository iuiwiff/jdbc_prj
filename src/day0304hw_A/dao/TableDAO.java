package day0304.homework.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import day0304.homework.DBConnection;

public class TableDAO {
    private static TableDAO tDAO;

    private TableDAO() {

    }

    public static TableDAO getInstance() {
        if (tDAO == null) {
            tDAO = new TableDAO();
        }

        return tDAO;
    }

    public List<String> selectAllTab() throws SQLException {
        List<String> tables = new ArrayList<String>();

        // 1. 드라이버 로딩
        DBConnection dbConn = DBConnection.getInstance();

        // 2. 커넥션 객체 생성
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 3. 쿼리문 생성
            conn = dbConn.getConnection();
            String selectAllTables = "select * from tab";
            pstmt = conn.prepareStatement(selectAllTables);
            // 4. 바인드 변수 지정
            // 5. 쿼리 실행 및 결과 확인
            rs = pstmt.executeQuery();

            while (rs.next()) {
                tables.add(rs.getString("tname"));
            }
        } finally {
            // 6. 연결 끊기
            dbConn.dbClose(rs, conn, pstmt);
        }

        return tables;
    }

    public String selectAllData(String tableName) throws SQLException {
        StringBuilder data = new StringBuilder();

        // 1. 드라이버 로딩
        DBConnection dbConn = DBConnection.getInstance();

        // 2. 커넥션 객체 생성
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ResultSetMetaData rsMeta = null;

        try {
            conn = dbConn.getConnection();
            // 3. 쿼리문 생성
            String selectAll = "select * from dept";
            pstmt = conn.prepareStatement(selectAll);

            // 4. 바인드 변수 지정
            // pstmt.setString(1, tableName);

            // 5. 쿼리 실행 및 결과 확인
            rs = pstmt.executeQuery();
            rsMeta = rs.getMetaData();

            int colCount = rsMeta.getColumnCount();
            StringBuilder tempStr = null;

            while (rs.next()) {
                tempStr = new StringBuilder();
                for (int i = 1; i <= colCount; i++) {
                    tempStr.append(rs.getObject(i)).append("\t");
                }
                tempStr.append("\n");
                data.append(tempStr);
                System.out.println(tempStr);
            }
        } finally {
            // 6. 연결 끊기
            dbConn.dbClose(rs, conn, pstmt);
        }
        return data.toString();
    }
}
