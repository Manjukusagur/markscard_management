package dto;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.crypto.Data;
@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String Name;
	@Column(unique = true)
	String Email;
	@Column(unique = true)
	long Mobile ;
	String Password;
	Date DOB;
	int age;
	String Classs;
	
	
	@OneToMany
	List<MarksCard> marksCards;
	
	
	public List<MarksCard> getMarksCards() {
		return marksCards;
	}
	public void setMarksCards(List<MarksCard> marksCards) {
		this.marksCards = marksCards;
	}
	
	
	
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date date3) {
		DOB = date3;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getClasss() {
		return Classs;
	}
	public void setClasss(String classs) {
		Classs = classs;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public long getMobile() {
		return Mobile;
	}
	public void setMobile(long mobile) {
		Mobile = mobile;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	

	public String getClas() {
		return Classs;
	}
	public void setClass(String classs) {
		Classs = classs;
	}

}
