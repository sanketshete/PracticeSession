package test.messages;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class CommentsResourses {

	@GET
	public String test(){
		return "new stub resouces";
	}
	
	@GET
	@Path("/{commentID}")
	public String test1(@PathParam("commentID") long commentID,
						@PathParam("messageId") long messageId){
		return "show comment"+commentID+messageId;
	}

}
