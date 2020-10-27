package com.java.exercise.meli.magneto.model;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;



@Document(collection = "Mutant")
public class Person {

    @Id
    @NotNull
    private String id;

    @NotNull
    private String[] dna;

    @NotNull
    private boolean isMutant;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }

    public boolean isMutant() {
        return isMutant;
    }

    public void setMutant(boolean mutant) {
        isMutant = mutant;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", dna=" + Arrays.toString(dna) +
                ", isMutant=" + isMutant +
                '}';
    }
}