/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clothingstoreassessment;

/**
 *
 * @author 30207193
 */
public class User {
    
    public String Username;
    public String Password;
    public String firstName;
    public String lastName;
    
    
    
    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
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
   
    public User()
    {
    
        Username = "";
        Password = "";
        firstName = "";
        lastName ="";
        
    
    
    }
    public User(String UsernameIn, String PasswordIn, String FirstNameIn, String LastNameIn)
    {
        
        Username= UsernameIn;
        Password= PasswordIn;
        firstName= FirstNameIn;
        lastName= LastNameIn;
        
        
        
        
    }
    
}
