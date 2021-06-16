public class Account
{
    private String accountNumber;
    private String accountHolder;
    private String accountBalance;

    public Account()
    {

    }
    public Account(String number,String holder,String balance)
    {
        this.accountNumber=number;
        this.accountHolder=holder;
        this.accountBalance=balance;
    }
    public void setAccountNumber(String number)
    {
        this.accountNumber=number;
    }
    public String getAccountNumber()
    {
        return this.accountNumber;
    }
    public void setAccountBalance(String balance)
    {
        this.accountBalance=balance;
    }
    public String getAccountBalance()
    {
        return this.accountBalance;
    }
    public void setAccountHolder(String holder)
    {
        this.accountHolder=holder;
    }
    public String getAccountHolder()
    {
        return this.accountHolder;
    }
}