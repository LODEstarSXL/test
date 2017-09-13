package cn.ucai.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.ucai.bean.User;

public class Test {
	public static void main(String[] args) {
		List<User> list=getAll();
		for(User u:list){
			System.out.println(u);
		}
	}
	
	
	public static List<User> getAll(){
		List<User> list=new ArrayList<User>();
		//��������
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?user=root&password=root");
				System.out.println(conn);
				//�õ��������ݿ����Ķ���
				Statement st = conn.createStatement();
				//�������ݿ⣬�õ������
				ResultSet rs = st.executeQuery("select * from user1");
				while (rs.next()){
					int id=rs.getInt("id");
					String username=rs.getString("username");
					String password=rs.getString("password");
					System.out.println("id:"+id+"  user:"+username+"  password:"+password);
					//����ʵ�������
					User user=new User(id,username,password);
					//��ʵ���������ӽ�����
					list.add(user);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
}
