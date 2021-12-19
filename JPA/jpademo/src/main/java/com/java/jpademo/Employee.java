package com.java.jpademo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	private int id;
	private fullname name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public fullname getName() {
		return name;
	}

	public void setName(fullname name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", Salary=" + Salary + "]";
	}

	public int getSalary() {
		return Salary;
	}

	public void setSalary(int salary) {
		Salary = salary;
	}

	private int Salary;

}
