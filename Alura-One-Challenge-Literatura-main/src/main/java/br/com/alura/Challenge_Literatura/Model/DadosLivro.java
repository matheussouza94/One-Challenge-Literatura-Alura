package br.com.alura.Challenge_Literatura.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivro(@JsonAlias("id") Integer id,
                         @JsonAlias("title") String titulo,
                         @JsonAlias("languages") List<String> idioma,
                         @JsonAlias("download_count") Integer downloads,
                         @JsonAlias("authors") List<DadosAutor> autor) {
    
}
