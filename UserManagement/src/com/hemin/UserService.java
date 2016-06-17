package com.hemin;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/UserService")
public class UserService {
	UserDAO userdao = new UserDAO();
	private static final String RESULT_SUCCESS="<result>success</result>";
	private static final String RESULT_FAILURE="<result>failure</result>";
	
	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_XML)
	public List<User> getUsers(){
		return userdao.getAllUsers();
	}
	
	@GET
	@Path("/users/{userid}")
	@Produces(MediaType.APPLICATION_XML)
	public User getUser(@PathParam("userid") int userid){
		return userdao.getUser(userid);
	}
	
	@PUT
	@Path("/users")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String createUser(@FormParam("id") int id, 
			@FormParam("name") String name, 
			@FormParam("profession") String profession, 
			@Context HttpServletResponse servletResponse) throws IOException{
		
		User user = new User(id, name, profession);
		int result = userdao.addUser(user);
		if(result == 1)
			return RESULT_SUCCESS;
		return RESULT_FAILURE;
	}
	
	@POST
	@Path("/users")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String updateUser(@FormParam("id") int id, 
			@FormParam("name") String name,
			@FormParam("profession") String profession,
			@Context HttpServletResponse servletResponse) throws IOException{
		User user = new User(id, name, profession);
		int result = userdao.updateUser(user);
		if(result == 1)
			return RESULT_SUCCESS;
		return RESULT_FAILURE;
	}
	
	@DELETE
	@Path("/users/{userid}")
	@Produces(MediaType.APPLICATION_XML)
	public String deleteUser(@PathParam("userid") int userid){
		int result = userdao.deleteUser(userid);
		if(result == 1)
			return RESULT_SUCCESS;
		return RESULT_FAILURE;
	}
	
	@OPTIONS
	@Path("/users")
	@Produces(MediaType.APPLICATION_XML)
	public String getSupportedOperations(){
		return "<operations>GET, PUT, POST, DELETE</operations>";
	}
}
