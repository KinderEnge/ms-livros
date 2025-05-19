package com.github.kinderenge.ms_books.repositories;

import com.github.kinderenge.ms_books.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long>{
}
