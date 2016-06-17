package com.hemin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	
	//method to get all the users.
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers(){
		List<User> userList = null;
		try{
			File file = new File("users.dat");
			
			if(!file.exists()){
				User user = new User(1, "Hemin", "Developer");
				userList = new ArrayList<User>();
				userList.add(user);
				saveUserList(userList);
			}
			else{
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				userList = (List<User>)ois.readObject();
				ois.close();
			}
		} catch (IOException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		return userList;
	}
	
	//method to get 1 user according to the id.
	public User getUser(int id){
		List<User> users = getAllUsers();
		for(User user : users){
			if(user.getId() == id)
				return user;
		}
		return null;
	}
	
	//method to add user if not their in the list according to the id.
	public int addUser(User pUser){
		List<User> userList = getAllUsers();
		boolean userExists = false;
		for(User user: userList){
			if(user.getId() == pUser.getId()){
				userExists = true;
				break;
			}
		}
		if(!userExists){
			userList.add(pUser);
			saveUserList(userList);
			return 1;
		}
		return 0;
	}
	
	//method to update the user.
	public int updateUser(User pUser){
		List<User> userList = getAllUsers();
		for(User user : userList){
			if(user.getId() == pUser.getId()){
				int index = userList.indexOf(user);
				userList.set(index, pUser);
				saveUserList(userList);
				return 1;
			}
		}
		return 0;
	}
	
	//method to delete user according to the id.
	public int deleteUser(int id){
		List<User> userList = getAllUsers();
		
		for(User user: userList){
			if(user.getId() == id){
				int index = userList.indexOf(user);
				userList.remove(index);
				saveUserList(userList);
				return 1;
			}
		}
		return 0;
	}
	
	//method to save the list after performing the operations.
	private void saveUserList(List<User> userList){
		try {
			File file = new File("users.dat");
			FileOutputStream fos;
			fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(userList);
			oos.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
	}
}
