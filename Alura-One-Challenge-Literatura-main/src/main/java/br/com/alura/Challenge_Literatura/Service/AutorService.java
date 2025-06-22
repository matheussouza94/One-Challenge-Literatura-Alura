package br.com.alura.Challenge_Literatura.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.Challenge_Literatura.Repository.AutorRepository;

@Service
public class AutorService {
    @Autowired
    public AutorRepository repositorio;
}
