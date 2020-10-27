package com.java.exercise.meli.magneto.repository;

import com.java.exercise.meli.magneto.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface IPersonR extends MongoRepository<Person, String> {

    /**
     *
     *  <p>Method that find person  by dna.
     *
     *  @param dna
     *  @return mutant.
     * */

    Optional <Person> findBydna (String[] dna);


    /**
     *
     *  <p>Method that count by isMutant  .
     *
      *  @param isMutant
     *  @return coun.
     * */

    long countByisMutant(Boolean isMutant);

}
