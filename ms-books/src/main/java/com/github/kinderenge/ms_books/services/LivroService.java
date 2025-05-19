package com.github.kinderenge.ms_books.services;

import com.github.kinderenge.ms_books.dto.AutorDTO;
import com.github.kinderenge.ms_books.dto.LivroDTO;
import com.github.kinderenge.ms_books.entities.Autor;
import com.github.kinderenge.ms_books.entities.Livro;
import com.github.kinderenge.ms_books.repositories.AutorRepository;
import com.github.kinderenge.ms_books.repositories.LivroRepository;
import com.github.kinderenge.ms_books.services.exceptions.DatabaseException;
import com.github.kinderenge.ms_books.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LivroService{
    @Autowired
    private LivroRepository repository;

    @Autowired
    private AutorRepository autorRepository;

    @Transactional(readOnly = true)
    public List<LivroDTO> findAll(){
        return repository.findAll().stream().map(LivroDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public LivroDTO findById(Long id){
        Livro entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado. ID: "+id)
        );
        return new LivroDTO(entity);
    }

    @Transactional
    public LivroDTO insert(LivroDTO dto){
        Livro entity = new Livro();
        toEntity(dto, entity);
        entity = repository.save(entity);
        return new LivroDTO(entity);
    }

    private void toEntity(LivroDTO dto, Livro entity) {
        entity.setTitulo(dto.getTitulo());
        entity.setAnoPublicado(dto.getAno_publicado());
        entity.getAutores().clear();
        for (AutorDTO autorDTO: dto.getAutores()){
            Autor autor = autorRepository.getReferenceById(autorDTO.getId());
            entity.getAutores().add(autor);
        }
    }
}
