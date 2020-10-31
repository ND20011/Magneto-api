package com.java.exercise.meli.magneto.controller;


import com.java.exercise.meli.magneto.model.Analyzer;
import com.java.exercise.meli.magneto.model.Person;
import com.java.exercise.meli.magneto.repository.IPersonR;
import com.java.exercise.meli.magneto.services.support.PersonServiceSupport;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class PersonControllerTests {


    @InjectMocks
    PersonController personController;


    @Mock
    PersonServiceSupport personServiceSupport;

    String[] dna = {"TTGCGA","CAGTGC","TTATGT","TTATGT","TTATGT","TTATGT"};
    @Test
    public void testIsMutantTrue(){


        Person p1= new Person();
        p1.setId("1");
        p1.setDna(dna);
        p1.setMutant(true);

        Mockito.when(this.personServiceSupport.findMutantByDna(dna)).thenReturn(p1);


        ResponseEntity response= (ResponseEntity) personController.isMutant(p1);
        ResponseEntity expected= new ResponseEntity<Object>(HttpStatus.OK);


        Assert.assertEquals(response,expected);
    }

    @Test
    public void testIsMutantFalse(){


        Person p1= new Person();
        p1.setId("1");
        p1.setDna(dna);
        p1.setMutant(false);
        Mockito.when(this.personServiceSupport.findMutantByDna(dna)).thenReturn(p1);


        ResponseEntity response= (ResponseEntity) personController.isMutant(p1);
        ResponseEntity expected= new ResponseEntity<Object>(HttpStatus.FORBIDDEN);

        Assert.assertEquals(response,expected);
    }
}
