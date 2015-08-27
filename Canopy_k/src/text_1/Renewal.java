package text_1;

import java.sql.*;

public class Renewal { // 创建类
	static Connection con; // 声明Connection对象
	static PreparedStatement sql; // 声明PreparedStatement对象
	static ResultSet res; // 声明ResultSet对象
	
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
		
		Renewal c = new Renewal(); // 创建本类对象
		con = c.getConnection(); // 调用连接数据库方法
		try {
//			sql = con.prepareStatement("select * from tb_stu"); // 查询数据库
//			res = sql.executeQuery(); // 执行SQL语句
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
