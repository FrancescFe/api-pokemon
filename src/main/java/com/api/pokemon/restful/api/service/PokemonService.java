package com.api.pokemon.restful.api.service;

import com.api.pokemon.restful.api.model.Pokemon;

import java.util.List;

public interface PokemonService {

    Pokemon insert(Pokemon pokemon);

    List<Pokemon> getPokemonByName(String pokemonName);

    Pokemon updatePokemon(Long pokemonId, Pokemon pokemon);

    boolean delete(Long pokemonId);

    List<Pokemon> getPokemonHeaviest();

    List<Pokemon> getPokemonExperience();

    Pokemon createPokemon(Pokemon pokemon);
}
