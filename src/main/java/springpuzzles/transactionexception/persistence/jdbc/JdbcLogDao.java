package springpuzzles.transactionexception.persistence.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import springpuzzles.transactionexception.persistence.LogDao;

import javax.sql.DataSource;
import java.util.Date;

/**
 * @author: ecamacho
 * javahispano 2010
 */
@Repository("jdbcLogDao")
public class JdbcLogDao implements LogDao {

    private static final String SAVE_TRANSACTION_LOG_QUERY = "INSERT INTO TRANSACTION_LOG VALUES (?,?)";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcLogDao( DataSource dataSource ) {
        this.jdbcTemplate = new JdbcTemplate( dataSource );    
    }



    public void saveLogForOperation() {
        Long transactionNumber = nextTransactionNumber();
        this.jdbcTemplate.update(SAVE_TRANSACTION_LOG_QUERY, transactionNumber,"New transaction saved");
    }

    private Long nextTransactionNumber() {
		String sql = "select next value for S_TRANSACTION_NUMBER from DUAL_S_TRANSACTION_NUMBER";
		return jdbcTemplate.queryForObject(sql, Long.class);
	}
}
