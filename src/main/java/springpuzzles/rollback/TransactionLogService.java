package springpuzzles.rollback;

/**
 * @author: ecamacho
 * javahispano 2010
 */
public interface TransactionLogService {

   void createLogForTransaction( Double amount, String fromAccount, String toAccount );
}
