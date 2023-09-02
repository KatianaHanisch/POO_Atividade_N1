package com.apicomsqlite.poo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apicomsqlite.poo.enity.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

    public boolean existsByTitulo(String titulo);

    public List<Livro> findByTitulo(String titulo);

    @Query("select max(s.id) from Livro s")
    public Integer findMaxId();
}