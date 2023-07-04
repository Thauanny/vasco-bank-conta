package com.vascobancoconta.vascobancocontaarti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.vascobancoconta.vascobancocontaarti.models.Conta;
import com.vascobancoconta.vascobancocontaarti.repository.ContaRepository;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class VascoBancoContaApplication {

	@Autowired
	private static ContaRepository contaRepository;

	public static void main(String[] args) {
		SpringApplication.run(VascoBancoContaApplication.class, args);
	
		contaRepository.save(Conta.contaBanco());
	}

}
