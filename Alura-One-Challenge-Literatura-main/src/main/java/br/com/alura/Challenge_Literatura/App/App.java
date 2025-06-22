package br.com.alura.Challenge_Literatura.App;

import java.util.List;
import java.util.Scanner;

import br.com.alura.Challenge_Literatura.Model.Autor;
import br.com.alura.Challenge_Literatura.Model.DadosIniciais;
import br.com.alura.Challenge_Literatura.Model.DadosLivro;
import br.com.alura.Challenge_Literatura.Model.Livro;
import br.com.alura.Challenge_Literatura.Repository.AutorRepository;
import br.com.alura.Challenge_Literatura.Service.ConsumoApi;
import br.com.alura.Challenge_Literatura.Service.ConverteDados;

public class App {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private AutorRepository repositorio;

    public App(AutorRepository repositoryA) {
        this.repositorio = repositoryA;
    }

    public void execApp() {
        var opcao = -1;
        do {
            var menu = """
                    1 - Buscar livro pelo titulo
                    2 - Buscar livros por autor(a)
                    3 - Listar livros registrados
                    4 - Listar autores cadastrados 
                    5 - Listar autores vivos em determinado ano
                    6 - Listar livros em determinado idioma

                    0 - Sair
                    """;

            System.out.println("\nBem vindo ao app Literatura Java\n");
            System.out.println("\n***********************************************\n");
            System.out.println(menu);
            System.out.println("\n***********************************************\n");
            opcao = Integer.parseInt(leitura.nextLine());

            switch (opcao) {
                case 1:
                    buscarLivro();
                    break;
                case 2:
                    busarLivrosPorAutor();
                    break;
                case 3:
                    listarLivros();
                    break;
                case 4:
                    listarAutores();
                    break;
                case 5:
                    listarAutoresPorAno();
                    break;
                case 6:
                    listarLivrosPorIdioma();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcao != 0);
        System.out.println("Obrigado por usar o app Literatura Java");
        System.out.println("Tenha um bom dia");
    }

    private void buscarLivro() {
        System.out.print("Digite o nome do livro para buscar: ");
        var nomelivro = leitura.nextLine().toLowerCase().split(" ")[0].trim();
        var dadosIniciais = getDadosIniciais(nomelivro);
        System.out.println("\n*****************************************************************\n");
        System.out.println("\nLivros encontados\n");
        dadosIniciais.resultados().stream().filter(l -> l.titulo().toLowerCase().contains(nomelivro)).forEach(l -> System.out.println("Id: " + l.id() + " / Titulo: " + l.titulo() + " / Autor: " + l.autor().get(0).nome()));
        System.out.println("\n*****************************************************************\n");
        getDadosLivro();
    }

    private void busarLivrosPorAutor() {
        System.out.print("Digite o nome do(a) autor(a) para buscar: ");
        var nomeAutor = leitura.nextLine().toLowerCase().split(" ")[0].trim();
        var dadosIniciais = getDadosIniciais(nomeAutor);
        System.out.println("\n*****************************************************************\n");
        System.out.println("\nLivros encontrados\n");
        dadosIniciais.resultados().stream().filter(l -> l.autor().get(0).nome().toLowerCase().contains(nomeAutor)).forEach(l -> System.out.println("Id: " + l.id() + " / Titulo: " + l.titulo() + " / Autor: " + l.autor().get(0).nome()));
        System.out.println("\n*****************************************************************\n");
        getDadosLivro();
    }

    private void listarLivros() {
        List<Livro> listaLivros = repositorio.obterTodosLivros();
        
        System.out.println("\n*************************\n");
        System.out.println("Livros cadastrados");
        listaLivros.stream().forEach(System.out::println);
        System.out.println("\n*************************\n");
    }

    private void listarAutores() {
        List<Autor> listaAutores = repositorio.obterTodosAutores();
        
        System.out.println("\n*************************\n");
        System.out.println("Autores cadastrados");
        listaAutores.stream().forEach(System.out::println);
        System.out.println("\n*************************\n");
    }

    private void listarAutoresPorAno() {
        System.out.print("Informe o ano para pesquisar autores vivos naquele ano: ");
        int ano = Integer.parseInt(leitura.nextLine());
        List<Autor> listaAutores = repositorio.obterAutoresPorAno(ano);
        
        System.out.println("\n*************************\n");
        System.out.println("Autores vivos no ano de " + ano);
        listaAutores.stream().forEach(System.out::println);
        System.out.println("\n*************************\n");
    }

    private void listarLivrosPorIdioma() {
        System.out.println("Idiomas disponiveis para pesquisa:");
        System.out.println("""
                pt - Português
                en - Inglês
                fr - Francês
                it - Italiano
                """);
        System.out.println("Digite apenas a sigla para realizar a busca: ");
        var idioma = leitura.nextLine();
        List<Livro> listaLivros = repositorio.obterLivrosPorIdioma(idioma);
        String textoIdioma;
        switch (idioma) {
            case "pt":
                textoIdioma = "Português";
                break;
            case "en":
                textoIdioma = "Inglês";
                break;
            case "fr":
                textoIdioma = "Francês";
                break;
            case "it":
                textoIdioma = "Italiano";
            default:
                textoIdioma = "Opção inválida";
                break;
        }
        
        System.out.println("\n*************************\n");
        System.out.println("Livros no idioma " + textoIdioma);
        listaLivros.stream().forEach(System.out::println);
        System.out.println("\n*************************\n");
    }

    public DadosIniciais getDadosIniciais(String nome) {
        var json = consumo.obterDados(nome);
        DadosIniciais dadosIniciais = conversor.obterDados(json, DadosIniciais.class);

        return dadosIniciais;
    }

    public void getDadosLivro() {
        System.out.print("Digite o id do livro para cadastrá-lo ou digite 0 para voltar ao menu: ");
        var id = leitura.nextLine();

        if (id.equalsIgnoreCase("0")) {
            System.out.println("\nVoltando ao menu...\n");
        } else {
            var json = consumo.obterDadosLivro(id);

            DadosLivro dadosLivro = conversor.obterDados(json, DadosLivro.class);

            var autor = repositorio.findByNomeContainingIgnoreCase(dadosLivro.autor().get(0).nome());

            if (autor.isPresent()) {
                var listaLivros = autor.get().getLivros();
                Livro livro = new Livro(dadosLivro);
                livro.setAutor(autor.get());

                listaLivros.add(livro);

                autor.get().setLivros(listaLivros);

                repositorio.save(autor.get());
                System.out.println("\n*************************\n");
                System.out.println("Livro cadastrado");
                System.out.println(livro);
                System.out.println("\n*************************\n");
            } else {
                Autor novoAutor = new Autor(dadosLivro.autor().get(0));
                repositorio.save(novoAutor);
                System.out.println("\n*************************\n");
                System.out.println("Autor cadastrado");
                System.out.println(novoAutor);
                System.out.println("\n*************************\n");

                Livro livro = new Livro(dadosLivro);

                adicionarLivro(novoAutor.getNome(), livro);
            }
        }  
    }

    public void adicionarLivro(String nome, Livro livro) {
        var autor = repositorio.findByNomeContainingIgnoreCase(nome);
        var listaLivros = autor.get().getLivros();

        livro.setAutor(autor.get());

        listaLivros.add(livro);

        autor.get().setLivros(listaLivros);

        repositorio.save(autor.get());
        System.out.println("\n*************************\n");
        System.out.println("Livro cadastrado");
        System.out.println(livro);
        System.out.println("\n*************************\n");
    }
}
