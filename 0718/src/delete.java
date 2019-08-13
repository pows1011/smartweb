import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class delete {

	public static void main(String[] args) {
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/haksa?useUnicode=true&amp;characterEncoding=euckr";
		String user="root";
		String password="1111";
		String sql,dong,postno;
		
		Connection conn=null;
		Statement stmt=null;
		
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user,password);
			stmt=conn.createStatement();
			Scanner sc=new Scanner(System.in);
			System.out.println("post테이블 레코드 값 제거하기");
			System.out.println("제거 할 동이름을 입력 하세요:");
			dong=sc.nextLine(); // 제거할 동
			System.out.println(dong);
			System.out.println("제거할 post_no 입력:");
			postno=sc.nextLine();
			System.out.println(postno);
			sql="delete from post_dong='"+dong+"' WHERE post_no='"+postno+"'";
			stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
		}catch(Exception e) {
			
		}
	}

}
