package org.chetan.demo.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	private Long id;
	private String message;
	private Date created;
	private String author;
	
	public Message() {
	}

	public Message(Long id, String message, String author) {
		this.id = id;
		this.message = message;
		this.created = new Date();
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}
	
	public Date getCreated() {
		return created;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getMessage() {
		return message;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setCreated(Date created) {
		this.created = created;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
