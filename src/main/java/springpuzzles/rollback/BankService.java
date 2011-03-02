package springpuzzles.rollback;


import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author: ecamacho
 * javahispano 2010
 */
public interface BankService {

    @Transactional( propagation = Propagation.REQUIRES_NEW )
    void transfer( Double amount, String fromAccount, String toAccount );
}
