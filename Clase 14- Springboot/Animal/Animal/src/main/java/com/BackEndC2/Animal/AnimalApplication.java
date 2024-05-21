package com.BackEndC2.Animal;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController //sin tecnologia de vista
public class AnimalApplication {
	private static final Logger logger= Logger.getLogger(AnimalApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(AnimalApplication.class, args);
		logger.info("inicializando la aplicacion");

	}
	@GetMapping("inicio")
	public String saludo(){
		return "BIENVENIDOS A BACKEND CON SPRING CAMADA 2";
	}
	@GetMapping("inicio2")
	public String saludo2(){
		return "Digital House, les da la bienvenida a backEnd con spring";
	}

}
