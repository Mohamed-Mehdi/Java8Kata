import java.util.LinkedList;
import java.util.List;

/**
 * Created by MSA3513 on 17/08/2016.
 */

public class Account {

    private int solde = 0;
    private List<Transaction> listTransaction = new LinkedList<>();

    public Account() {
    }


    public int getSolde() {

        listTransaction.stream().filter(transaction -> transaction.getTypeTransaction().equals("DEPOSIT"))
                .forEach(transaction -> solde += transaction.getAmount());

        listTransaction.stream().filter(transaction -> transaction.getTypeTransaction().equals("WITHDRAW"))
                .forEach(transaction -> solde -= transaction.getAmount());

        return solde;
    }


    public List<Transaction> getListTransaction() {
        return listTransaction;
    }

    public void setListTransaction(List<Transaction> listTransaction) {
        this.listTransaction = listTransaction;
    }

    public void makeTransaction(Transaction transaction) {
        if (transaction.getAmount() > 0) {
            this.listTransaction.add(transaction);
        }
    }


    public List<String> getStatement() {
        List<String> statement = new LinkedList<>();
        statement.add("date||amount||balance");
        listTransaction.forEach(a ->
                statement.add(a.getDate() + "||" +a.getAmount() + "||" + this.getSolde()));
        return statement;
    }
}
