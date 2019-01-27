package com.capita.string.calc.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.capita.string.calc.app.service.CalculatorService;

@SpringBootApplication
@ComponentScan("com.capita.string.calc")
public class Application implements CommandLineRunner {

	@Autowired
	private CalculatorService calculatorService;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try (Scanner input = new Scanner(System.in);) {
			
			System.out.print("Enter number of test cases : ");
			final int testCnt = Integer.parseInt(input.nextLine());
			List<String> expressions = new ArrayList<>();
			for (int i = 0; i < testCnt; i++) {
				System.out.print(String.format("Enter expression %s : ", i+1));
				expressions.add(input.nextLine());
			}
			System.out.println("Executing test cases... ");
			
			expressions.forEach(e -> calculatorService.calculate(e));
		}
	}

}
