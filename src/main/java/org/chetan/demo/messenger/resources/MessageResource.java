package org.chetan.demo.messenger.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.chetan.demo.messenger.model.Message;
import org.chetan.demo.messenger.resources.beans.MessageFilterBeans;
import org.chetan.demo.messenger.service.MessageService;


@Path("/messages")
public class MessageResource {
	
	MessageService messageService = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@BeanParam MessageFilterBeans messageFilter) {
		if(messageFilter.getYear()> 0) {
			return messageService.getAllMessagesForYear(messageFilter.getYear());
		}
		if(messageFilter.getStart() >= 0 && messageFilter.getSize() > 0) {
			return messageService.getAllMessagesPaginated(messageFilter.getStart(), messageFilter.getSize());
		}
		return messageService.getAllMessages();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") Long messageId) {
		return messageService.getMessage(messageId);
	}
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message) {
		return messageService.addMessage(message);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id, Message message) {
		message.setId(id);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{messageId}")
	public Message deleteMessage(@PathParam("messageId") long id) {
		return messageService.deleteMessage(id);
	}
}
