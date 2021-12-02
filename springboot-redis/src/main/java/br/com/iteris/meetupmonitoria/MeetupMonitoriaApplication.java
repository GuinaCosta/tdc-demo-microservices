package br.com.iteris.meetupmonitoria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MeetupMonitoriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeetupMonitoriaApplication.class, args);
	}

}
