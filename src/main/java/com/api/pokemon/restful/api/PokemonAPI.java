package com.api.pokemon.restful.api;

import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.PokemonSpecies;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import static com.api.pokemon.restful.api.controller.PokemonController.findAllPokemonNames;
import static com.api.pokemon.restful.api.controller.PokemonController.findPokemonByContainsName;

@RestController
@RequestMapping("/api/v1/pokemon")
public class PokemonAPI {

    @GetMapping(path = "/findOne")
    public PokemonSpecies findOne() {
        PokeApi pokeApi = new PokeApiClient();
        PokemonSpecies bulbasaur = pokeApi.getPokemonSpecies(1);
        return bulbasaur;
    }

    @GetMapping(path = "/all")
    public ArrayList<String> findAll() {
        return findAllPokemonNames();
    }

    @GetMapping(path = "/findName/{name}")
    public ArrayList<String> findByContainsName(@PathVariable("name") String containsName) {
        return findPokemonByContainsName(containsName);
    }

}
