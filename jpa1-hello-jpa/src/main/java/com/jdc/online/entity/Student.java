package com.jdc.online.entity;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.GenerationType.SEQUENCE;
import static javax.persistence.GenerationType.TABLE;
import static javax.persistence.EnumType.STRING;

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
@SequenceGenerator(name = "student_seq")
public class Student implements Serializable {
	
	public enum Gender {Male, Female}

	@Id
	@GeneratedValue(strategy =SEQUENCE, generator = "student_seq" )
	private Integer id;
	@Temporal(TemporalType.DATE)
	@Column(nullable = true)
	private Date dateOfBirth;
	@Enumerated(value = STRING)
	@Column(length = 10)
	private Gender gender;
	@Basic(optional = false)
	private String name;
	private String phone;
	private String email;
	
	@Embedded
	private SecurityInfo securityInfo;
	
	@Transient
	private boolean selected;
	
	private static final long serialVersionUID = 1L;

	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public SecurityInfo getSecurityInfo() {
		return securityInfo;
	}
	public void setSecurityInfo(SecurityInfo securityInfo) {
		this.securityInfo = securityInfo;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Student() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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
