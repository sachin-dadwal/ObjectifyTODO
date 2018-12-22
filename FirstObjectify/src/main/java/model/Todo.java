package model;

import java.io.Serializable;
import java.util.Date;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Todo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	@Index
	private String email;
	@Index
	private String Text;

	@Index
	private Boolean Done;
	@Index
	private Date date;

	public Todo() {

	}

	public Todo(String id, String email, String text, Boolean done, Date date) {
		super();
		this.id = id;

		this.email = email;
		this.Text = text;
		this.Done = done;
		this.date = date;
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

	public String getText() {
		return Text;
	}

	public void setText(String text) {
		Text = text;
	}

	public Boolean getDone() {
		return Done;
	}

	public void setDone(Boolean done) {
		Done = done;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
