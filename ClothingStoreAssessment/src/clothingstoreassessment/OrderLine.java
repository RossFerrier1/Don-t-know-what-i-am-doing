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
public class OrderLine 
{
  private int orderLineId;
    private Product product;
    private int quantity;
    private double lineTotal;
    
    public OrderLine(Order o, Product productIn)
    {
        orderLineId = o.generateUniqueOrderLineId();
       product = productIn;
        quantity = 1;
        lineTotal = product.getPrice() * quantity;
    }
    
    public int getOrderLineId(){return orderLineId;}
    public Product getProduct(){return product;}
    public int getQuantity(){return quantity;}
    public double getLineTotal(){return lineTotal;}
    
    public void setOrderLineId(int lineId){orderLineId = lineId;}
    public void setProduct(Product productIn){product= productIn;}
    public void setQuantity(int quantityIn){quantity = quantityIn;}
    public void setLineTotal(double total){lineTotal = total;}
    
    
          
}
