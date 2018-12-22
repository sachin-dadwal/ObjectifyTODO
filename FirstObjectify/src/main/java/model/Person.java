package model;

import java.io.Serializable;


import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Person implements Serializable{
	private static final long serialVersionUID = 1L;

    @Id
    private String id;
 //   private String username; // email
  //  private String password;
    
    @Index
    private String username;// email
    @Index
    private String password;
    
    private String Name;
    private Long phNo;
    
    @Index
    private Boolean active;
    
    @Index
    private long date;
    
    @Index
    private String ip; 
    @Index
    private String country;

    public Person() {
    }

	public Person(String id, String username, String password, String name, Long phNo, Boolean active, long date,
			String ip, String country) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		Name = name;
		this.phNo = phNo;
		this.active = active;
		this.date = date;
		this.ip = ip;
		this.country = country;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Long getPhNo() {
		return phNo;
	}

	public void setPhNo(Long phNo) {
		this.phNo = phNo;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    
	

	
  
}