package cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;

@SpringBootApplication
public class S05T02N02PortabellasusanaApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {

		SpringApplication.run(S05T02N02PortabellasusanaApplication.class, args);
		System.out.println("Ok.");
	}

}