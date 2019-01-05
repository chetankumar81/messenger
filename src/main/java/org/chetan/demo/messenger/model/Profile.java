package org.chetan.demo.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Profile {
	private Long id;
	private String profileName;
	private String firsttName;
	private String lastName;
	private Date created;
	public Profile() {
	}
	
	public Profile(Long id,String profileName, String firsttName, String lastName) {
		this.id	= id;
		this.profileName = profileName;
		this.firsttName = firsttName;
		this.lastName = lastName;
		this.created = new Date();
	}
	
	public Date getCreated() {
		return created;
	}


	public String getFirsttName() {
		return firsttName;
	}

	public Long getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public void setFirsttName(String firsttName) {
		this.firsttName = firsttName;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	
	
}
