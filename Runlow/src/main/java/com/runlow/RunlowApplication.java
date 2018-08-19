package com.runlow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.runlow.property.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
	FileStorageProperties.class
})
public class RunlowApplication {

	public static void main(String[] args) {
		SpringApplication.run(RunlowApplication.class, args);
	}
}
