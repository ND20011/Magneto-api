package com.java.exercise.meli.magneto.services;

import com.java.exercise.meli.magneto.model.Mutant;

public interface IMutantsService {

    Mutant findMutantByDna(String [] dna) ;

    Mutant create(Mutant mutant);

    float[] stats();



}
