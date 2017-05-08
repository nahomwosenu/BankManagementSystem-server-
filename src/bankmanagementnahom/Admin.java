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
public class Admin extends Person{
    

    public Admin(String firstName, String lastName, String username, String phone, String email, String city, String country, String sex, int age) {
        super(firstName,lastName,username,phone,email,city,country,sex,age);
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

    
    
}
