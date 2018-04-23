package test.messages;
import test.service.*;

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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import test.messageModel.*;
import test.messages.beans.MessageFilterBean;

@Path("/messages")
public class MessageResources {

	MessageService messageService= new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@QueryParam("year") int year,@QueryParam("start") int start,@QueryParam("size") int size
			//,@BeanParam MessageFilterBean filterBean
			){
		
		if(year>0 ){//filterBean.getYear();
			return messageService.getAllMessagesbyYear(year);			
		}if(start>0 && size>0){
			return messageService.getAllMessagesbypagination(start, size);
		}
		
		return messageService.getAllMessages();
	}

	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long id){
		return messageService.getMessage(id);
		
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message){
		//sending status
		/*Message newMessage=messageService.addMessage(message);
		return Response.status(Status.CREATED)
				.entity(newMessage)
				.build();*/
		return messageService.addMessage(message);		
	}
	
	@PUT
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message updateMessage(Message message,@PathParam("messageId") long id){
		message.setId(id);
		return messageService.updateMessage(message);		
	}
	
	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageId") long id){
		messageService.removeMessage(id)	;
	}

	@Path("/{messageId}/comments")
	public CommentsResourses getCommentsResources(){
		
		return new CommentsResourses();
	}
	
}
