package springpuzzles.rollback.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springpuzzles.rollback.BankService;
import springpuzzles.rollback.TransactionLogService;
import springpuzzles.rollback.domain.Account;
import springpuzzles.rollback.persistence.AccountDao;

/**
 * @author: ecamacho
 * javahispano 2010
 */
@Service("bankService")
public class BankServiceImpl implements BankService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private TransactionLogService transactionLogService;

    @Transactional
    public void transfer( Double amount, String fromAccount, String toAccount ) {
        Account originAccount = accountDao.findById( fromAccount );
        Account destinationAccount = accountDao.findById( toAccount );

        originAccount.setSavings( originAccount.getSavings() - amount );
        destinationAccount.setSavings( destinationAccount.getSavings() + amount );

        accountDao.update( originAccount );
        accountDao.update( destinationAccount );

        transactionLogService.createLogForTransaction( amount, fromAccount, toAccount);
    }
}
