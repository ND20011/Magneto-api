package com.java.exercise.meli.magneto.model;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
import java.util.Objects;


@Document(collection = "Mutant")
public class Mutant {

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

    public Mutant() {
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
        if (!(o instanceof Mutant)) return false;
        Mutant mutant = (Mutant) o;
        return isMutant == mutant.isMutant &&
                Objects.equals(id, mutant.id) &&
                Arrays.equals(dna, mutant.dna);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, isMutant);
        result = 31 * result + Arrays.hashCode(dna);
        return result;
    }
}