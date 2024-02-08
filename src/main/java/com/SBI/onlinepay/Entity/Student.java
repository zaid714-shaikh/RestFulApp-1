package com.SBI.onlinepay.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	private int sid;

	private String sname;

	private String sschoolname;

	private String saddress;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSschoolname() {
		return sschoolname;
	}

	public void setSschoolname(String sschoolname) {
		this.sschoolname = sschoolname;
	}

	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sschoolname=" + sschoolname + ", saddress=" + saddress
				+ "]";
	}

}
