package com.apicomsqlite.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apicomsqlite.poo.enity.Livro;
import com.apicomsqlite.poo.repository.LivroRepository;
import jakarta.transaction.Transactional;

@Service
public class LivroService {

    @Autowired(required = false)
    private LivroRepository livroRespository;

    @Transactional
    public String createlivro(Livro livro) {
        try {
            if (!livroRespository.existsByTitulo(livro.getTitulo())) {
                livro.setId(null == livroRespository.findMaxId() ? 1 : livroRespository.findMaxId() + 1);
                livroRespository.save(livro);
                return "livro cadastrado com sucesso.";
            } else {
                return "livro já existe no banco.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Livro> readlivros() {
        return livroRespository.findAll();
    }

    @Transactional
    public String updatelivro(Livro livro) {
        if (livroRespository.existsByTitulo(livro.getTitulo())) {
            try {
                List<Livro> livros = livroRespository.findByTitulo(livro.getTitulo());
                livros.stream().forEach(s -> {
                    Livro livroToBeUpdate = livroRespository.findById(s.getId()).get();
                    livroToBeUpdate.setTitulo(livro.getTitulo());
                    livroToBeUpdate.setAutor(livro.getAutor());
                    livroToBeUpdate.setCategoria(livro.getCategoria());
                    livroRespository.save(livroToBeUpdate);
                });
                return "livro atualizado.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "livro não existe no banco.";
        }
    }

    @Transactional
    public String deletelivro(Livro livro) {
        if (livroRespository.existsByTitulo(livro.getTitulo())) {
            try {
                List<Livro> livros = livroRespository.findByTitulo(livro.getTitulo());
                livros.stream().forEach(s -> {
                    livroRespository.delete(s);
                });
                return "livro deletado.";
            } catch (Exception e) {
                throw e;
            }

        } else {
            return "livro n\u00E3o existe no banco.";
        }
    }
}