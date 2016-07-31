package xinxilei;

import java.io.Serializable;

public class Booktype implements Serializable{
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String typename;
	private int id;
}
