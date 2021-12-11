package com.jdc.online.jpa.entity;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Entity implementation class for Entity: Student
 *
 */
@Entity
@Table(name = "student_tbl")
@SecondaryTables({
	@SecondaryTable(name = "email_tbl"),
	@SecondaryTable(name = "phone_tbl")
})
public class Student implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "student_seq")
	@SequenceGenerator(name = "student_seq")
	private int id;
	private String name;
	@Column(table = "phone_tbl")
	private String phone;
	@Column(table = "email_tbl")
	private String email;
	private static final long serialVersionUID = 1L;

	public Student() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
   
}
