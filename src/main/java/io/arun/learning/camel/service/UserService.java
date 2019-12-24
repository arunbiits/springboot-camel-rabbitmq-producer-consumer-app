/**
 * 
 */
package io.arun.learning.camel.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import io.arun.learning.camel.dto.UserDto;
import io.arun.learning.camel.model.User;

/**
 * @author arun
 *
 */
public class UserService {
	
	public static List<UserDto> users = new ArrayList<UserDto>();
	
	public void addUser(User user) {
		users.add(new UserDto(LocalDateTime.now(), user));
		System.out.println("Received User:" + user);
	}
	
	public static List<UserDto> getUsers(){
		return users;
	}
	
}
