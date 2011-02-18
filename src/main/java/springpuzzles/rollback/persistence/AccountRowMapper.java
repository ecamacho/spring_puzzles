package springpuzzles.rollback.persistence;

import org.springframework.jdbc.core.RowMapper;
import springpuzzles.rollback.domain.Account;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: ecamacho
 * javahispano 2010
 */
public class AccountRowMapper implements RowMapper<Account> {

    public Account mapRow(ResultSet rs, int i) throws SQLException {
        Account account = new Account();
        account.setId( rs.getString("account_id" ) );
        account.setSavings( rs.getDouble("savings"));
        return account;
    }
}
