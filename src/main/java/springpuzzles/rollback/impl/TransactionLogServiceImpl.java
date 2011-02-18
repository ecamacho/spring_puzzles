package springpuzzles.rollback.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import springpuzzles.rollback.TransactionLogService;
import springpuzzles.rollback.persistence.AccountDao;

/**
 * @author: ecamacho
 * javahispano 2010
 */
@Service("transactionLogService")
public class TransactionLogServiceImpl implements TransactionLogService {

    @Autowired
    private AccountDao accountDao;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createLogForTransaction(Double amount, String fromAccount,
                                        String toAccount) {
        accountDao.saveTransactionLog( amount, fromAccount, toAccount );
    }
}
