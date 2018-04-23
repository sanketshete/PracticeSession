package test.database;

import java.util.HashMap;
import java.util.Map;
import test.messages.*;
import test.messageModel.*;
public class Database {

private static Map<Long,Message> messages=new HashMap<>();
private static Map<String,profile> profiles=new HashMap<>();

public static Map<Long,Message> getMessage(){
	return messages;
	
}

public static Map<String,profile> getProfile(){
	return profiles;
	
}

}
