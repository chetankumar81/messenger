package org.chetan.demo.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.chetan.demo.messenger.database.DatabaseClass;
import org.chetan.demo.messenger.model.Message;

public class MessageService {
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService() {
		messages.put(1L, new Message(1L,"Hello World","Chetan"));
		messages.put(2L, new Message(2L,"Second Message","Chetan"));
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<>(messages.values());
	}
	
	public List<Message> getAllMessagesForYear(int year){
		List<Message> messagesForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for(Message message : messages.values()) {
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR)==year)
				messagesForYear.add(message);
		}
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size){
		ArrayList<Message> messagesPaginated = new ArrayList<Message>(messages.values());
		if(start + size > messages.size()) 
			return new ArrayList<Message>();
		return messagesPaginated.subList(start, size);
	}
	
	public Message addMessage(Message message){
		message.setId((long) (messages.size() + 1));
		message.setCreated(new Date());
		messages.put(message.getId(),message);
		return message;
	}
	
	public Message getMessage(Long messageId) {
		return messages.get(messageId);
	}
	
	public Message updateMessage(Message message) {
		if(message.getId() <= 0) {
			return null;
		}
		message.setCreated(new Date());
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message deleteMessage(long id) {
		return messages.remove(id);
	}
}
