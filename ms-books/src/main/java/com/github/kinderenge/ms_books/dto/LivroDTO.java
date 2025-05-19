package com.github.kinderenge.ms_books.dto;

import com.github.kinderenge.ms_books.entities.Livro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    public LivroDTO(Livro entity){
        titulo = entity.getTitulo();
        ano_publicado = entity.getAnoPublicado();
    }
}
