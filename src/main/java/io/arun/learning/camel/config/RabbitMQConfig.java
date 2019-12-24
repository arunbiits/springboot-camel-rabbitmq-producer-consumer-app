/**
 * 
 */
package io.arun.learning.camel.config;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.stereotype.Component;


import io.arun.learning.camel.model.User;

/**
 * @author arun
 *
 */
@Component
public class RabbitMQConfig extends RouteBuilder{

	JacksonDataFormat jacksonDataFormat = new JacksonDataFormat(User.class);
	
	@Override
	public void configure() throws Exception {
		
		//Old URI
		
//		from("direct:rabbitMQStart").id("rabbitRoute").marshal(jacksonDataFormat)
//			.to("rabbitmq://localhost:5672/TEST-QUEUE.exchange?queue=javainuse.queue&autoDelete=false&routingKey=my-routing-key").end();
//		
//		from("rabbitmq://localhost:5672/TEST-QUEUE.exchange?queue=javainuse.queue&autoDelete=false&routingKey=myRoute1").unmarshal(jacksonDataFormat)
//			.to("bean:io.arun.learning.camel.service.UserService?method=addUser");
		
		//New URI
		from("direct:rabbitMQStart").id("rabbitRoute").marshal(jacksonDataFormat)
			.to("rabbitmq:TEST-QUEUE.exchange?autoDelete=false&routingKey=my-routing-key");
		
		from("rabbitmq:TEST-QUEUE.exchange?queue=javainuse.queue&autoDelete=false&routingKey=my-routing-key").unmarshal(jacksonDataFormat)
			.to("bean:io.arun.learning.camel.service.UserService?method=addUser");
	
	}

}

