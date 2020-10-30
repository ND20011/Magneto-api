package com.java.exercise.meli.magneto.model;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
import java.util.Objects;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return isMutant == person.isMutant &&
                Objects.equals(id, person.id) &&
                Arrays.equals(dna, person.dna);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, isMutant);
        result = 31 * result + Arrays.hashCode(dna);
        return result;
    }
}