
package bankmanagementnahom;


public class Account {
    private String id;
    private String accountNumber;
    private double balance;

    public Account(String username, String accountNumber, double balance) {
        this.id = username;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public static Account findAccount(String id){
        String[] data=DB.getRow("account",3,"id='"+id+"'");
        if(data[0]!=null){
        Account ac=new Account(data[0],data[1],Double.parseDouble(data[2]));
        return ac;
        }
        return null;
    }
    public String getUsername() {
        return id;
    }

    public void setUsername(String username) {
        this.id = username;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public static double getBalance(String account) {
        String balance=DB.getResult("account","balance","accountnumber='"+account+"'");
        if(balance!=null && !balance.isEmpty())
            return Double.parseDouble(balance);
         return 0;
    }
    public static boolean deposite(String account,double ammount){
        double balance=getBalance(account);
        balance+=ammount;
        return DB.update("account","balance",String.valueOf(balance),"accountnumber='"+account+"'");
    }
    public static boolean withdraw(String account,double ammount){
        double balance=getBalance(account);
        if(balance<=ammount)
            return false;
        balance-=ammount;
        if(DB.update("account","balance",String.valueOf(balance),"accountnumber='"+account+"'"))
            return true;
        return false;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
}
