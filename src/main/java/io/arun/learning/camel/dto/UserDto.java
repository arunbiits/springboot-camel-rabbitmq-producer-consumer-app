package io.arun.learning.camel.dto;

import java.time.LocalDateTime;

import io.arun.learning.camel.model.User;

public class UserDto {
	private LocalDateTime receivedAt;
	private User user;

	public UserDto() {
		// TODO Auto-generated constructor stub
	}
	
	public UserDto(LocalDateTime receivedAt, User user) {
		super();
		this.receivedAt = receivedAt;
		this.user = user;
	}

	public LocalDateTime getReceivedAt() {
		return receivedAt;
	}

	public void setReceivedAt(LocalDateTime receivedAt) {
		this.receivedAt = receivedAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
