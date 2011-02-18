package springpuzzles.fieldinjection.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springpuzzles.fieldinjection.OtherService;

/**
 * @author: ecamacho
 * javahispano 2010
 */
@Service("otherService")
public class OtherServiceImpl implements OtherService {

    private static final Logger logger = Logger.getLogger( OtherServiceImpl.class );

    @Transactional
    public void doFirstStep() {
        logger.debug("[doing FirstStep]");
    }
    
}
