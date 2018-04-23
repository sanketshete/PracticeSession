package test;

import javax.ws.rs.GET;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class Hello {

	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayHello(){
		String resources="<?xml version='1.0'?>"+
			"<hello> Hi sanket How r u from XML</hello>";
		return resources;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHelloJSON(){
		String resources=null;
		return resources;
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHelloHTTML(){
		String resources="<h1> hi sanket ,HElloo from HTML</h1>";
		return resources;
	}


}
