package com.github.kinderenge.ms_books.dto;

import com.github.kinderenge.ms_books.entities.Autor;
import com.github.kinderenge.ms_books.entities.Livro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LivroDTO {

    private Long id;
    @NotBlank(message = "O livro deve ter um nome não nulo")
    @Size(min = 1, max = 150, message = "O título do livro deve ter entre 1 e 50 caracteres")
    private String titulo;
    @NotNull(message = "O ano de publicação do livro não pode ser null")
    private Integer ano_publicado;
    @NotEmpty(message = "O livro deve ter pelo menos um autor")
    private Set<AutorDTO> autores = new HashSet<>();

    public LivroDTO(Livro entity){
        titulo = entity.getTitulo();
        ano_publicado = entity.getAnoPublicado();
        for(Autor autor: entity.getAutores()){
            AutorDTO autorDTO = new AutorDTO(autor);
            autores.add(autorDTO);
        }
    }
}
