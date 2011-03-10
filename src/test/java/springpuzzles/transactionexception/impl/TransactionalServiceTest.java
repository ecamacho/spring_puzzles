package springpuzzles.transactionexception.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springpuzzles.transactionexception.TransactionalService;

/**
 * @author: ecamacho
 * javahispano 2010
 */
@RunWith(SpringJUnit4ClassRunner.class )
@ContextConfiguration(locations = "classpath:springpuzzles/transactionexception/test-transactionexception-context.xml")
public class TransactionalServiceTest {


    @Autowired
    private TransactionalService transactionalService;


    /**
     * In this test the method process is marked as Transactional, this method
     * invokes another Transactional marked method in OtherTransactionalService.
     * This second method, throws a RuntimeExcepction that is caught inside the method
     * process.
     * However, even when the exception is caught, when the TransactionManager tries to
     * commit it, it will fail with a  UnexpectedRollbackException because when the exception was
     * thrown, the exception was marked as rollback-only.
     * You can fix this puzzle adding in the second method the attribute
     * noRollbackFor=BusinessException.class
     * This puzzle was submitted by Rafael Gutierrez @abaddon_gtz
     */
    @Test
    public void testOperation() {
        transactionalService.process();
    }
}
