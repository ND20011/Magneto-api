package com.java.exercise.meli.magneto.controller;


import com.java.exercise.meli.magneto.exeptionHandler.exeption.BadRequestException;
import com.java.exercise.meli.magneto.model.Person;
import com.java.exercise.meli.magneto.services.IPersonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping ("persons")
@RestController
public class PersonController {


    @Autowired
    private IPersonService personService;

    private static final Logger logger = LogManager.getLogger (PersonController.class);




    @RequestMapping (value="/mutant",method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Object isMutant(@RequestBody Person person)  {
        try {
            //search  DNA
            Person m = personService.findMutantByDna(person.getDna());
            if (m == null) {
                //analyze and save
                m = personService.create(person);
            }

            // answer according to m
            if (m != null) {

                if (m.isMutant()) {
                    logger.info(String.format("Is mutant "));
                    return new ResponseEntity<Object>(HttpStatus.OK);
                } else {
                    logger.info(String.format("Is human "));
                    return new ResponseEntity<Object>(HttpStatus.FORBIDDEN);
                }

            } else {
                logger.warn(String.format("Invalid DNA (n*n)"));
                throw new BadRequestException("Invalid DNA ");
            }

        }catch (Exception e){
            logger.warn(String.format("Invalid DNA array "));
            throw new BadRequestException("Invalid DNA array");
        }
    }

    @RequestMapping (value="/stats",method = RequestMethod.GET)
    public Object stats()  {
        float[] stat = personService.stats();
        return "{count_mutant_dna:"+stat[0]+ ",count_human_dna:"+stat[1]+", ratio:"+stat[2]+"}";
    }


}
