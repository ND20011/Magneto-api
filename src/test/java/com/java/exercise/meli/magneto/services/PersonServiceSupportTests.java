package com.java.exercise.meli.magneto.services;

import com.java.exercise.meli.magneto.model.Person;
import com.java.exercise.meli.magneto.services.support.PersonServiceSupport;
import org.junit.Assert;
import org.junit.Test;


public class PersonServiceSupportTests {
    @Test
    public void testFindMutantByDna(){

        PersonServiceSupport personServiceSupport =new PersonServiceSupport();
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        Person p1= new Person();
        p1.setDna(dna);
        Person p = personServiceSupport.findMutantByDna(p1.getDna());
        System.out.println(p);

        Assert.assertArrayEquals(p1.getDna(),p.getDna());
    }


}
