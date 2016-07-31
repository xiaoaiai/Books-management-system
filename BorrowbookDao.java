package jdbc;

import java.sql.*;
import java.util.*;

import xinxilei.Borrowbook;

public class BorrowbookDao extends BaseDao{
	public List<Borrowbook> select() throws Exception{
		Connection conn=this.initConnection();
		String sql="select * from borrowbook";
		List<Borrowbook> li=new ArrayList<Borrowbook>();
		ResultSet rs=this.executeQuery(conn, sql);
		while(rs.next()){
			Borrowbook bk=new Borrowbook();
			bk.setBorrower(rs.getString(1));
			bk.setBookname(rs.getString(2));
			bk.setBorrowdate(rs.getString(3));
			bk.setReturntime(rs.getString(4));
			bk.setBorrowedday(rs.getInt(5));
			li.add(bk);
		}
		return li;
	}
	
	public int saveinsert(Borrowbook bk) throws Exception{
		int count=0;
		String sql="insert into borrowbook values('"+bk.getBorrower()+"','"+bk.getBookname()+"','"+bk.getBorrowdate()+"','"+bk.getReturntime()+"',"+bk.getBorrowedday()+")";
		Connection conn=this.initConnection();
		count=this.executeupdate(conn, sql);
		return count;
	}
	
	public int savedelete(String name) throws Exception{
		int count=0;
		Connection conn=this.initConnection();
		String sql="delete from borrowbook where bookname='"+name+"'";
		count=this.executeupdate(conn, sql);
		return count;
	}
}
