package com.java.exercise.meli.magneto.services.support;

import com.java.exercise.meli.magneto.model.Analyzer;
import com.java.exercise.meli.magneto.model.Mutant;
import com.java.exercise.meli.magneto.repository.IMutantR;
import com.java.exercise.meli.magneto.services.IMutantsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("mutant")
@Transactional(readOnly = true)
public class MutantsServiceSupport implements IMutantsService {

    @Autowired
    private IMutantR personRepository;
    @Autowired
    private Analyzer analyzer;
    private static final Logger logger = LogManager.getLogger (MutantsServiceSupport.class);

    @Override
    public Mutant findMutantByDna(String[] dna)  {

        Mutant m = personRepository.findBydna(dna).orElse( null) ;
        if (m == null) {
            logger.info (String.format ("The person is not in the db"));
            return null;
        }
        logger.debug (String.format ("Found a person by DNA  "+ m.getId()));
        return m;
    }


    @Override
    public Mutant create(Mutant mutant) {

        if (analyzer.validation(mutant.getDna())){

            if ( analyzer.isMutant(mutant.getDna()))
            {
                mutant.setMutant(true);
            }else {
                mutant.setMutant(false);
            }
            try {
                personRepository.save(mutant);
                logger.info (String.format ("person created "));
            } catch (Exception ex) {
            }
        }else {
            // Invalid array
            return null;
        }
        return mutant;
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
