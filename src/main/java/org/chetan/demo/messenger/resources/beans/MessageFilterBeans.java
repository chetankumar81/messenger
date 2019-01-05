package org.chetan.demo.messenger.resources.beans;

import javax.ws.rs.QueryParam;

public class MessageFilterBeans {
	@QueryParam("year") int year;
	@QueryParam("start") int start;
	@QueryParam("size") int size;
	
	public int getSize() {
		return size;
	}
	public int getStart() {
		return start;
	}
	public int getYear() {
		return year;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	
}
