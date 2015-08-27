package text_1;

import java.sql.*;

public class JDBCTest {
	public static void main(String[] args){
		try {
			// 加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			// URL指向要访问的数据库名test
			String url = "jdbc:mysql://10.108.145.113:3306/test2";
			// MySQL配置时的用户名
			String user = "root";
			// MySQL配置时的密码
			String password = "wspnzx";
			// 连续数据库
			Connection connection = DriverManager.getConnection(url, user, password);
			if(!connection.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			// statement用来执行SQL语句
			Statement statement = connection.createStatement();
			// 要执行的SQL语句
			for(int k=0;k<36;k++){
				for(int i=0;i<9;i++){
					for(int j=0;j<=4;j++){
						PreparedStatement sql = connection.prepareStatement("insert into test2 values(?)");
						sql.setString(1, Double.toHexString(Canopy.liucun[i][j]));
					}
				}
			}

			String sql = "select * from student";
			// 执行SQL语句并返回结果集
			ResultSet rs = statement.executeQuery(sql);

			// 关闭结果集
			rs.close();
			// 关闭连接
			connection.close();
		} catch(ClassNotFoundException e) {
			System.out.println("Sorry,can`t find the Driver!");
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
