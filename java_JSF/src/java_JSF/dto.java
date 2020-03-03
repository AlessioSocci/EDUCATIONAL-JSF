package java_JSF;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named
public class dto 
{	 
    private String product_type;
    private String name_of_product;
    private int product_quantity;
    
    public String getProduct_type() 
    {
        return product_type;
    }

    public void setProduct_type(String product_type) 
    {
        this.product_type = product_type;
    }

    public String getName_of_product() 
    {
        return name_of_product;
    }

    public void setName_of_product(String name_of_product) 
    {
        this.name_of_product = name_of_product;
    }

	public int getProduct_quantity() 
	{
		return product_quantity;
	}

	public void setProduct_quantity(int product_quantity) 
	{
		this.product_quantity = product_quantity;
	}
}