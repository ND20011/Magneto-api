package com.java.exercise.meli.magneto.model;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Analyzer {
    private String[] dna;




      public Boolean isMutant(String[] dna) {
        this.dna = dna;
        return analyze();

    }


    public boolean  validation(String[] dna){
        this.dna = dna;

        String s ="";
        //
        for (int i = 0;i< dna.length;i++){
            //comprovate nxn
            if(dna.length==dna[i].length()){
                s+=dna[i];
            }else {
                return false;
            }
        }
        // compile regular expression
        Pattern compile = Pattern.compile("[ATCG]");
        // match for regular expression in string
        Matcher matcher = compile.matcher(s);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        if(count==s.length()){
            return true;

        }
        return false;
    }

    private boolean analyze() {
        int n = dna.length;
        int secuence4=0;
        //-------


        for (int i =0 ; i < n;i++) {
            secuence4 += search(getRow(dna,i));
            secuence4 += search(getcolumns(dna,i));
            secuence4 += search(getDiagonalRow(dna,i));
            if(secuence4>1){
                return true;
            }
        }


        for (int i =1 ; i < n;i++) {

            secuence4 += search(getDiagonalColumn(dna,i));
            if(secuence4>1){
                return true;
            }
        }


        return false;
    }






    private char[] getRow(String []dna , int nRow){
        char [] row =new char[dna[0].length()];

        for (int i =0 ; i < dna[nRow].length();i++){

            row[i]=dna[nRow].charAt(i);

        }

        return row;
    }


    private char[] getcolumns(String []dna , int nColumn){
        char [] column =new char[dna.length];

        for (int i =0 ; i < dna.length;i++){
            column[i]=dna[i].charAt(nColumn);
        }
        return column;
    }



    private static char[] getDiagonalRow(String []dna , int row){
        char [] diagonal =new char[dna.length-row];

        for (int i=0;i<dna.length-row;i++)
        {
            diagonal[i]=dna[i+row].charAt(i);
        }

        return diagonal;
    }

    private static char[] getDiagonalColumn(String []dna , int column){
        char [] diagonal =new char[dna.length-column];

        for (int i=0;i<dna.length-column;i++)
        {
            diagonal[i]=dna[i].charAt(i+column);
        }

        return diagonal;
    }

    private int search(char[] arrayanalizar){
        char last = '\0';
        int letterSequence  =0;
        int lineSequence4=0;

        for (int i2 =0 ; i2 < arrayanalizar.length;i2++){
            char actual =arrayanalizar[i2];
            if( last == actual ){
                letterSequence ++;
                if(letterSequence ==3){
                    lineSequence4++;
                    letterSequence =0;
                    last = '\0';
                }

            }else {
                letterSequence =0;
            }

            last =arrayanalizar[i2];


        }
        return lineSequence4 ;
    }

}
