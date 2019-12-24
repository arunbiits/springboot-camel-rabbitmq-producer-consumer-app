/**
 * 
 */
package io.arun.learning.camel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.rabbitmq.client.ConnectionFactory;

/**
 * @author arun
 * 
 */
@SpringBootApplication
public class ProducerConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerConsumerApplication.class, args);
	}

	//Needed when we use new URI of the Apache Camel...
	@Bean
	public ConnectionFactory connectionFactory() {
		ConnectionFactory con = new ConnectionFactory();
		con.setHost("localhost");
		return con;
	}

}
