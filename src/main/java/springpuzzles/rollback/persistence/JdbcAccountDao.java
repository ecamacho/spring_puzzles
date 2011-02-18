package springpuzzles.rollback.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import springpuzzles.rollback.domain.Account;

import javax.sql.DataSource;

/**
 * @author: ecamacho
 * javahispano 2010
 */
@Repository("accountDao")
public class JdbcAccountDao implements AccountDao {

    private static final String FIND_BY_ID_QUERY = "SELECT * FROM ACCOUNT WHERE ACCOUNT_ID =?";

    private static final String UPDATE_ACCOUNT_QUERY = "UPDATE ACCOUNT SET SAVINGS = ? WHERE ACCOUNT_ID = ?";

    private static final String CREATE_TRANSACTION_LOG_QUERY = "INSERT INTO TRANSACTION_LOG VALUES (?,?,?,?)";

    private static final String COUNT_TRANSACTION_LOGS = "SELECT COUNT(*) FROM TRANSACTION_LOG";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcAccountDao ( DataSource dataSource ) {
        this.jdbcTemplate = new JdbcTemplate( dataSource );    
    }
    
    public Account findById(String id) {
       return jdbcTemplate.queryForObject(FIND_BY_ID_QUERY, new AccountRowMapper(), id);
    }

    public void update(Account account) {

        this.jdbcTemplate.update( UPDATE_ACCOUNT_QUERY, account.getSavings(), account.getId() );
    }


    public void saveTransactionLog( Double amount, String fromAccount, String toAccount ) {
        Long transactionNumber = nextTransactionNumber();
        this.jdbcTemplate.update(CREATE_TRANSACTION_LOG_QUERY, transactionNumber, amount,
                fromAccount, toAccount);
    }


    private Long nextTransactionNumber() {
		String sql = "select next value for S_TRANSACTION_NUMBER from DUAL_S_TRANSACTION_NUMBER";
		return jdbcTemplate.queryForObject(sql, Long.class);
	}


    public int countTransactionLogs( ) {

        return jdbcTemplate.queryForInt( COUNT_TRANSACTION_LOGS );
    }
}
