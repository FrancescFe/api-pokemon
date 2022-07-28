package com.api.pokemon.restful.api.service;

import com.api.pokemon.restful.api.model.Pokemon;
import com.api.pokemon.restful.api.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonServiceImpl implements PokemonService {

    @Autowired
    PokemonRepository pokemonRepository;

    @Override
    public List<Pokemon> getPokemonByName(String pokemonName) {
        return pokemonRepository.findByNameStartingWith(pokemonName);
    }

    @Override
    public List<Pokemon> getPokemonHeaviest() {
        return pokemonRepository.findTop3ByOrderByWeightDesc();
    }

    @Override
    public List<Pokemon> getPokemonExperience() {
        return pokemonRepository.findTop3ByOrderByExperienceDesc();
    }

    @Override
    public Pokemon createPokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    @Override
    public Iterable<Pokemon> readPokemon() {
        return pokemonRepository.findAll();
    }

    @Override
    public Pokemon updatePokemon(Long pokemonId, Pokemon pokemon) {
        Pokemon pDb = pokemonRepository.findById(pokemonId).get();

        pDb.setName(pokemon.getName() != null ? pokemon.getName() : pDb.getName());
        pDb.setWeight(pokemon.getWeight() != null ? pokemon.getWeight() : pDb.getWeight());
        pDb.setWeight(pokemon.getHeight() != null ? pokemon.getHeight() : pDb.getHeight());
        pDb.setExperience(pokemon.getExperience() != null ? pokemon.getExperience() : pDb.getExperience());
        return pokemonRepository.save(pDb);
    }

    @Override
    public boolean delete(Long pokemonId) {
        pokemonRepository.deleteById(pokemonId);
        return pokemonRepository.findById(pokemonId).isEmpty();
    }
}
