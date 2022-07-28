package com.api.pokemon.restful.api.service;

import com.api.pokemon.restful.api.model.Pokemon;

import java.util.List;

public interface PokemonService {

    List<Pokemon> getPokemonByName(String pokemonName);

    List<Pokemon> getPokemonHeaviest();

    List<Pokemon> getPokemonExperience();

    Pokemon createPokemon(Pokemon pokemon);

    Iterable<Pokemon> readPokemon();

    Pokemon updatePokemon(Long pokemonId, Pokemon pokemon);

    boolean delete(Long pokemonId);

}
