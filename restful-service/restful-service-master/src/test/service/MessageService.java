package test.service;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import test.database.Database;
import test.messageModel.*;
public class MessageService {

private Map<Long,Message> messages= Database.getMessage();

	public MessageService(){
		messages.put(1L, new Message(1,"hello","sanket"));
		messages.put(2L, new Message(2,"hello","vishal"));
		
	}
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values()); 
		
	}
	
	public List<Message> getAllMessagesbyYear(int year){
	
		List<Message> list= new ArrayList<Message>();
		Calendar cal= Calendar.getInstance();
		for(Message message:messages.values()){
			cal.setTime(message.getCraeted());
			if(cal.get(Calendar.YEAR)==year){
				list.add(message);
			}
			
		}
		return list; 
		
	}

	public List<Message> getAllMessagesbypagination(int start,int size){

		ArrayList<Message> list= new ArrayList<Message>(messages.values());
		if(start+size>list.size()){
			return new ArrayList<Message>();
		}
		return list.subList(start, start+size); 
		
	}

	public Message getMessage(long id){
		
		return messages.get(id); 
	}
	
	public Message addMessage(Message message){
		
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message){

		if(message.getId()<=0){
			return null;
		}
		messages.put(message.getId(), message);
		return message;
		
		
	}
	
	public Message removeMessage(long id){
		return messages.remove(id);
		
	}

}
