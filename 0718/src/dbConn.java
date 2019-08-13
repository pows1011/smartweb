import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class dbConn {
	public static void main(String ar[]) {
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/haksa?useUnicode=true&amp;"
				+ "characterEncoding=euckr";
		String user="root";
		String pwd="1111";
		String sql;
		String no,dong,address,ddd;
		//int age;
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, pwd);
			stmt=conn.createStatement();
			sql="select * from post";
			System.out.println("no\t\t dong\t\t address\t\t ddd\t\t");
			System.out.println("=============================================");
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
			no=rs.getString("post_no");
					dong=rs.getString("post_dong");
					address=rs.getString("post_address");
					ddd=rs.getString("ddd");					
					System.out.printf("%s\t\t %s\t\t %s\t\t %s\t\t",no,dong,address,ddd);
					System.out.println();
			}
			//System.out.println("DB연결성공");
			
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e) {
			System.out.println("DB연결실패"+e);
			
		}
	}
}
