package com.literaturalura.literaturalura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.literaturalura.literaturalura.util.Main;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class LiteraturaluraApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();
		System.setProperty("DB_HOST", dotenv.get("DB_HOST"));
		System.setProperty("DB_USER_POSTGRES", dotenv.get("DB_USER_POSTGRES"));
		System.setProperty("DB_PASSWORD_POSTGRES", dotenv.get("DB_PASSWORD_POSTGRES"));

		Main main = new Main();
		main.mainMenu();

		SpringApplication.run(LiteraturaluraApplication.class, args);
	}

}
