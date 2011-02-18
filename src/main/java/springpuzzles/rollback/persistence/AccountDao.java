package springpuzzles.rollback.persistence;

import springpuzzles.rollback.domain.Account;

/**
 * @author: ecamacho
 * javahispano 2010
 */
public interface AccountDao {

    Account findById(String id);
    
    void update(Account account);

    void saveTransactionLog( Double amount, String fromAccount, String toAccount );

    int countTransactionLogs( );
}
