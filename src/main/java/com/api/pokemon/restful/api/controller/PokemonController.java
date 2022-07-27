package com.api.pokemon.restful.api.controller;

import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;

import java.util.ArrayList;

public class PokemonController {

    public static ArrayList<String> findAllPokemonNames() {
        PokeApi pokeApi = new PokeApiClient();
        ArrayList<String> pokemonList = new ArrayList<>();
        String pokemon;
        for (int i = 1; i <= 150; i++) {
            pokemon = pokeApi.getPokemonSpecies(i).getName();
            pokemonList.add(pokemon);
        }
        return pokemonList;
    }

    public static ArrayList<String> findPokemonByContainsName(String containsName) {
        ArrayList<String> pokemonList = findAllPokemonNames();
        ArrayList<String> pokemonContainedList = new ArrayList<>();
        for (String iter : pokemonList) {
            if (iter.startsWith(containsName)) {
                pokemonContainedList.add(iter);
            }
        }
        return pokemonContainedList;
    }

    public static ArrayList<String> findTopThreePokemonByWeight() {
        return null;
    }
}
