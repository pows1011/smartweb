import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class update {
	public static void main(String ar[]) {
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/haksa?useUnicode=true&amp;"
				+ "characterEncoding=euckr";
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
			
			System.out.println("post���̺� ���ڵ� �� �����ϱ�");
			System.out.println("������ ���̸��� �Է� �ϼ���:");
			dong=sc.nextLine(); // ���� ��
			System.out.println(dong);
			System.out.print("���� �� post_no�� �����ϼ���:");
			postno=sc.nextLine();
			System.out.println(postno);
			sql="update post set post_dong='"+dong+"' WHERE post_no='"+postno+"'";
			
			stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
		}catch(Exception e) {
			System.out.println("�� �� "+e);
		}
	}
}
