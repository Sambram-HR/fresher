package com.pent.fetchrec;
import java.sql.*;
import java.util.Scanner;
public class Demo {
	public static void main(String[] args) {
		Connection c=null;
		PreparedStatement s=null;
		ResultSet rs=null;
		String sQry="select name,sal from school.ijeeva where id=?";
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the id");
		int id=sc.nextInt();
		//System.out.println("enter the name");
		//String name=sc.next();
		//System.out.println("enter the sal");
		//int sal=sc.nextInt();
		sc.close();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=chikku");
			s=c.prepareStatement(sQry);
			System.out.println("REGISTERED,CONNECTED AND CREATED");
			System.out.println("query pre-compiled");
			s.setInt(1, id);
			//s.setString(2, name);
			System.out.println("i've set the data for placeholder before execution");
			rs=s.executeQuery();
			System.out.println("query executed");
			
			if(rs.next()) {
				//int eid=rs.getInt("id");
				//System.out.println("the id is= " + eid);
				String uname=rs.getString("name");
				System.out.println("the user name= " + uname);
				int esal=rs.getInt("sal");
				System.out.println("salary of employee is= " + esal);
			}else {
				System.out.println("invalid id/name");
			}
		}catch(ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			finally {
				if(rs!=null) {
					try {
						rs.close();
					}catch(SQLException e) {
						e.printStackTrace();
					}
				}
				if(s!=null) {
					try {
						s.close();
					}catch(SQLException e) {
						e.printStackTrace();
					}
				}{
				if(c!=null) {
					try {
						c.close();
					}catch(SQLException e) {
						e.printStackTrace();
					}
				}
			}
			System.out.println("closed all the costly resources");
		}
	}
}
