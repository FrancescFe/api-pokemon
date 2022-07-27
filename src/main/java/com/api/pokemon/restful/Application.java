package com.api.pokemon.restful;

import com.api.pokemon.restful.api.model.Pokemon;
import com.api.pokemon.restful.api.repository.PokemonRepository;
import lombok.extern.slf4j.Slf4j;
import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@SpringBootApplication
@Slf4j
public class Application {

    @Autowired
    PokemonRepository pokemonRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void init() {
        if (pokemonRepository.count() == 0) {
            ArrayList<Pokemon> firstGenPokemonData = findFirstGenPokemonData();
            pokemonRepository.saveAll(firstGenPokemonData);
        }
    }

    public static ArrayList<Pokemon> findFirstGenPokemonData() {
        PokeApi pokeApi = new PokeApiClient();
        ArrayList<Pokemon> pokemonList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Pokemon pokemon = new Pokemon();
            pokemon.setId((long) i);
            pokemon.setName(pokeApi.getPokemon(i).getName());
            pokemon.setWeight(pokeApi.getPokemon(i).getWeight());
            pokemon.setHeight(pokeApi.getPokemon(i).getHeight());
            pokemon.setExperience(pokeApi.getPokemon(i).getBaseExperience());
            pokemonList.add(pokemon);
            log.info("New Pokemon " + pokemon.getName() + " stored");
        }

        return pokemonList;
    }

}
