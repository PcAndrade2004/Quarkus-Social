package br.com.pauloCesar.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "tb_users")
@Data
public class UserEntity {

    @Id
    @GeneratedValue()
    private UUID id;

    @NotBlank(message = "Este campo não pode estar vazio!")
    private String name;

    @NotNull(message = "Este campo não pode estar vazio!")
    private Integer age;

}
