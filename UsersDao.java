package jdbc;

import java.sql.*;
import java.util.*;
import xinxilei.Users;

public class UsersDao extends BaseDao{
	 public int saveinsert(Users u) throws Exception{
	    String sql="insert into users values("+u.getId()+",'"+u.getName()+"','"+u.getSex()+"',"+u.getAge()+",'"+u.getIdentitycard()+"','"+u.getWorkdate()+"','"+u.getTel()+"',"+u.getYajin()+",'"+u.getPassword()+"','"+u.getAdmin()+"')";
	    Connection conn=this.initConnection();
	    int count=this.executeupdate(conn, sql);
	    return count;
	 }
	 
	 public int saveupdate(Users u,String name) throws Exception{
		 String sql="update users set id="+u.getId()+",name='"+u.getName()+"',sex='"+u.getSex()+"',age="+u.getAge()+",identitycard='"+u.getIdentitycard()+"',workdate='"+u.getWorkdate()+"',tel='"+u.getTel()+"',yajin="+u.getYajin()+",password='"+u.getPassword()+"',admin='"+u.getAdmin()+"' where name='"+name+"'";
		 Connection conn=this.initConnection();
		 int count=this.executeupdate(conn, sql);
		 return count;
	 }
	 
	 public int updatename(String name1,String name) throws Exception{
		 String sql="update users set name='"+name1+"' where name='"+name+"'";
		 Connection conn=this.initConnection();
		 int count=this.executeupdate(conn, sql);
		 return count;
	 }
	 
	 public int updateage(int age,String name) throws Exception{
		 String sql="update users set age="+age+" where name='"+name+"'";
		 Connection conn=this.initConnection();
		 int count=this.executeupdate(conn, sql);
		 return count;
	 }
	 
	 public int updatepassword(String pass,String name) throws Exception{
		 String sql="update users set password='"+pass+"' where name='"+name+"'";
		 Connection conn=this.initConnection();
		 int count=this.executeupdate(conn, sql);
		 return count;
	 }
	 
	 public int updateadmin(String admin,String name) throws Exception{
		 String sql="update users set admin='"+admin+"' where name='"+name+"'";
		 Connection conn=this.initConnection();
		 int count=this.executeupdate(conn, sql);
		 return count;
	 }
	 
	 public int savedelete(Users u) throws Exception{
		 String sql="delete from users where name="+u.getName()+"";
		 Connection conn=this.initConnection();
		 int count=this.executeupdate(conn, sql);
		 return count;
	 }
	 
	 public List<Users> select() throws Exception{
		 List<Users> li=new ArrayList<Users>();
	     String sql="select * from users";
	     Connection conn=this.initConnection();
	     ResultSet rs=this.executeQuery(conn, sql);
	     while(rs.next()){
	    	 Users u=new Users();
	    	 u.setId(rs.getInt(1));
	    	 u.setName(rs.getString(2));
	    	 u.setSex(rs.getString(3));
	    	 u.setAge(rs.getInt(4));
	    	 u.setIdentitycard(rs.getString(5));
	    	 u.setWorkdate(rs.getString(6));
	    	 u.setTel(rs.getString(7));
	    	 u.setYajin(rs.getInt(8));
	    	 u.setPassword(rs.getString(9));
	    	 u.setAdmin(rs.getString(10));
	    	 li.add(u);
	     }
	     return li;
	 }
	 
	 public ResultSet findbyname(String name) throws Exception{
		 Connection conn=this.initConnection();
		 String sql="select * from users where name='"+name+"'";
		 ResultSet rs=this.executeQuery(conn, sql);
		 return rs;
	 }
	 
}
