package com.api.pokemon.restful.api.repository;

import com.api.pokemon.restful.api.model.Pokemon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepository extends CrudRepository<Pokemon, Long> {

    List<Pokemon> findTop3ByOrderByExperienceDesc();

    List<Pokemon> findTop3ByOrderByWeightDesc();

    List<Pokemon> findByNameStartingWith(String pokemonName);
}
