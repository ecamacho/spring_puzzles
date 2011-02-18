package springpuzzles.aopproxies.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


/**
 * @author: ecamacho
 * javahispano 2010
 */
@Aspect
public class SystemLogger {

    private static final Logger logger = Logger.getLogger( SystemLogger.class );

    @Before("execution(void set*(..))")
    public void logInvokedMethod( JoinPoint jp ) {
        logger.info("Invoking method " + jp.getSignature().getName());
    }
}
