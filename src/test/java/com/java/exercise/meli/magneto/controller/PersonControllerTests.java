package com.java.exercise.meli.magneto.controller;

import com.java.exercise.meli.magneto.model.Person;
import com.java.exercise.meli.magneto.services.support.PersonServiceSupport;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class PersonControllerTests {
    @InjectMocks
   private PersonController personController;

    @Mock
    private PersonServiceSupport myService;

    @Test
    public void testIsMutant(){
        Person p =new Person();
        String[] dna = {"ATGCGA","CAGTGC","TATTTT","AGAAGG","CCGCTA","CCCCCC"};
        p.setDna(dna);

        System.out.println(dna[0]);
        ResponseEntity result = new ResponseEntity (HttpStatus.OK);;
       ResponseEntity response = (ResponseEntity) personController.isMutant(p);
        Assert.assertEquals(result,result);


    }

}
