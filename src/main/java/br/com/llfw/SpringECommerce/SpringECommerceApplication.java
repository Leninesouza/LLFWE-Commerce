package br.com.llfw.SpringECommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

// Anotação pra quando ainda não tem banco
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringECommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringECommerceApplication.class, args);
	}

}
