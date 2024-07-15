package day0305hw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    private static DBConnection dbConn;

    private DBConnection() {

    }

    public static DBConnection getInstance() {
        if (dbConn == null) {
            dbConn = new DBConnection();
        }

        return dbConn;
    }

    public Connection getConnection() throws SQLException {
        Connection con = null;

        // 1. 드라이버 로딩
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String id = "scott";
        String pw = "tiger";

        // 2. Connection 얻기
        con = DriverManager.getConnection(url, id, pw);
        return con;
    }

    public void dbClose(ResultSet rs, Connection conn, Statement stmt) throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (conn != null) {
            conn.close();
        }
        if (stmt != null) {
            stmt.close();
        }
    }
}
