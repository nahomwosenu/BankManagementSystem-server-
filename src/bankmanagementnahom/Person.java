/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmanagementnahom;


public abstract class Person {
     protected String firstName;
    protected String lastName;
    protected String username;
    protected String phone;
    protected String email;
    protected String city;
    protected String country;
    protected String sex;
    protected int age;
    protected User user;

    public Person(String firstName, String lastName, String username, String phone, String email, String city, String country, String sex, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.city = city;
        this.country = country;
        this.sex = sex;
        this.age = age;
    }
    public static Person findPerson(String username){
        String[] data=DB.getRow("customer",10,"username='"+username+"'");
        User u=User.findUser(username);
        Person p;
        System.out.println("Data: "+data[0]);
        if(data[0]!=null && !data[0].isEmpty()){
            if(u.getType()==u.getAdmin()){
                p=new Admin(data[0],data[1],data[2],data[3],data[4],data[5],data[6],data[7],Integer.parseInt(data[8]));
                p.user=u;
                System.out.println("Admin Account");
            }
            else{
               p=new Customer(data[0],data[1],Integer.parseInt(data[2]),data[3],data[4],data[5],data[6],data[7],data[8],data[9]);
               p.user=u;
               System.out.println("Normal Account");
            }
            return p;
        }
        return null;
    }
    public static Person findPersonById(String id){
        String[] data=DB.getRow("customer",10,"id='"+id+"'");
        
        Person p;
        System.out.println("Data: "+data[0]);
        if(data[0]!=null && !data[0].isEmpty()){
            
               p=new Customer(data[0],data[1],Integer.parseInt(data[2]),data[3],data[4],data[5],data[6],data[7],data[8],data[9]);
               return p;
            }
      return null; 
    }
    public static Person findPersonByName(String fn,String ln){
        String[] data=DB.getRow("customer",10,"firstname='"+fn+"' and lastname='"+ln+"'");
        
        Person p;
        System.out.println("Data: "+data[0]);
        if(data[0]!=null && !data[0].isEmpty()){
            
               p=new Customer(data[0],data[1],Integer.parseInt(data[2]),data[3],data[4],data[5],data[6],data[7],data[8],data[9]);
               return p;
            }
      return null; 
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
