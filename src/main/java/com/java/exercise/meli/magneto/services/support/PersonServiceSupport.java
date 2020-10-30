package com.java.exercise.meli.magneto.services.support;

import com.java.exercise.meli.magneto.model.Analyzer;
import com.java.exercise.meli.magneto.model.Person;
import com.java.exercise.meli.magneto.repository.IPersonR;
import com.java.exercise.meli.magneto.services.IPersonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("mutant")
@Transactional(readOnly = true)
public class PersonServiceSupport implements IPersonService {

    @Autowired
    private IPersonR personRepository;
    @Autowired
    private Analyzer analyzer;
    private static final Logger logger = LogManager.getLogger (PersonServiceSupport.class);

    @Override
    public Person findMutantByDna(String[] dna)  {

        Person m = personRepository.findBydna(dna).orElse( null) ;
        if (m == null) {
            logger.info (String.format ("The person is not in the db"));
            return null;
        }
        logger.debug (String.format ("Found a person by DNA  "+ m.getId()));
        return m;
    }


    @Override
    public Person create(Person person) {

        if (analyzer.validation(person.getDna())){

            if ( analyzer.isMutant(person.getDna()))
            {
                person.setMutant(true);
            }else {
                person.setMutant(false);
            }
            try {
                personRepository.save(person);
                logger.info (String.format ("person created "));
            } catch (Exception ex) {
            }
        }else {
            // Invalid array
            return null;
        }
        return person;
    }

    @Override
    public float[] stats() {
        float[] stats= new float[3];
        logger.info(String.format("Get stats"));

        stats[0] = personRepository.countByisMutant(true);
        stats[1] = personRepository.countByisMutant(false);
        if(stats[0]>0){
            stats[2] = stats[0] /  stats[1];
        }else {
            stats[2] = 0;
        }
        return stats;
    }
}
