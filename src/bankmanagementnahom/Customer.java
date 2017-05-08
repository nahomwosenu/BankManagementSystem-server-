/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmanagementnahom;

/**
 *
 * @author Nahom
 */
public class Customer extends Person{
    private String accountNumber;
    
    public Customer(String firstName, String lastName,int age,String sex,String phone, String email, String city, String country,String account,String username) {
        super(firstName, lastName, username, phone, email, city, country, sex, age);
    }
    public static boolean addCustomer(String fn,String ln,int age,String sex,String phone,String email,String city,String country,String account,String username,String id){
      String query="insert into customer values('"+fn+"','"+ln+"','"+age+"','"+sex+"','"+phone+"','"+email+"','"+city+"','"+country+"','"+account+"','"+username+"','"+id+"')";       
      boolean b=DB.executeUpdate(query);
      return b;
    }
    public void setAccountNumber(String accountNumber){
        this.accountNumber=accountNumber;
    }
    public String getAccountNumber(){return this.accountNumber;}
    public static String[] getFirstNames(){
        String[] result=DB.getColumn("customer","firstname");
        return result;
    }
    public static String[] getLastNames(){
        String[] result=DB.getColumn("customer","lastname");
        return result;
    }
    public static String[] getAccounts(){
        String[] result=DB.getColumn("customer","accountno");
        return result;
    }
    public static String[] getIds(){
        String[] result=DB.getColumn("customer","id");
        return result;
    }
    public static String[][] getTable(){
        String[][] result=DB.getTable("customer",11);
        String[][] data=new String[result.length][12];
        for(int i=0;i<result.length;i++){
            if(result[i][0]==null || result[i][0].isEmpty())
                break;
            for(int j=0;j<11;j++){
                data[i][j]=result[i][j];
            }
            System.out.println("Account: "+result[i][8]);
            data[i][11]=String.valueOf(Account.getBalance(result[i][8]));
        }
        return data;
    }
    
    public static boolean setFirstName(String id,String firstname){
        String query="update customer set firstname='"+firstname+"' where id='"+id+"'";
        return DB.executeUpdate(query);
    }
    public static boolean setLastName(String id,String lastname){
        return DB.update("customer","lastname",lastname,"id='"+id+"'");
    }
    public static boolean setAge(String id,int age){
        return DB.update("customer","age",String.valueOf(age),"id='"+id+"'");
    }
    public static boolean setSex(String id,String sex){
        return DB.update("customer","sex",sex,"id='"+id+"'");
    }
    public static boolean setPhone(String id,String lastname){
        return DB.update("customer","phone",lastname,"id='"+id+"'");
    }
    public static boolean setCity(String id,String lastname){
        return DB.update("customer","city",lastname,"id='"+id+"'");
    }
    public static boolean setCountry(String id,String lastname){
        return DB.update("customer","country",lastname,"id='"+id+"'");
    }
    public static boolean setUsername(String id,String lastname){
        return DB.update("customer","username",lastname,"id='"+id+"'");
    }
    public static boolean setEmail(String id,String lastname){
        return DB.update("customer","email",lastname,"id='"+id+"'");
    }
    public static boolean setAccount(String id,String lastname){
        return DB.update("customer","accountno",lastname,"id='"+id+"'");
    }
    public static boolean setId(String id,String newId){
        return DB.update("customer","id",newId,"id='"+id+"'");
    }
}
