package test.messages;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import javax.xml.ws.spi.http.HttpHandler;


@Path("/injectDemo")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class injectDemoResource {

	
	@GET
	@Path("annotations")
	public String getparamUsingAnnotation(@MatrixParam("param") String params,
										   @HeaderParam("headerparam") String Headerparams,
										   @CookieParam("name") String cookieValue){
		return "Metrix param is"+params+Headerparams+cookieValue;
	}
	
	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo uriinfo,@Context HttpHeaders headers){
		
		String path=uriinfo.getAbsolutePath().toString();
		String header=headers.getCookies().toString();
		return path + header;
		
	}
}
