/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clothingstoreassessment;
//package models;
import java.util.Date;

/**
 *
 * @author 30207193
 */
public class Staff extends User {
    private double Salary;
    private String Posistion;

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double SalaryIn) {
        this.Salary = SalaryIn;
    }

    public String getPosistion() {
        return Posistion;
    }

    public void setPosistion(String PosistionIn) {
        this.Posistion = PosistionIn;
    }
    
    
     private boolean superUser;
    
    public String displayGreeting()
    {
        String greeting = "<html>Welcome " + this.getFirstName() + "<br>";
        if(superUser)
        {
            greeting = greeting + "You are logged in as SuperUser</html>";
        }
        else
        {
            greeting = greeting + "You are NOT logged in as SuperUser</html>";
        }
        return greeting;
    }
    
    public boolean getSuperUser()
    {
        return superUser;
    }
    
    public void setSuperUser(boolean superUserIn)
    {
        superUser = superUserIn;
    }
    
    public Staff()
    {
        super();
        superUser = false;
    }
    
        public Staff(String UsernameIn, String PasswordIn, String FirstNameIn, String LastNameIn, boolean SuperUserIn)
    {
        super(UsernameIn, PasswordIn, FirstNameIn, LastNameIn);
        superUser = superUserIn;
    }
                                              
}
