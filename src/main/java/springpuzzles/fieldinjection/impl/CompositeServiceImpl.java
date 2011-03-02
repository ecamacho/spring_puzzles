package springpuzzles.fieldinjection.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springpuzzles.fieldinjection.CompositeService;
import springpuzzles.fieldinjection.OtherService;

/**
 * @author: ecamacho
 * javahispano 2010
 */
@Service("compositeService")
public class CompositeServiceImpl implements CompositeService {

    private static final Logger logger = Logger.getLogger( CompositeServiceImpl.class );


    private OtherServiceImpl otherService;

    @Autowired
    public  CompositeServiceImpl ( OtherServiceImpl otherService ) {
         this.otherService = otherService;
    }

    public void doSomething() {
        logger.debug("[init doSomething]");
        otherService.doFirstStep();
    }
}
