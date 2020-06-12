package user.model;

import java.sql.Timestamp;


public class UserVO {
	private String id;
	private String pw;
	private String name;
	private String email;
	private String email2;
	private String hp;
	private String hp2;
	private String hp3;
	private String address;
	private String address2;
	private Timestamp regdate;
	
	
	public UserVO() {
		// TODO Auto-generated constructor stub
	}


	public UserVO(String id, String pw, String name, String email, String email2, String hp, String hp2, String hp3,
			String address, String address2, Timestamp regdate) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.email2 = email2;
		this.hp = hp;
		this.hp2 = hp2;
		this.hp3 = hp3;
		this.address = address;
		this.address2 = address2;
		this.regdate = regdate;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getEmail2() {
		return email2;
	}


	public void setEmail2(String email2) {
		this.email2 = email2;
	}


	public String getHp() {
		return hp;
	}


	public void setHp(String hp) {
		this.hp = hp;
	}


	public String getHp2() {
		return hp2;
	}


	public void setHp2(String hp2) {
		this.hp2 = hp2;
	}


	public String getHp3() {
		return hp3;
	}


	public void setHp3(String hp3) {
		this.hp3 = hp3;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getAddress2() {
		return address2;
	}


	public void setAddress2(String address2) {
		this.address2 = address2;
	}


	public Timestamp getRegdate() {
		return regdate;
	}


	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	
	
}
	
