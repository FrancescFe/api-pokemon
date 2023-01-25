package com.api.pokemon.restful.api.service;

import com.api.pokemon.restful.api.model.Pokemon;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokemonServiceImplTest {
    @Autowired
    PokemonService pokemonService;

    @Test
    void pokemonHeaviestTop3(){
        List<Pokemon> pokemonListTop3Heaviest = pokemonService.getPokemonHeaviest();

        Pokemon pokemonTop1Heaviest = new Pokemon();
        Pokemon pokemonTop2Heaviest = new Pokemon();
        Pokemon pokemonTop3Heaviest = new Pokemon();
        pokemonTop1Heaviest.setName("snorlax");
        pokemonTop2Heaviest.setName("golem");
        pokemonTop3Heaviest.setName("gyarados");
        List<Pokemon> pokemonListExpected = new ArrayList<>();
        pokemonListExpected.add(pokemonTop1Heaviest);
        pokemonListExpected.add(pokemonTop2Heaviest);
        pokemonListExpected.add(pokemonTop3Heaviest);

        assertEquals(pokemonListExpected.stream().map(Pokemon::getName), pokemonListTop3Heaviest.stream().map(Pokemon::getName));
    }

}
