package com.java.exercise.meli.magneto.services;

import com.java.exercise.meli.magneto.model.Person;

public interface IPersonService {

    Person findMutantByDna(String [] dna) ;

    Person create(Person person);

    float[] stats();



}
