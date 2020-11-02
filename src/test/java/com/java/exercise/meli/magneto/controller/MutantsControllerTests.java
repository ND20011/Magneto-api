package com.java.exercise.meli.magneto.controller;


import com.java.exercise.meli.magneto.model.Mutant;
import com.java.exercise.meli.magneto.services.support.MutantsServiceSupport;
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
public class MutantsControllerTests {


    @InjectMocks
    MutantsController mutantsController;


    @Mock
    MutantsServiceSupport personServiceSupport;

    String[] dna = {"TTGCGA","CAGTGC","TTATGT","TTATGT","TTATGT","TTATGT"};
    @Test
    public void testIsMutantTrue(){


        Mutant p1= new Mutant();
        p1.setId("1");
        p1.setDna(dna);
        p1.setMutant(true);

        Mockito.when(this.personServiceSupport.findMutantByDna(dna)).thenReturn(p1);


        ResponseEntity response= (ResponseEntity) mutantsController.isMutant(p1);
        ResponseEntity expected= new ResponseEntity<Object>(HttpStatus.OK);


        Assert.assertEquals(response,expected);
    }

    @Test
    public void testIsMutantFalse(){


        Mutant p1= new Mutant();
        p1.setId("1");
        p1.setDna(dna);
        p1.setMutant(false);
        Mockito.when(this.personServiceSupport.findMutantByDna(dna)).thenReturn(p1);


        ResponseEntity response= (ResponseEntity) mutantsController.isMutant(p1);
        ResponseEntity expected= new ResponseEntity<Object>(HttpStatus.FORBIDDEN);

        Assert.assertEquals(response,expected);
    }
}
