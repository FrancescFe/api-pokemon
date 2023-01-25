package com.api.pokemon.restful.api.service;

import com.api.pokemon.restful.api.model.Pokemon;
import com.api.pokemon.restful.api.repository.PokemonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;



public class PokemonServiceImplTest {

    @Mock
    private PokemonRepository pokemonRepository;

    @InjectMocks
    private PokemonServiceImpl pokemonServiceImpl;

    private List<Pokemon> pokemonList;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        pokemonList = Arrays.
                asList(new Pokemon(null,"snorlax",4600,null,null),
                        new Pokemon(null,"golem",3000,null,null),
                        new Pokemon(null,"gyarados",2350,null,null));

    }

    @Test
    void getPokemonHeaviest() {
        when(pokemonServiceImpl.getPokemonHeaviest()).thenReturn(pokemonList);

        assertEquals("snorlax", pokemonList.get(0).getName());
        assertEquals("golem", pokemonList.get(1).getName());
        assertEquals("gyarados", pokemonList.get(2).getName());
        assertEquals(4600, pokemonList.get(0).getWeight());
        assertEquals(3000, pokemonList.get(1).getWeight());
        assertEquals(2350, pokemonList.get(2).getWeight());

        //verify(pokemonServiceImpl).getPokemonHeaviest();
    }

    @Test
    void updatePokemon() {
    }

}
