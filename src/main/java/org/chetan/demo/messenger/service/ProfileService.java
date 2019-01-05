package org.chetan.demo.messenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.chetan.demo.messenger.database.DatabaseClass;
import org.chetan.demo.messenger.model.Profile;

public class ProfileService {
	Map<Long, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put(1L, new Profile(1L,"Chetan", "Chetan", "Kumar"));
		profiles.put(2L, new Profile(2L,"Harsh","Harsh","Kumar"));
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<>(profiles.values());
	}
	
	public Profile getProfile(Long id) {
		return profiles.get(id);
	}
	
	public Profile setProfile(Profile profile) {
		Long id = (long) (profiles.size()+1);
		profile.setId(id);
		profiles.put(profile.getId(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if(profile.getId() <= 0)
			return null;
		profile.setCreated(new Date());
		profiles.put(profile.getId(), profile);
		return profile;
	}
	
	public Profile deleteProfile(Long id) {
		return profiles.remove(id);
	}
}
