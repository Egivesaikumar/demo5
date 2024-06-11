package com.example.Task04;

import org.springframework.boot.SpringApplication;

public class TestTask04Application {

	public static void main(String[] args) {
		SpringApplication.from(Task04Application::main).with(TestcontainersConfiguration.class).run(args);
	}

}
