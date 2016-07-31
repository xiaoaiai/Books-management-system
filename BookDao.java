package jdbc;

import java.sql.*;
import java.util.*;
import xinxilei.Book;

public class BookDao extends BaseDao{
    public int saveinsert(Book b) throws Exception{
    	String sql="insert into book values('"+b.getIsbn()+"',"+b.getTypeid()+",'"+b.getBookname()+"','"+b.getWriter()+"','"+b.getTranslater()+"','"+b.getPublisher()+"','"+b.getPublishdate()+"',"+b.getPrice()+","+b.getState()+")";
    	Connection conn=this.initConnection();
    	int count=this.executeupdate(conn, sql);
    	return count;
    }
    
    public ResultSet savefind(String name) throws Exception{
    	String sql="select * from book where bookname='"+name+"'";
    	Connection conn=this.initConnection();
    	ResultSet rs=this.executeQuery(conn, sql);
    	return rs;
    }
    public int saveupdate(Book b,String name) throws Exception{
    	Connection conn=this.initConnection();
    	String sql="update book set isbn='"+b.getIsbn()+"',typeid="+b.getTypeid()+",bookname='"+b.getBookname()+"',writer='"+b.getWriter()+"',translater='"+b.getTranslater()+"',publisher='"+b.getPublisher()+"',publishdate='"+b.getPublishdate()+"',price="+b.getPrice()+",state="+b.getState()+" where bookname='"+name+"'";
    	int count=this.executeupdate(conn, sql);
    	return count;
    }
    
    public int savemodify(Book b,String name) throws Exception{
    	Connection conn=this.initConnection();
    	String sql="update book set state="+b.getState()+" where bookname='"+name+"'";
    	int count=this.executeupdate(conn, sql);
    	return count;
    }
    
    public int updatename(String name1,String name) throws Exception{
    	Connection conn=this.initConnection();
    	String sql="update book set bookname='"+name1+"' where bookname='"+name+"'";
    	int count=this.executeupdate(conn, sql);
    	return count;
    }
    
    public int updatetypeid(int type,String name) throws Exception{
    	Connection conn=this.initConnection();
    	String sql="update book set typeid="+type+" where bookname='"+name+"'";
    	int count=this.executeupdate(conn, sql);
    	return count;
    }
    
    public int updateprice(double price,String name) throws Exception{
    	Connection conn=this.initConnection();
    	String sql="update book set price="+price+" where bookname='"+name+"'";
    	int count=this.executeupdate(conn, sql);
    	return count;
    }
    
    public int updateisbn(String isbn,String name) throws Exception{
    	Connection conn=this.initConnection();
    	String sql="update book set isbn='"+isbn+"' where bookname='"+name+"'";
    	int count=this.executeupdate(conn, sql);
    	return count;
    }
    
    public int savedelete(Book b) throws Exception{
    	Connection conn=this.initConnection();
    	String sql="delete from book where isbn='"+b.getIsbn()+"'";
    	int count=this.executeupdate(conn, sql);
    	return count;
    }
    
    public List<Book> select() throws Exception{
    	String sql="select * from book";
    	Connection conn=this.initConnection();
    	ResultSet rs=this.executeQuery(conn, sql);
    	List<Book> li=new ArrayList<Book>();
    	while(rs.next()){
    		Book b=new Book();
    		b.setIsbn(rs.getString(1));
    		b.setTypeid(rs.getInt(2));
    		b.setBookname(rs.getString(3));
    		b.setWriter(rs.getString(4));
    		b.setTranslater(rs.getString(5));
    		b.setPublisher(rs.getString(6));
    		b.setPublishdate(rs.getString(7));
    		b.setPrice(rs.getInt(8));
    		b.setState(rs.getInt(9));
    		li.add(b);
    	}
    	return li;
    }
}
