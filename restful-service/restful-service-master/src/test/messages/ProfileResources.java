package test.messages;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.persistence.tools.profiler.Profile;

import test.messageModel.Message;
import test.messageModel.profile;
import test.service.MessageService;
import test.service.ProfileService;

@Path("/profiles")
public class ProfileResources {

	ProfileService profileService= new ProfileService();
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<profile> getProfiles(){
		return profileService.getAllprofiles();
	}

	@GET
	@Path("/{profilename}")
	@Produces(MediaType.APPLICATION_JSON)
	public profile getProfile(@PathParam("profilename") String pname){
		return profileService.getprofile(pname);
		
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public profile Addprofile(profile profile){
		return profileService.addprofile(profile);		
	}
	
	@PUT
	@Path("/{profilename}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public profile updateProfile(profile profile1,@PathParam("profilename") String profile){
		profile1.setProfileName(profile);
		return profileService.updateprofile(profile1);		
	}
	
	@DELETE
	@Path("/{profileName}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteProfile(@PathParam("profilename") String profilename){
		profileService.removeprofile(profilename)	;
	}

}
