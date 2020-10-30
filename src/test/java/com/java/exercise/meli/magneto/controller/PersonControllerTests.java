package com.java.exercise.meli.magneto.controller;


import com.java.exercise.meli.magneto.model.Analyzer;
import com.java.exercise.meli.magneto.model.Person;
import com.java.exercise.meli.magneto.repository.IPersonR;
import com.java.exercise.meli.magneto.services.IPersonService;
import com.java.exercise.meli.magneto.services.support.PersonServiceSupport;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class PersonControllerTests {


    @InjectMocks
    PersonController personController;


    @Mock
    PersonServiceSupport personServiceSupport;

    @Test
    public void testIsMutantTrue(){

        String[] dna = {"TTGCGA","CAGTGC","TTATGT","TTATGT","TTATGT","TTATGT"};

        Person p1= new Person();
        p1.setId("1");
        p1.setDna(dna);
        p1.setMutant(true);


        given(this.personServiceSupport.findMutantByDna(dna)).willReturn(p1);
        given(this.personServiceSupport.create(p1)).willReturn(p1);

        ResponseEntity response= (ResponseEntity) personController.isMutant(p1);
        ResponseEntity expected= new ResponseEntity<Object>(HttpStatus.OK);


        Assert.assertEquals(response,expected);
    }

    @Test
    public void testIsMutantFalse(){

        String[] dna = {"TTGCGA","CAGTGC","TTATGT","TTATGT","TTATGT","TTATGT"};

        Person p1= new Person();
        p1.setId("1");
        p1.setDna(dna);
        p1.setMutant(false);


        given(this.personServiceSupport.findMutantByDna(dna)).willReturn(p1);
        given(this.personServiceSupport.create(p1)).willReturn(p1);

        ResponseEntity response= (ResponseEntity) personController.isMutant(p1);
        ResponseEntity expected= new ResponseEntity<Object>(HttpStatus.FORBIDDEN);

        Assert.assertEquals(response,expected);
    }
}
