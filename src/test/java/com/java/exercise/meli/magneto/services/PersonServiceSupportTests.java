package com.java.exercise.meli.magneto.services;

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
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class PersonServiceSupportTests {

    @Mock
    private IPersonR personRepository;

    @Mock
    private Analyzer analyzer;

    @InjectMocks
    PersonServiceSupport personServiceSupport;

    String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
    @Test
    public void testFindMutantByDna(){

        Person p1= new Person();
        p1.setDna(dna);
        Mockito.when(this.personRepository.findBydna(dna)).thenReturn(java.util.Optional.of(p1));
        Person personResult = personServiceSupport.findMutantByDna(dna);
        Assert.assertEquals(p1,personResult);
    }


    @Test
    public void testCreateIsMutant(){
        Mockito.when(this.analyzer.validation(dna)).thenReturn(true);
        Mockito.when(this.analyzer.isMutant(dna)).thenReturn(true);
        Person p1= new Person();
        p1.setId("1");
        p1.setDna(dna);
        p1.setMutant(false);

        Person expected= new Person();
        expected.setId("1");
        expected.setDna(dna);
        expected.setMutant(true);


        Person personResult = personServiceSupport.create(p1);
        Assert.assertEquals(expected,personResult);
    }


    @Test
    public void testCreateIsHuman(){
        Mockito.when(this.analyzer.validation(dna)).thenReturn(true);
        Mockito.when(this.analyzer.isMutant(dna)).thenReturn(false);

        Person p1= new Person();
        p1.setDna(dna);
        p1.setMutant(false);

        Person expected= new Person();
        expected.setDna(dna);
        expected.setMutant(false);



        Person personResult = personServiceSupport.create(p1);
        Assert.assertEquals(expected,personResult);
    }


    @Test
    public void testCreatevalidationFalse(){
        Mockito.when(this.analyzer.validation(dna)).thenReturn(false);

        Person p1= new Person();
        p1.setDna(dna);
        p1.setMutant(false);

        Person personResult = personServiceSupport.create(p1);

        Assert.assertEquals(null,personResult);
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
