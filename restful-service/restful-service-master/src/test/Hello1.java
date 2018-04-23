package test;

import javax.ws.rs.GET;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/hello1")
public class Hello1 {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHelloHTTML(@QueryParam("name") String name,@QueryParam("card_no") String card_no,@QueryParam("ammount") int ammount){
		String resources;		
		if(ammount>10000){
			resources="credit card is not approved";
			
		}else{
			resources="credit card is approved";
		}

		return "<html>"+"<title>"+"cerdit card autorization of "+name+"</title>"+"<body>"+
		"<h1>"+resources+"</h1></body>"+"</html>";
	}


}
