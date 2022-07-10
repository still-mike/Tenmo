package Tests;

import com.techelevator.tenmo.dao.JdbcAccountDao;
import com.techelevator.tenmo.model.Account;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.math.BigDecimal;
import java.util.List;


public class JdbcAccountDaoTest extends BaseDaoTests {

    private static final Account ACCOUNT_1 = new Account(3001, 2001, BigDecimal.valueOf(1000.00));
    private static final Account ACCOUNT_2 = new Account(3002, 2002, BigDecimal.valueOf(1000.00));
    private static final Account ACCOUNT_3 = new Account(3003, 2003, BigDecimal.valueOf(1000.00));

    private Account testAccount;

    private JdbcAccountDao sut;


    @Before
    public void setup() {
        sut = new JdbcAccountDao(dataSource);
        testAccount = new Account(3004, 2004, BigDecimal.valueOf(500.00));
    }

    @Test
    public void find_account_by_id_returns_account(){
        Account account = sut.findByAccountID(3001);
        assertAccountsMatch(ACCOUNT_1, account);

        account = sut.findByAccountID(3002);
        assertAccountsMatch(ACCOUNT_2, account);

        account = sut.findByAccountID(3002);
        assertAccountsMatch(ACCOUNT_3, account);
    }

    private void assertAccountsMatch(Account expected, Account actual) {
        Assert.assertEquals(expected.getAccountID(), actual.getAccountID());
        Assert.assertEquals(expected.getUserID(), actual.getUserID());
        Assert.assertEquals(expected.getBalance(), actual.getBalance());


    }


}
