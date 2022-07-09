package Tests;

import com.techelevator.tenmo.dao.JdbcAccountDao;
import com.techelevator.tenmo.model.Account;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;

public class AccountTest extends BaseDaoTests {

    private static final Account ACCOUNT_1 = new Account(8888);

    private JdbcAccountDao sut;
    private Account account;

//    @Before
//    public void setup() {
//        sut = new JdbcAccountDao(dataSource);
//        account = new Account(9000, 9000, BigDecimal.valueOf(500));
//    }
//
//    @Test
//    public void getAccountByIDReturnsAccount(){
//        Account account = sut.findByAccountID(9999);
//        assertAccountsMatch("message here", 8888, 9999);
//    }
//
//    private void assertAccountsMatch(String message, Account expected, Account actual) {
//        Assert.assertEquals(message, expected.getAccountID(), actual.getAccountID());
//    }


}
