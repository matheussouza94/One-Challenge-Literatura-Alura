package br.com.alura.Challenge_Literatura.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.alura.Challenge_Literatura.Model.Autor;
import br.com.alura.Challenge_Literatura.Model.Livro;

public interface AutorRepository extends JpaRepository<Autor, Long> {
   @Query("SELECT a FROM Autor a WHERE a.nome ILIKE%:nome%")
   Optional<Autor> buscarAutorPorNome(String nome);

   @Query("SELECT a.id FROM Autor a WHERE a.nome ILIKE%:nome%")
   Optional<Integer> buscarIdAutor(String nome);

   Optional<Autor> findByNomeContainingIgnoreCase(String nome);

   @Query("SELECT l FROM Autor a JOIN a.livros l WHERE a.nome ILIKE%:nome%")
   List<Livro> obterLivros(String nome);

   @Query("SELECT l FROM Autor a JOIN a.livros l ORDER BY a.nome")
   List<Livro> obterTodosLivros();

   @Query("SELECT a FROM Autor a ORDER BY a.nome")
   List<Autor> obterTodosAutores();

   @Query("SELECT a FROM Autor a WHERE a.anoNascimento < :ano AND a.anoMorte > :ano")
   List<Autor> obterAutoresPorAno(int ano);

   @Query("SELECT l FROM Autor a JOIN a.livros l WHERE l.idioma ILIKE %:idioma% ORDER BY l.titulo")
   List<Livro> obterLivrosPorIdioma(String idioma);
}
