public class Account {

    private String accountHolderName;
    private int accountNumber;
    private double balance;
    private String accountType;

    public Account( String accountHolderName,int accountNumber,double balance,String accountType){

        this.accountHolderName=accountHolderName;
        this.accountNumber=accountNumber;
        this.balance=balance;
        this.accountType=accountType;
    }


    public String getAccountHolderName(){
        return this.accountHolderName;
    }
    public void setAccountHolderName(String accountHolderName){
        this.accountHolderName=accountHolderName;
    }

    public int getAccountNumber(){
        return this.accountNumber;
    }
    public void setAccountNumber(int accountNumber){
        this.accountNumber=accountNumber;
    }

    public double getBalance(){
        return this.balance;
    }
    public void setBalance(double balance){
        this.balance=balance;
    }

    public String getAccountType(){
        return this.accountType;
    }
    public void setAccountType(String accountType){
        this.accountType=accountType;
    }

    @Override
    public String toString() {
        return "ACCOUNT HOLDER NAME : "+getAccountHolderName()+"\nACCOUNT NUMBER : "+getAccountNumber()+"\nBALANCE : "+getBalance()+"\nACCOUNT TYPE : "+getAccountType();
    }
}
