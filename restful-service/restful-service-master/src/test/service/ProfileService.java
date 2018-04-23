package test.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import test.database.Database;
import test.messageModel.profile;


public class ProfileService {
	private Map<String,profile> profiles= Database.getProfile();

	public ProfileService(){
		profiles.put("sanket", new profile(1,"sanket","sanket","shete"));
		profiles.put("dipak", new profile(1,"dipak","dipak","thoke"));
		
	}
	public List<profile> getAllprofiles(){
		return new ArrayList<profile>(profiles.values()); 
		
	}
	
	public profile getprofile(String profileName){
		
		return profiles.get(profileName); 
	}
	
	public profile addprofile(profile profile){
		
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public profile updateprofile(profile profile){

		if(profile.getProfileName().isEmpty()){
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
		
		
	}
	
	public profile removeprofile(String name){
		return profiles.remove(name);
		
	}

}
