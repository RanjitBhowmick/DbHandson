package com.java.jpademo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

//@Entity(name="Student_Table")   //to name the entity with different name apart from class name. this will effect table name.
//@Table(name="Studnet_table")	//to name the table with different name

@Entity
public class Student {

	@Id
	private int aid;
	// @Transient //to avoid making column in table
	// @Column(name="Aname") //to rename the column name in table
	private String aname;

	@Override
	public String toString() {
		return "Student [aid=" + aid + ", aname=" + aname + ", acolor=" + acolor + "]";
	}

	private String acolor;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getAcolor() {
		return acolor;
	}

	public void setAcolor(String acolor) {
		this.acolor = acolor;
	}

}
