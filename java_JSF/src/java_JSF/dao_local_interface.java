package java_JSF;

import java.io.IOException;
import java.util.List;

import javax.ejb.Local;

@Local
public interface dao_local_interface 
{	
	abstract public String dao_search(String product_type, String name_of_product); // interface method type is abstract by definition, to clarify, here is specified
	 
	abstract public String dao_add(String product_type, String name_of_product, int product_quantity) throws IOException;
	
	abstract public String dao_delete(String product_type, String name_of_product, int product_quantity) throws IOException;
}
