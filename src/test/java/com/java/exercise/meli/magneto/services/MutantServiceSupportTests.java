package com.java.exercise.meli.magneto.services;

import com.java.exercise.meli.magneto.model.Analyzer;
import com.java.exercise.meli.magneto.model.Mutant;
import com.java.exercise.meli.magneto.repository.IMutantR;
import com.java.exercise.meli.magneto.services.support.MutantsServiceSupport;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class MutantServiceSupportTests {

    @Mock
    private IMutantR personRepository;

    @Mock
    private Analyzer analyzer;

    @InjectMocks
    MutantsServiceSupport personServiceSupport;

    String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
    @Test
    public void testFindMutantByDna(){

        Mutant p1= new Mutant();
        p1.setDna(dna);
        Mockito.when(this.personRepository.findBydna(dna)).thenReturn(java.util.Optional.of(p1));
        Mutant mutantResult = personServiceSupport.findMutantByDna(dna);
        Assert.assertEquals(p1, mutantResult);
    }


    @Test
    public void testCreateIsMutant(){
        Mockito.when(this.analyzer.validation(dna)).thenReturn(true);
        Mockito.when(this.analyzer.isMutant(dna)).thenReturn(true);
        Mutant mutant= new Mutant();
        mutant.setId("1");
        mutant.setDna(dna);
        mutant.setMutant(false);

        Mutant expected= new Mutant();
        expected.setId("1");
        expected.setDna(dna);
        expected.setMutant(true);


        Mutant mutantResult = personServiceSupport.create(mutant);
        Assert.assertEquals(expected, mutantResult);
    }


    @Test
    public void testCreateIsHuman(){
        Mockito.when(this.analyzer.validation(dna)).thenReturn(true);
        Mockito.when(this.analyzer.isMutant(dna)).thenReturn(false);

        Mutant mutant= new Mutant();
        mutant.setDna(dna);
        mutant.setMutant(false);

        Mutant expected= new Mutant();
        expected.setDna(dna);
        expected.setMutant(false);



        Mutant mutantResult = personServiceSupport.create(mutant);
        Assert.assertEquals(expected, mutantResult);
    }


    @Test
    public void testCreatevalidationFalse(){
        Mockito.when(this.analyzer.validation(dna)).thenReturn(false);

        Mutant mutant= new Mutant();
        mutant.setDna(dna);
        mutant.setMutant(false);

        Mutant mutantResult = personServiceSupport.create(mutant);

        Assert.assertEquals(null, mutantResult);
    }



    @Test
    public void teststats(){
        Mockito.when(this.personRepository.countByisMutant(true)).thenReturn((long) 40);
        Mockito.when(this.personRepository.countByisMutant(false)).thenReturn((long) 100);
        float[] result = personServiceSupport.stats();
        float[] expected ={40,100,0.4f};

        System.out.println(expected);
        System.out.println(result);
        Assert.assertEquals(expected[2],result[2]);
    }


}
