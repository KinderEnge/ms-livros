package com.github.kinderenge.ms_books.dto;


import com.github.kinderenge.ms_books.entities.Autor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AutorDTO {

    private Long id;
    @NotBlank(message = "O autor deve ter um nome")
    @Size(min=2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres")
    private String nome;
    @NotBlank(message = "O autor deve ter um email")
    @Size(min=3, max = 50, message = "O email deve ter entre 3 e 50 caracteres")
    private String email;

    public AutorDTO (Autor entity){
        id = entity.getId();
        nome = entity.getNome();
    }

}
