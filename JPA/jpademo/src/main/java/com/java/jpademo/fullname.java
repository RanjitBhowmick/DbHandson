package com.java.jpademo;

import javax.persistence.Embeddable;

@Embeddable
public class fullname {

	@Override
	public String toString() {
		return "fullname [firstname=" + firstname + ", middlename=" + middlename + ", lastname=" + lastname + "]";
	}

	private String firstname;
	private String middlename;
	private String lastname;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
