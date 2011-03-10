package springpuzzles.transactionexception.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springpuzzles.transactionexception.OtherTransactionalService;
import springpuzzles.transactionexception.TransactionalService;
import springpuzzles.transactionexception.exception.BusinessException;
import springpuzzles.transactionexception.persistence.LogDao;

/**
 * @author: ecamacho
 * javahispano 2010
 */
@Service("transactionalService")
public class TransactionalServiceImpl implements TransactionalService {

    @Autowired
    private LogDao logDao;

    @Autowired
    private OtherTransactionalService otherService;

    @Transactional
    public void process() {
        try {
            otherService.processOperation();
        } catch ( BusinessException e) {
            e.printStackTrace();
        } 
        logDao.saveLogForOperation();
    }

}
