package com.api.pokemon.restful.api.controller;

import com.api.pokemon.restful.api.model.Pokemon;
import com.api.pokemon.restful.api.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v2/pokemon")
public class PokemonRestController {
    @Autowired
    PokemonService pokemonService;

    @GetMapping(path = "/{name}")
    public List<Pokemon> getPokemonByName(@PathVariable("name") String pokemonName) {
        return pokemonService.getPokemonByName(pokemonName);
    }

    @GetMapping(path = "/heaviest")
    public List<Pokemon> getPokemonHeaviest() {
        return pokemonService.getPokemonHeaviest();
    }

    @GetMapping(path = "/experience")
    public List<Pokemon> getPokemonExperience() {
        return pokemonService.getPokemonExperience();
    }

    @PostMapping
    public Pokemon create(@RequestBody Pokemon pokemon) {
        return pokemonService.createPokemon(pokemon);
    }

    @GetMapping
    public Iterable<Pokemon> read(){
        return pokemonService.readPokemon();
    }

    @PutMapping(path = "/{id}")
    public Pokemon update(@PathVariable("id") Long pokemonId, @RequestBody Pokemon pokemon) {
        return pokemonService.updatePokemon(pokemonId, pokemon);
    }

    @DeleteMapping(path = "/{id}")
    public String delete(@PathVariable("id") Long pokemonId) {
        return pokemonService.delete(pokemonId) ? "Pokemon was successfully deleted" :
                "The Pokemon could not be deleted";
    }
}
