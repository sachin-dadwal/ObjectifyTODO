package model;

import java.io.Serializable;
import java.util.Date;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Activity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	@Index	
	private String email;
	@Index
	private Date date;
	
	@Index
	private long date1;
	@Index
	private long date2;
	@Index
	private long date3;
	
	public Activity() {}
	
	
	
	public Activity(String id, String email, Date date, Long date1, Long date2, Long date3) {
		super();
		this.id = id;
		this.email = email;
		this.date = date;
		this.date1 = date1;
		this.date2 = date2;
		this.date3 = date3;
	}



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public long getDate1() {
		return date1;
	}
	public void setDate1(long date1) {
		this.date1 = date1;
	}
	public long getDate2() {
		return date2;
	}
	public void setDate2(long date2) {
		this.date2 = date2;
	}
	public long getDate3() {
		return date3;
	}
	public void setDate3(long date3) {
		this.date3 = date3;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
