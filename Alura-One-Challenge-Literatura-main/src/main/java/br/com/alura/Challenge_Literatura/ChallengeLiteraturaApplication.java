package br.com.alura.Challenge_Literatura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.Challenge_Literatura.App.App;
import br.com.alura.Challenge_Literatura.Repository.AutorRepository;

@SpringBootApplication
public class ChallengeLiteraturaApplication implements CommandLineRunner {
	
	@Autowired
	private AutorRepository repositorioAutor;

	public static void main(String[] args) {
		SpringApplication.run(ChallengeLiteraturaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		App app = new App(repositorioAutor);
		app.execApp();
	}

}
