package com.revature.app;

import com.revature.runner.Caliber2Runner;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Caliber2E2eApplication {

	public static void main(String[] args) {
		SpringApplication.run(Caliber2E2eApplication.class, args);
		JUnitCore junit = new JUnitCore();
		junit.addListener(new TextListener(System.out));
		junit.run(Caliber2Runner.class);
	}

}
