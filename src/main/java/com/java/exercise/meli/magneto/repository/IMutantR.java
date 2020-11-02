package com.java.exercise.meli.magneto.repository;

import com.java.exercise.meli.magneto.model.Mutant;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface IMutantR extends MongoRepository<Mutant, String> {

    /**
     *
     *  <p>Method that find human or mutant  by dna.
     *
     *  @param dna
     *  @return mutant.
     * */

    Optional <Mutant> findBydna (String[] dna);


    /**
     *
     *  <p>Method that count by isMutant  .
     *
      *  @param isMutant
     *  @return coun.
     * */

    long countByisMutant(Boolean isMutant);

}
