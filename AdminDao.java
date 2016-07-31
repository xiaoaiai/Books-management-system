package jdbc;

import java.sql.*;
import java.util.*;

import xinxilei.Admin;

public class AdminDao extends BaseDao{
    public int saveinsert(Admin ad) throws Exception{
    	String sql="insert into admin values('"+ad.getName()+"','"+ad.getPassword()+"')";
    	Connection conn=this.initConnection();
    	int count=this.executeupdate(conn, sql);
    	return count;
    }
    
    public int savedelete(Admin ad) throws Exception{
    	String sql="delete from admin where name='"+ad.getName()+"'";
    	Connection conn=this.initConnection();
    	int count=this.executeupdate(conn, sql);
    	return count;
    }
    
    public int saveupdate(Admin ad,String name) throws Exception{
    	String sql="update admin set name='"+ad.getName()+"',password='"+ad.getPassword()+"' where name='"+name+"'";
    	Connection conn=this.initConnection();
    	int count=this.executeupdate(conn, sql);
    	return count;
    }
    
    public List<Admin> select() throws Exception{
    	String sql="select * from admin";
    	Connection conn=this.initConnection();
    	ResultSet rs=this.executeQuery(conn, sql);
    	List<Admin> li=new ArrayList<Admin>();
    	while(rs.next()){
    		Admin ad=new Admin();
    		ad.setName(rs.getString(1));
    		ad.setPassword(rs.getString(2));
    		li.add(ad);
    	}
    	return li;
    }
    
//    public void select1(int id) throws Exception{
//    	String sql="select password from admin where id="+id;
//    	Connection conn=this.initConnection();
//    	ResultSet rs=this.executeQuery(conn, sql);
//    	while(rs.next()){
//    		System.out.print(rs.getInt(1)+"\t");
//    		System.out.print(rs.getString(2)+"\t");
//    		System.out.print(rs.getString(password));
//    	}
//    }
}
