package br.com.alura.Challenge_Literatura.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosIniciais(@JsonAlias("results") List<DadosLivro> resultados) {

}
