package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.model.RegisterModel;

public class Admindao {
	Connection con;
    PreparedStatement ps,ps1;
public Admindao() {
	
}
public Connection getConnection()
{
	try {
	String url="jdbc:mysql://localhost:3306/test";
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection(url,"root","redhat");

}
	catch(ClassNotFoundException | SQLException e) 
	{
		e.printStackTrace();
	}
	return con;

}
public int savedata() {
	int i=0;
	int cnt=0;
	con=getConnection();
	try
	{
		 ps=con.prepareStatement("select * from personalDetails where Request='NO'");
		i=ps.executeUpdate();
		
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	if(i>0) {
		cnt=1;
	}
	return cnt;
	
}

public List<RegisterModel> getAllData()
{
	List<RegisterModel> lst=new LinkedList<RegisterModel>();
	con=getConnection();
	try
	{
	Statement s=
				con.createStatement
				(ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
		ResultSet rs=s.executeQuery("select * from admin");
		while(rs.next())
		{
			RegisterModel a=new RegisterModel();
			a.setFname(rs.getString(1));
			a.setMname(rs.getString(2));
			a.setLname(rs.getString(3));
			lst.add(a);
			System.out.println("cnt");
		}
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	return lst;
}
}
