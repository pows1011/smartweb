import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class insert {

	public static void main(String[] args) {
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://127.0.0.1:3306/haksa?useUnicode="
				+ "true&amp;characterEncoding=euckr";
		String user="root";
		String password="1111";
		
		Connection conn=null;
		Statement stmt=null;
		
		String sql;
		
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user,password);
			stmt=conn.createStatement();
			
			System.out.println("post테이블에 레코드값을 입력하세요");
			sql="INSERT INTO post VALUES('051-865','연산동','부산시 연제구 연산동','051')";
			stmt.executeUpdate(sql);  // Update = update,insert,delete     executeQuery= select 
			stmt.close();
			conn.close();
		}catch(Exception e) {
			System.out.println("예외발생"+e);
		}
	}

}
