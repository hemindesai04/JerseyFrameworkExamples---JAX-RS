package webservices;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import model.SecurityManager;
import pojo.UserInfo;

@Path("/WebService")
public class LoginService {
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String login(@FormParam("username") String username,
	@FormParam("password") String password) { 
		return getAllUsersList(username, password);
	}
	
	public String getAllUsersList(String username,String password){
		try {
			ArrayList<UserInfo> userList = null;
			SecurityManager securityManager= new SecurityManager();
			userList = securityManager.getAllUsersList();
			for (UserInfo userinfo : userList) {
				if(userinfo.getUsername().equals(username)){
					if(userinfo.getPassword().equals(password)){
						return "Logged in User:"+username;
					}
				}
			} 
		} catch (Exception e){
			System.out.println("error");
		}
		return "You are not a Valid User";
	 }
}