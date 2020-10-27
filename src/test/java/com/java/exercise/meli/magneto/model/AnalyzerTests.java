package com.java.exercise.meli.magneto.model;


import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class AnalyzerTests {


    @Test
    public void testvalidationResultTrue(){
        Analyzer analyzer =new Analyzer();
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        boolean result = true;

        Assert.assertEquals(result,analyzer.validation(dna));
    }



    @Test
    public void testvalidationResultFalse(){
        Analyzer analyzer =new Analyzer();
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG","TCACTG"};
        boolean result = false;

        Assert.assertEquals(result,analyzer.validation(dna));
    }


    @Test
    public void testisMutantResultTrue(){
        Analyzer analyzer =new Analyzer();
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        boolean result = true;

        Assert.assertEquals(result,analyzer.isMutant(dna));
    }

    @Test
    public void testisMutantResultFalse(){
        Analyzer analyzer =new Analyzer();
        String[] dna = {"TTGCGA","CAGTGC","TTATGT","AGAAGG","CGCCTA","TCACTG"};
        boolean result = false;

        Assert.assertEquals(result,analyzer.isMutant(dna));
    }


}
