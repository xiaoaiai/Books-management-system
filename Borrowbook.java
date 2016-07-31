package xinxilei;

import java.io.Serializable;

public class Borrowbook implements Serializable{
	private String borrower;
	private String bookname;
	private String borrowdate;
	private String returntime;
	private int borrowedday;
	public String getBorrower() {
		return borrower;
	}
	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getBorrowdate() {
		return borrowdate;
	}
	public void setBorrowdate(String borrowdate) {
		this.borrowdate = borrowdate;
	}
	public String getReturntime() {
		return returntime;
	}
	public void setReturntime(String returntime) {
		this.returntime = returntime;
	}
	public int getBorrowedday() {
		return borrowedday;
	}
	public void setBorrowedday(int borrowedday) {
		this.borrowedday = borrowedday;
	}
}
