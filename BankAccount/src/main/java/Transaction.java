import java.util.Date;

/**
 * Created by MSA3513 on 17/08/2016.
 */
public class Transaction {

    private Date date;
    private int amount;
    private String typeTransaction;

    public Transaction() {
    }

    public Transaction(int amount, String typeTransaction) {
        this.date = new Date();
        this.amount = amount;
        this.typeTransaction = typeTransaction;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(String typeTransaction) {
        this.typeTransaction = typeTransaction;
    }
}
