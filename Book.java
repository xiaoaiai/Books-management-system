package xinxilei;

import java.io.Serializable;

public class Book implements Serializable{
	private String isbn;                          
	private int typeid;                         
	private String bookname;                         
	private String writer;                       
	private String translater;                         
	private String publisher;                        
	private String publishdate;                         
	private double price;
	private int state;
	
	public String toString(Book b){
		String str=null;
		if(b.getState()==1){
			str="《"+b.getBookname()+"》"+"已借出！";
		}else{
			str="《"+b.getBookname()+"》"+"未被借出，可以进行借阅！";
		}
		return str;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTranslater() {
		return translater;
	}
	public void setTranslater(String translater) {
		this.translater = translater;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublishdate() {
		return publishdate;
	}
	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
