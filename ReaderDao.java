package jdbc;

import java.sql.*;
import java.util.*;
import xinxilei.Reader;

public class ReaderDao extends BaseDao{
	 
	public int saveinsert(Reader r) throws Exception{
	    String sql="insert into reader values("+r.getId()+",'"+r.getName()+"','"+r.getSex()+"',"+r.getAge()+",'"+r.getIdentitycard()+"','"+r.getNowdate()+"',"+r.getMaxnum()+",'"+r.getTel()+"',"+r.getKeepmoney()+","+r.getZj()+",'"+r.getZy()+"','"+r.getBztime()+"','"+r.getPassword()+"')";
	   	Connection conn=this.initConnection();
	   	int count=this.executeupdate(conn, sql);
	   	return count;
     }
	 
	 
	 public List<Reader> select() throws Exception{
		 String sql="select * from reader";
		 List<Reader> li=new ArrayList<Reader>();
		 Connection conn=this.initConnection();
		 ResultSet rs=this.executeQuery(conn, sql);
		 while(rs.next()){
			 Reader r=new Reader();
			 r.setId(rs.getInt(1));
			 r.setName(rs.getString(2));
			 r.setSex(rs.getString(3));
			 r.setAge(rs.getInt(4));
			 r.setIdentitycard(rs.getString(5));
			 r.setNowdate(rs.getString(6));
			 r.setMaxnum(rs.getInt(7));
			 r.setTel(rs.getString(8));
			 r.setKeepmoney(rs.getInt(9));
			 r.setZj(rs.getInt(10));
			 r.setZy(rs.getString(11));
			 r.setBztime(rs.getString(12));
			 r.setPassword(rs.getString(13));
			 li.add(r);
		 }
		 return li;
	 }
}
