package jdbc;

import java.sql.*;
import java.util.*;
import xinxilei.Booktype;

public class BookTypeDao extends BaseDao{
	 public int saveinsert(Booktype bt) throws Exception{
	    String sql="insert into booktype values('"+bt.getTypename()+"',"+bt.getId()+")";
	    Connection conn=this.initConnection();
	    int count=this.executeupdate(conn, sql);
	    return count;
	 }
	 
	 public int saveupdate(Booktype bt,int id) throws Exception{
		 String sql="update booktype set typename='"+bt.getTypename()+"',id="+bt.getId()+" where id="+id+"";
		 Connection conn=this.initConnection();
		 int count=this.executeupdate(conn, sql);
		 return count;
	 }
	 
	 public int savedelete(Booktype bt) throws Exception{
		 String sql="delete from booktype where id="+bt.getId()+"";
		 Connection conn=this.initConnection();
		 int count=this.executeupdate(conn, sql);
		 return count;
	 }
	 
	 public List<Booktype> select() throws Exception{
		 List<Booktype> li=new ArrayList<Booktype>();
		 String sql="select * from booktype";
		 Connection conn=this.initConnection();
		 ResultSet rs=this.executeQuery(conn, sql);
		 while(rs.next()){
			 Booktype bt=new Booktype();
			 bt.setTypename(rs.getString(1));
			 bt.setId(rs.getInt(2));
			 li.add(bt);
		 }
		 return li;
	 }
}
