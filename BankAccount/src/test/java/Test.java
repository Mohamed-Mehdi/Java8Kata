/**
 * Created by MSA3513 on 17/08/2016.
 */

import org.junit.Before;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class Test {

    private Account account;

    @Before
    public void init() {
        account = new Account();
    }

    @org.junit.Test
    public void testInitialSolde() {
        assertEquals(0, account.getSolde());
    }

    @org.junit.Test
    public void testDeposit() {
        Transaction transactionDeposit = new Transaction(1000, "DEPOSIT");
        account.makeTransaction(transactionDeposit);
        assertEquals(1000, account.getSolde());
    }


    @org.junit.Test
    public void testDepositWithNegatifAmount() {
        Transaction transactionDeposit = new Transaction(-1000, "DEPOSIT");
        account.makeTransaction(transactionDeposit);
        assertEquals(0, account.getSolde());
    }

    @org.junit.Test
    public void testWithdraw() {
        Transaction transactionDeposit = new Transaction(1000, "WITHDRAW");
        account.makeTransaction(transactionDeposit);
        assertEquals(-1000, account.getSolde());
    }

    @org.junit.Test
    public void testWithdrawWithNegatifAmount() {
        Transaction transactionDeposit = new Transaction(-1000, "WITHDRAW");
        account.makeTransaction(transactionDeposit);
        assertEquals(0, account.getSolde());
    }

    @org.junit.Test
    public void testTransaction() {
        Transaction transaction = new Transaction(1000, "DEPOSIT");
        assertEquals(1000, transaction.getAmount());
        assertEquals("DEPOSIT", transaction.getTypeTransaction());
    }

    @org.junit.Test
    public void testDepositAndWithdrawTransaction() {
        Transaction transactionDeposit = new Transaction(3000, "DEPOSIT");
        account.makeTransaction(transactionDeposit);
        Transaction transactionWithDraw = new Transaction(1000, "WITHDRAW");
        account.makeTransaction(transactionWithDraw);
        assertEquals(2000, account.getSolde());
    }

    @org.junit.Test
    public void testPrintingTheStatement() {
        Transaction transactionDeposit = new Transaction(5000, "DEPOSIT");
        account.makeTransaction(transactionDeposit);
        List<String> statementAccount = new LinkedList<>();
        statementAccount.add("date||amount||balance");
        statementAccount.add("17/08/2016||5000||5000");
        assertEquals(statementAccount, account.getStatement());
    }
}
