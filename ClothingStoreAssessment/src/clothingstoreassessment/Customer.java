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
public class Customer extends User
{
     private String AddressLine1;
         private String AddressLine2;
            private String Town;
         private String Postcode;

    public String getAddressLine1() {
        return AddressLine1;
    }

    public void setAddressLine1(String AddressLine1In) {
        this.AddressLine1 = AddressLine1In;
    }

    public String getAddressLine2() {
        return AddressLine2;
    }

    public void setAddressLine2(String AddressLine2In) {
        this.AddressLine2 = AddressLine2In;
    }

    public String getTown() {
        return Town;
    }

    public void setTown(String TownIn) {
        this.Town = TownIn;
    }

    public String getPostcode() {
        return Postcode;
    }

    public void setPostcode(String PostcodeIn) {
        this.Postcode = PostcodeIn;
    }
   
    
    public Customer()
    {
    AddressLine1 ="";
    AddressLine2="";
    Town = "";
    Postcode = "";
            
    }
    
    
    public Customer(String AddressLine1In, String AddressLine2In, String TownIn, String PostcodeIn)
    {
    AddressLine1 =AddressLine1In;
    AddressLine2=AddressLine2In;
    Town = TownIn;
    Postcode = PostcodeIn;
            
    }
    
    
    
         
}
