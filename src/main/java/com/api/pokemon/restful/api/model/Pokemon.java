package com.api.pokemon.restful.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pokemon {
    @Id
    private Long id;
    private String name;
    private Integer weight;
    private Integer experience;
    private Integer height;

}
