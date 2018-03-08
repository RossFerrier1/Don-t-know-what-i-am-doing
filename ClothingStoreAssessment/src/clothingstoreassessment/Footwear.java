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
public class Footwear extends Product
{

    private int Size;

    public int getSize() {
        return Size;
    }

    public void setSize(int SizeIn) {
        this.Size = Size;
        ProductId =0;
ProductName= "";
Price= 00.00;
StockLevel = 0;
    }


public Footwear()
{

Size = 0;

}

public Footwear(int SizeIn, int ProductIdIn, String ProductNameIn, double PriceIn, int StockLevelIn)
{

Size = SizeIn;
ProductId =ProductIdIn;
ProductName= ProductNameIn;
Price= PriceIn;
StockLevel = StockLevelIn;
        

}


    
}
