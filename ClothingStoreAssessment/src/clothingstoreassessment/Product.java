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
public class Product {
    
    public int ProductId;
    public String ProductName;
    public Double Price;
    public int StockLevel;

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int ProductId) {
        this.ProductId = ProductId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double Price) {
        this.Price = Price;
    }

    public int getStockLevel() {
        return StockLevel;
    }

    public void setStockLevel(int StockLevel) {
        this.StockLevel = StockLevel;
    }
    
    
    public Product()
    {
    ProductId=0;
    ProductName="";
    Price=00.00;
    StockLevel=0;
    
    }
    
    public Product(String ProductNameIn, double PriceIn, int StockLevelIn)
    {
    ProductName= ProductNameIn;
    Price= PriceIn;
    StockLevel= StockLevelIn;
    
    }
    
     public Product(int ProductIdIn, String ProductNameIn, double PriceIn, int StockLevelIn)
    {
    ProductId= ProductIdIn;
    ProductName= ProductNameIn;
    Price= PriceIn;
    StockLevel= StockLevelIn;  
    }
    
}
