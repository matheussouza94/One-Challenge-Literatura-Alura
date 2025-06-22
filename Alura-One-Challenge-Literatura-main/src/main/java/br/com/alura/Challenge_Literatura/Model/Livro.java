package br.com.alura.Challenge_Literatura.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;

    private String idioma;

    private Integer downloads;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Autor autor;

    public Livro() {}

    public Livro(DadosLivro dadosLivro) {
        setTitulo(dadosLivro.titulo());
        setIdioma(dadosLivro.idioma().get(0));
        setDownloads(dadosLivro.downloads());
    }

    public Livro(Long id, String titulo, String idioma, Integer downloads, Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.idioma = idioma;
        this.downloads = downloads;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setAutor(DadosAutor dadosAutor) {
        this.autor = new Autor(dadosAutor);
    }

    @Override
    public String toString() {
        return "Livro [id: " + id + ", titulo: " + titulo + ", idioma: " + idioma + ", downloads: " + downloads + ", autor: "
                + autor.getNome() + "]";
    }

    
}
