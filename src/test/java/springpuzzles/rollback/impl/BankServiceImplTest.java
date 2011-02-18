package springpuzzles.rollback.impl;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;
import springpuzzles.rollback.BankService;
import springpuzzles.rollback.domain.Account;
import springpuzzles.rollback.persistence.AccountDao;

/**
 * @author: ecamacho
 * javahispano 2010
 */
@RunWith(SpringJUnit4ClassRunner.class )
@ContextConfiguration(locations = "classpath:springpuzzles/rollback/test-rollback-context.xml")
@Transactional
public class BankServiceImplTest {

    @Autowired
    private BankService bankService;

    @Autowired
    private AccountDao accountDao;

    private double amountOriginAccount;

    private double amountDestinationAccount;

    private int transactionLogsCounter;

    private static final String idOriginAccount = "account_1";

    private static final String idDestinationAccount = "account_2";


    private final static Logger logger = Logger.getLogger( BankServiceImplTest.class );

    @BeforeTransaction
    public void beforeTransaction() {
        logger.debug("[Cantidades en la base de datos antes de hacer la transferencia");
        printState();
    }

    @Test
    public void testTransfer( ) {
        bankService.transfer( 1000.0, "account_1", "account_2" );
        Account originAccount = accountDao.findById( idOriginAccount );
        Account destinationAccount = accountDao.findById( idDestinationAccount );
        logger.debug("[Cantidades después de hacer la transferencia");
        printState();
    }

    @AfterTransaction
    public void after() {
        logger.debug("[Cantidades después de hacer rollback a la transacción");
        printState();
    }

    private void printState( ) {
       Account originAccount = accountDao.findById( idOriginAccount );
       Account destinationAccount = accountDao.findById( idDestinationAccount );
       amountOriginAccount = originAccount.getSavings();
       amountDestinationAccount = destinationAccount.getSavings();
       transactionLogsCounter = accountDao.countTransactionLogs();
       logger.debug( "dinero en cuenta 1 "  + amountOriginAccount );
       logger.debug( "dinero en cuenta 2 "  + amountDestinationAccount );
       logger.debug( "registros de bitacora "  + transactionLogsCounter );
    }
}
