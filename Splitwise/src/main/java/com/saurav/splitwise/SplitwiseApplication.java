package com.saurav.splitwise;

import com.saurav.splitwise.commands.Command;
import com.saurav.splitwise.commands.CommandRegistry;
import com.saurav.splitwise.exception.InvalidCommandException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class SplitwiseApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SplitwiseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		while (true){
			System.out.println("Waiting for input");
			String input = scanner.nextLine();
			String[] split = input.split("\\s+");
			Optional<Command> command = CommandRegistry.getInstance().getCommand(split[0]);
			command.ifPresent(value -> {
				try {
					value.validateAndExecute(input);
				} catch (InvalidCommandException e) {
					throw new RuntimeException(e);
				}
			});
		}

	}
}
