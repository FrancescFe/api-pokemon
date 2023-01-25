package com.api.pokemon.restful.api.service;

import com.api.pokemon.restful.api.model.Pokemon;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokemonServiceImplTest {
    @Autowired
    PokemonService pokemonService;

    List<Pokemon> pokemonListTop3Heaviest = pokemonService.getPokemonHeaviest();

    List<Pokemon> pokemonHeaviestListExpected = Arrays.
            asList(new Pokemon(null,"snorlax",4600,null,null),
                    new Pokemon(null,"golem",3000,null,null),
                    new Pokemon(null,"gyarados",2350,null,null));

    @Test
    void pokemonHeaviestTop3NamesOk(){
        assertEquals(pokemonHeaviestListExpected.stream().map(Pokemon::getName),
                pokemonListTop3Heaviest.stream().map(Pokemon::getName));
    }

    @Test
    void pokemonHeaviestTop3WeightOrderOk(){
        assertEquals(pokemonHeaviestListExpected.stream().map(Pokemon::getWeight).sorted(Comparator.reverseOrder()),
                pokemonListTop3Heaviest.stream().map(Pokemon::getWeight));
    }

}
