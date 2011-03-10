package springpuzzles.transactionexception.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springpuzzles.transactionexception.OtherTransactionalService;
import springpuzzles.transactionexception.exception.BusinessException;

/**
 * @author: ecamacho
 * javahispano 2010
 */
@Service("otherTransactionalService")
public class OtherTransactionalServiceImpl implements OtherTransactionalService {

    @Transactional
    public void processOperation() {
        throw new BusinessException( "something went wrong" );
    }
    
}
