package net.codejava.hibernate;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "fee_slip")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "[regNo]")
	private int Student_id;
	
	@Column(name = "[firstName]")
	private String first_name;
	
	@Column(name = "[SecName]")
	private String last_name;
	
	@Column(name = "[studPass]")
	@Transient
	private String pass;
	
	@Column(name = "[fee_month]")
	private String fmonth;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "[current_date]")
	private java.util.Date cdate;


	
	public Student(int student_id, String first_name, String last_name,String pass,String fmonth, java.util.Date cdate) {
		super();
		Student_id = student_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.pass = pass;
		this.fmonth = fmonth;
		this.cdate = cdate;
	}



	@Override
	public String toString() {
		return "Student [Student_id=" + Student_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", pass=" + pass + ", fmonth=" + fmonth + ", cdate=" + cdate + "]";
	}



	public Student()
	{
		
	}



	public int getStudent_id() {
		return Student_id;
	}



	public void setStudent_id(int student_id) {
		Student_id = student_id;
	}



	public String getFirst_name() {
		return first_name;
	}



	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}



	public String getLast_name() {
		return last_name;
	}



	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}



	public String getPass() {
		return pass;
	}



	public void setPass(String pass) {
		this.pass = pass;
	}



	public String getFmonth() {
		return fmonth;
	}



	public void setFmonth(String fmonth) {
		this.fmonth = fmonth;
	}



	public Date getCdate() {
		return cdate;
	}



	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	
}

