package com.api.pokemon.restful.api.service;

import com.api.pokemon.restful.api.model.Pokemon;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokemonServiceImplTest {
    @Autowired
    PokemonService pokemonService;

    @Test
    void pokemonHeaviestTop3(){
        List<Pokemon> pokemonListTop3Heaviest = pokemonService.getPokemonHeaviest();

        List<Pokemon> pokemonListExpected = Arrays.
                asList(new Pokemon(null,"snorlax",null,null,null),
                        new Pokemon(null,"golem",null,null,null),
                        new Pokemon(null,"gyarados",null,null,null));

        assertEquals(pokemonListExpected.stream().map(Pokemon::getName), pokemonListTop3Heaviest.stream().
                map(Pokemon::getName));
    }

}
