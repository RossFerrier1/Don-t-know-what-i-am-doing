/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clothingstoreassessment;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author 30207193
 */
public class Order 
{
    private int orderId;
    private Date orderDate;
    private double orderTotal;
    private String status;
    private HashMap<Integer, OrderLine> orderLines;
    
    public void removeOrderLine(int productId)
    {
        Iterator <Map.Entry<Integer, OrderLine>> iter = orderLines.entrySet().iterator();
        while(iter.hasNext())
        {
            Map.Entry<Integer, OrderLine> entry = iter.next();
            if(entry.getValue().getProduct().getProductId() == productlId)
            {
                iter.remove();
                orderTotal = orderTotal - entry.getValue().getLineTotal();
                
                DBManager db = new DBManager();
                db.deleteOrderLine(orderId, productId);
                db.updateOrderTotal(orderId, -entry.getValue().getLineTotal());
            }
        }
    }
    
    public void addOrderLine(OrderLine oLine)
    {
        orderTotal = orderTotal + oLine.getLineTotal();
        orderLines.put(oLine.getOrderLineId(), oLine);
        DBManager db = new DBManager();
        db.addOrderLine(oLine, orderId);
    }
    
    public int generateUniqueOrderLineId()
    {
        int orderLineId = 0;
        for(Map.Entry<Integer, OrderLine> orderLineEntry : orderLines.entrySet())
        {
            if(orderLines.containsKey(orderLineId))
            {
                orderLineId++;
            }
        }
        return orderLineId;
    }
    
    
    
    public Order()
    {
        orderId = 0;
        orderDate = new Date();
        orderTotal = 0;
        status = "New";
        orderLines = new HashMap<>();
    }
    
    public Order(int oId, Date oDate, double oTotal, String oStatus)
    {
        orderId = oId;
        orderDate = oDate;
        orderTotal = oTotal;
        status = oStatus;
        orderLines = new HashMap<>();
    }
    
    public int getOrderId(){return orderId;}
    public Date getOrderDate(){return orderDate;}
    public double getOrderTotal(){return orderTotal;}
    public String getStatus(){return status;}
    public HashMap<Integer, OrderLine> getOrderLines(){return orderLines;}
    
    public void setOrderId(int oId){orderId = oId;}
    public void setOrderDate(Date oDate){orderDate = oDate;}
    public void setOrderTotal(double oTotal){orderTotal = oTotal;}
    public void setStatus(String oStatus){status = oStatus;}
    public void setOrderLines(HashMap<Integer, OrderLine> oLines)
    {orderLines = oLines;}
    
    
}
