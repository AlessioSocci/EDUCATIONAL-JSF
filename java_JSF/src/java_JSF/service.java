package java_JSF;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class service 
{
	@Inject
	dao_local_interface dao_object;
	 
	@Inject
	dto dto_object;
	
	private String search_result = null;
	private String add_result = null; 
	private String delete_result = null; 
	

	public String getSearch_result() 
	{
		return search_result;
	}

	public void setSearch_result(String search_result) 
	{
		this.search_result = search_result;
	}

	public String getAdd_result() 
	{
		return add_result;
	}

	public void setAdd_result(String add_result) 
	{
		this.add_result = add_result;
	}
	
	public String getDelete_result() 
	{
		return delete_result;
	}

	public void setList_result(String delete_result) 
	{
		this.delete_result = delete_result;
	}

	
	public String search() 
	{
		search_result = dao_object.dao_search(dto_object.getProduct_type(), dto_object.getName_of_product());
	        
		return "search_result";
	}
	
	
	public String add() 
	{
		try 
		{
			add_result = dao_object.dao_add(dto_object.getProduct_type(), dto_object.getName_of_product(), dto_object.getProduct_quantity());
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	        
		return "add_result";
	}
	
	
	public String delete() 
	{
		try 
		{
			delete_result = dao_object.dao_delete(dto_object.getProduct_type(), dto_object.getName_of_product(), dto_object.getProduct_quantity());
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	        
		return "list_result";
	}
	
}
