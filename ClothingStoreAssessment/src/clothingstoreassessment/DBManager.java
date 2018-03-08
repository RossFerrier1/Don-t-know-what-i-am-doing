/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clothingstoreassessment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author 30207193
 */
public class DBManager {
    
    private final String dbVar = "jdbc:ucanaccess://H:\\object orientated HND\\ShopDB.accdb";
    
    
     public void updateProductAvailability(Product product)
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(dbVar);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("UPDATE Products SET Availability= " + product.getIsAvailable() +
                             " WHERE ProductId= '" + product.getProductId() + "'");
            conn.close();
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
    
    public void completeOrder(int orderId)
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(dbVar);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("UPDATE Orders SET Status= 'Complete', OrderDate= '" +
                             new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) +
                             "' WHERE OrderId= '" + orderId + "'");
            conn.close();
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
    
    public void deleteOrderLine(int orderId, int productId)
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(dbVar);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("DELETE FROM OrderLines WHERE ProductId = '" + 
                    productId + "' AND OrderId = '" + orderId + "'");
            conn.close();
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
    
    public void addOrderLine(OrderLine oLine, int orderId)
    {
        try
        {
             Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(dbVar);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("INSERT INTO OrderLines (OrderLineId, ProductId, Quantity, " +
                    "LineTotal, OrderId) VALUES ('" + oLine.getOrderLineId() + "','" + oLine.getProduct().getProductId() +
                     "','" + oLine.getQuantity() + "','" + oLine.getLineTotal()+ "','" + 
                    orderId + "')");
            conn.close();
            updateOrderTotal(orderId, oLine.getLineTotal());
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
    
    
    public void updateOrderTotal(int orderId, double lineTotal)
    {
        try
        {
             Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(dbVar);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("UPDATE Orders SET OrderTotal= OrderTotal + " + lineTotal +
                             " WHERE OrderId= '" + orderId + "'");
            conn.close();
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
    
    public int addOrder(String personId, Order o)
    {
        int orderId = 0;
        
        try
        {
             Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(dbVar);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("INSERT INTO Orders (OrderDate, User, OrderTotal, " +
                    "Status) VALUES ('" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(o.getOrderDate()) +
                    "','" + personId + "','" + o.getOrderTotal() + "','" + o.getStatus() + "')");
            
            ResultSet rs = stmt.getGeneratedKeys();
            
            if(rs.next())
            {
                orderId = rs.getInt(1);
            }
            
            conn.close();
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }   
        
        return orderId;
    }
    
    public void deleteUser(User user)
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(dbVar);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("DELETE FROM Users WHERE PersonId = '" + 
                    user.getPersonId() + "'");
            conn.close();
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
    
    public void deleteProduct(Product newProduct)
    {
        try
        {
             Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(dbVar);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("DELETE FROM Products WHERE ProductId = '" + 
                    newProduct.getProductId() + "'");
            conn.close();
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
    
    public void addProduct(Product newProduct)
    {
        //boolean canFly = false;
        String canFly = "NULL";
        String waterType = "";
        
        if(newProduct.getClass().getName().equals("models.Clothing"))
        {
            Clothing newClothing = (Clohting)newProduct;
          //  canFly = String.valueOf(newClothing.getCanFly());
        }
        else
        {
            Footwear newFootwear = (Footwear)newProduct;
          // waterType = newProuct getWaterType();
        }
        
        try
        {
             Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(dbVar);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("INSERT INTO Products (ProductName, service, price, stockLevel, " +
                    "Location, Availability, Cost) VALUES ('" + newProduct.getProductId() +
                    "','" + newProduct.getName() + "','" + newPrice.getType() + "','" +
                    newProduct.getStockLevel() +"','" + newProduct.getMeasurement() +  "',true,'" + newProduct.getPrice() + "')");
            
            conn.close();
            
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }  //fuuuuuuuckkkkkkkk!
    }
    
    
    public boolean registerCustomer(Customer newCustomer)
    {
        try
        {
             Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(dbVar);
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM CustomersWHERE PersonId = '" + newCustomer.getPersonId() + "'");
            if(rs.next())
            {
                conn.close();
                return false;
            }
            else
            {
                stmt.executeUpdate("INSERT INTO Customers(PersonId, PersonName, DateHired, Salary, PinNo, TelephoneNo, EmailAddress) " +
                    "VALUES ('" + newCustomer.getPersonId() + "','" + newCustomer.getName() + "','" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(newCustomer.getDateHired()) + "','" +
                            newCustomer.getSalary() + "','" + newCustomer.getPinNo() + "','" + newCustomer.getTelephoneNo() + "','" + 
                            newCustomer.getEmailAddress() + "')");
                conn.close();
                return true;
            }
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
            return false;
        }
    }
    
     public Staff staffLogIn(String idIn, String passwordIn)
    {
        try
        {
             Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(dbVar);
            Statement stmt = conn.createStatement();
           
            ResultSet rs = stmt.executeQuery("SELECT * FROM Staffs WHERE  = '" + idIn  + "' AND PinNo = '" + passwordIn + "'");
            
            if(!rs.next())
            {
                conn.close();
                return null;
            }
            else
            {
                String personId = rs.getString("PersonId");
                String name = rs.getString("PersonName");
                Date dateHired = rs.getDate("DateHired");
                double salary = rs.getDouble("Salary");
                int pinNo = rs.getInt("PinNo");
                boolean superUser = rs.getBoolean("SuperUser");
                
                conn.close();
                Staff staff = new Staff(personId, name, dateHired, 
                        salary, pinNo, superUser);
                return staff;
            }
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
            return null;
        }
    }
    
    
    
    public HashMap<String, Staff> loadStaffs()
    {
        HashMap<String, Staff> admins = new HashMap<>();
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = 
            DriverManager.getConnection(dbVar);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Staffs");
            
            while(rs.next())
            {
                String personId = rs.getString("PersonId");
                String name = rs.getString("PersonName");
                Date dateHired = rs.getDate("DateHired");
                double salary = rs.getDouble("Salary");
                int pinNo = rs.getInt("PinNo");
                boolean superUser = rs.getBoolean("SuperUser");
                
                Staff admin = new Staff(personId, name, dateHired, 
                    salary, pinNo, superUser);
                
                admins.put(personId, admin);
            }
            conn.close();
                
        }

        catch(Exception ex)
        {
           String message = ex.getMessage();
        }
        finally
        {
           return admins; 
        }
    }
    
    public HashMap<String, Customer> loadCustomers()
    {
        HashMap<String, Customer> keepers = new HashMap<>();
        try
        {
              Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(dbVar);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Customers");
            

            while(rs.next())
            {
                String personId = rs.getString("PersonId");
                String name = rs.getString("PersonName");
                Date dateHired = rs.getDate("DateHired");
                double salary = rs.getDouble("Salary");
                int pinNo = rs.getInt("PinNo");
                String telephoneNo = rs.getString("TelephoneNo");
                String emailAddress = rs.getString("EmailAddress");
                
                Customer Customer = new customer(personId, name, dateHired, 
                        salary, pinNo, telephoneNo, emailAddress);
                
                customers.put(personId, customer);
            }
            conn.close();
        }
        catch(Exception ex)
        {
           String message = ex.getMessage();
        }
        finally
        {
           return customers; 
        }
    }
    
    
    
    public Customer zooKeeperLogIn(String idIn, int passwordIn)
    {
        try
        {
              Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(dbVar);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM CustomersWHERE PersonId = '" + idIn  + "' AND PinNo = '" + passwordIn + "'");
            
            if(!rs.next())
            {
                conn.close();
                return null;
            }
            else
            {
                String personId = rs.getString("PersonId");
                String name = rs.getString("PersonName");
                Date dateHired = rs.getDate("DateHired");
                double salary = rs.getDouble("Salary");
                int pinNo = rs.getInt("PinNo");
                String telephoneNo = rs.getString("TelephoneNo");
                String emailAddress = rs.getString("EmailAddress");
                
                conn.close();
                Customer customer = new Customer(personId, name, dateHired, 
                        salary, pinNo, telephoneNo, emailAddress);
                return customer;
            }
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
            return null;
        }
    }
    
    //animals have animalID-int : hence <Integer, Product>
    public HashMap<Integer, Product> loadProducts()
    {
        HashMap<Integer, Product> animals = new HashMap();
        
        try
        {
              Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(dbVar);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Products");
            
            while(rs.next())
            {
                int animalId = rs.getInt("ProductId");
                String name = rs.getString("ProductName");
                int age = rs.getInt("Age");
                String type = rs.getString("Type");
                char gender = rs.getString("Gender").charAt(0);
                String location = rs.getString("Location");
                    
                String waterType = rs.getString("WaterType");
                
                boolean availability = rs.getBoolean("Availability");
                double cost = rs.getDouble("Cost");
                    
                if(waterType != null && !waterType.isEmpty())
                {
                    Fish loadedFish = new Fish(animalId, location, name, age, type, gender, waterType, availability, cost);
                    animals.put(animalId, loadedFish);
                }
                else
                {
                    boolean canFly = rs.getBoolean("CanFly");
                    Bird loadedBird = new Bird(animalId, location, name, age, type, gender, canFly, availability, cost);
                    animals.put(animalId, loadedBird);
                }
            }
            conn.close();
            return animals;
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
            return null;
        }
    }
    
    public void updateProduct(Product updateProduct)
    {
        String canFly = "NULL";
        String waterType = "";
        
        if(updateProduct.getClass().getName().equals("models.Bird"))
        {
            Bird updateBird = (Bird)updateProduct;
            canFly = String.valueOf(updateBird.getCanFly());
        }
        else
        {
            Fish updateFish = (Fish)updateProduct;
            waterType = updateFish.getWaterType();
        }
        
        try
        {
               Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(dbVar);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("UPDATE Products SET ProductName= '" + updateProduct.getName() + "', "
                    + "Age= '" + updateProduct.getAge() + "', Type= '" + updateProduct.getType() + "', "
                    + "Gender= '" + updateProduct.getGender() + "', Location= '" + updateProduct.getLocation() + "', "
                    + "CanFly= " + canFly + ", WaterType= '" + waterType + "', Cost= '" + updateProduct.getCost() + "' "
                            + "WHERE ProductId= '" + updateProduct.getProductId() + "'");
            conn.close();
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
    
    
    public void updateCustomer(Customer updateKeeper)
    {      
        try
        {
              Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(dbVar);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("UPDATE CustomersSET PersonName= '" + updateKeeper.getName() + "', "
                    + "DateHired= '" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(updateKeeper.getDateHired()) + "', " 
                    + "Salary= '" + updateKeeper.getSalary()+ "', "
                    + "PinNo= '" + updateKeeper.getPinNo()+ "', TelephoneNo= '" + updateKeeper.getTelephoneNo() + "', "
                    + "EmailAddress= '" + updateKeeper.getEmailAddress() + "' "
                            + "WHERE PersonId= '" + updateKeeper.getPersonId() + "'");
            conn.close();
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
    
    
}
