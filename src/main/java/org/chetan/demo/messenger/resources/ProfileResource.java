package org.chetan.demo.messenger.resources;

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

import org.chetan.demo.messenger.model.Profile;
import org.chetan.demo.messenger.service.ProfileService;

@Path("/profiles")
public class ProfileResource {
	ProfileService profileService = new ProfileService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getAllProfiles(){
		return profileService.getAllProfiles();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{profileId}")
	public Profile getProfile(@PathParam("profileId") Long id) {
		return profileService.getProfile(id);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Profile addProfile(Profile profile) {
		return profileService.setProfile(profile);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{profileId}")
	public Profile updateProfile(@PathParam("profileId") Long id, Profile profile) {
		profile.setId(id);
		return profileService.updateProfile(profile);
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{profileId}")
	public Profile deleteProfile(@PathParam("profileId") Long id) {
		return profileService.deleteProfile(id);
	}
	
}
