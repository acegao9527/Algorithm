package text_1;

import java.sql.*;

public class Renewal { // ������
	static Connection con; // ����Connection����
	static PreparedStatement sql; // ����PreparedStatement����
	static ResultSet res; // ����ResultSet����
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://10.108.145.113:3306/" + "test2",
					"root", "wspnzx");
			if(!con.isClosed())
				System.out.println("Succeeded connecting to the Database!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void main(String[] args) {
		
		Renewal c = new Renewal(); // �����������
		con = c.getConnection(); // �����������ݿⷽ��
		try {
//			sql = con.prepareStatement("select * from tb_stu"); // ��ѯ���ݿ�
//			res = sql.executeQuery(); // ִ��SQL���
				for(int i=0;i<9;i++){
						sql = con.prepareStatement("insert into test2 values(?,?,?,?,?)");
						for(int j=0;j<=4;j++){
						sql.setDouble(j+1, Canopy.liucun[i][j]);
						}
				}  
				
			sql.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
