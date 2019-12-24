/**
 * 
 */
package io.arun.learning.camel.controller;

import java.util.List;
import java.util.concurrent.Future;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.arun.learning.camel.dto.UserDto;
import io.arun.learning.camel.model.User;
import io.arun.learning.camel.service.UserService;

/**
 * @author arun
 *
 */
@RestController
public class UserController {

	@Produce(uri = "direct:rabbitMQStart")
	private ProducerTemplate producer;
	
	@PostMapping("/users")
	public String pushUserIntoQueue(@RequestBody User user) {
		//producer.asyncRequestBodyAndHeader(producer.getDefaultEndpoint(), user, "rabbitmq.ROUTING_KEY", "myRoute1");
		Future<Object> status = producer.asyncSendBody(producer.getDefaultEndpoint(), user);
		return String.valueOf(status);
	}
	
	@GetMapping("/users")
	public List<UserDto> getUsersFromQueue() {
		return UserService.getUsers();
	}
	
}
