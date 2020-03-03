package java_JSF;

import javax.ejb.Stateless;

import java.io.BufferedWriter;

//import org.apache.tomcat.jni.File;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

@Stateless
public class dao implements dao_local_interface
{
	boolean firstAccess = true;
	
	private List<String> lista_cancelleria = new ArrayList<String>();
	private List<String> lista_informatica = new ArrayList<String>();
	private List<String> lista_elettronica = new ArrayList<String>();
	private List<String> lista_ferramenta = new ArrayList<String>();
	
	private void loadFile()
	{
		try 
		{
			readFile("cancelleria", lista_cancelleria);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		try 
		{
			readFile("informatica", lista_informatica);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		try 
		{
			readFile("elettronica", lista_elettronica);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		try 
		{
			readFile("ferramenta", lista_ferramenta);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	

	private void writeOnFile(String fileName, String stringToAdd) throws IOException 
	{		
		File file = new File(fileName + ".txt"); 
		
		FileWriter filewriter = new FileWriter(file, true); 
					
		PrintWriter fileprint = new PrintWriter(filewriter);
		
		fileprint.println(stringToAdd);
		
		fileprint.close();
	}

	
	private void deleteOnFile(String fileName, String stringToDelete) throws IOException 
	{			
		switch (fileName)
		{
			case "cancelleria":
				
				File file = new File(fileName + ".txt");
				
				file.delete();
														
				ListIterator<String>  list_iterator;
				
				list_iterator = lista_cancelleria.listIterator(0); 
				
				while (list_iterator.hasNext())	
				{
					writeOnFile(fileName, list_iterator.next());
				}		
				break;
				
			case "informatica":
				
				file = new File(fileName + ".txt");
				
				file.delete();
				
				list_iterator = lista_informatica.listIterator(0); 
				
				while (list_iterator.hasNext())	
				{
					writeOnFile(fileName, list_iterator.next());
				}		
				
			case "elettronica":
				
				file = new File(fileName + ".txt");
				
				file.delete();
				
				list_iterator = lista_elettronica.listIterator(0); 
				
				while (list_iterator.hasNext())	
				{
					writeOnFile(fileName, list_iterator.next());
				}	
				
			case "ferramenta":
				
				file = new File(fileName + ".txt");
				
				file.delete();
				
				list_iterator = lista_ferramenta.listIterator(0); 
				
				while (list_iterator.hasNext())	
				{
					writeOnFile(fileName, list_iterator.next());
				}		
		}		
}
	
	
	public List<String> readFile(String fileName, List<String> listName) throws IOException 
	{
		File file = new File(fileName + ".txt"); 
		
		FileReader reader;
		
		try 
		{
			reader = new FileReader(file);
	
			Scanner FileScan = new Scanner(reader);
		
			int i = 0;
			
			while(FileScan.hasNextLine())
			{   
				 listName.add(i, FileScan.nextLine()); 
				
				 i++;
			}		
			
			FileScan.close();
			reader.close();	
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		return listName;
	}
	
	
    public String dao_search(String product_type, String name_of_product) 
    {
    	if(firstAccess)
    	{
    		firstAccess = false;
    		
    		loadFile();
    	}
    	
    	int quantity = 0;
		
		ListIterator<String>  list_iterator;
    	
    	switch (product_type)
    	{
    		case "cancelleria":
    				
    			list_iterator = lista_cancelleria.listIterator(0); 
	    			
    			while (list_iterator.hasNext())
    			{
    				if(list_iterator.next().equals(name_of_product))
    				{
    					quantity++;
    				}
    			}
	    			
    			if(quantity != 0)
    			{
    				return "there are " + quantity + " products with name";
    			}
    			else
    			{
    				return "there aren't products with name: ";
    			}	
    			
    		case "informatica":
    		
    			list_iterator = lista_informatica.listIterator(0); 
	    			
    			while (list_iterator.hasNext())
    			{
    				if(list_iterator.next().equals(name_of_product))
    				{
    					quantity++;
    				}
    			}
	    			
    			if(quantity != 0)
    			{
    				return "there are " + quantity + " products with name";
    			}
    			else
    			{
    				return "there aren't products with name: ";
    			}	
    	
        		
    		case "elettronica":
    			
    			list_iterator = lista_elettronica.listIterator(0); 
    			
    			while (list_iterator.hasNext())
    			{
    				if(list_iterator.next().equals(name_of_product))
    				{
    					quantity++;
    				}
    			}
	    			
    			if(quantity != 0)
    			{
    				return "there are " + quantity + " products with name";
    			}
    			else
    			{
    				return "there aren't products with name: ";
    			}	
    	
    	    		
    		case "ferramenta":
    			
    			list_iterator = lista_ferramenta.listIterator(0); 
    			
    			while (list_iterator.hasNext())
    			{
    				if(list_iterator.next().equals(name_of_product))
    				{
    					quantity++;
    				}
    			}
	    			
    			if(quantity != 0)
    			{
    				return "there are " + quantity + " products with name";
    			}
    			else
    			{
    				return "there aren't products with name: ";
    			}	
    	}
    	return "there aren't products with name: ";	
    }
	
    
	public String dao_add(String product_type, String name_of_product, int product_quantity) throws IOException 
	{	
		int i = 0;
		
		for(i = 0; i < product_quantity; i++)
		{
			switch (product_type)
		    {
		    	case "cancelleria":
		    		
		    		if(lista_cancelleria.add(name_of_product))		
	    			{
	    				writeOnFile(product_type, name_of_product);		
	    			}
	    			else
	    			{
	    				return "not inserted";
	    			}	
		    		break;
		    		
		    	case "informatica":
		    		
		    		if(lista_informatica.add(name_of_product))		
		    		{
		    			writeOnFile(product_type, name_of_product);		
		    		}
		    		else
		    		{
		    			return "not inserted";
		    		}	
		    		break;
		    			      		
		    	case "elettronica":
		    	
		    		if(lista_elettronica.add(name_of_product))		
		    		{
		    			writeOnFile(product_type, name_of_product);		
		    		}
		    		else
		    		{
		    			return "not inserted";
		    		}	
		    		break;
		    		
		    	case "ferramenta":
		    		
		    		if(lista_ferramenta.add(name_of_product))		
		    		{
		    			writeOnFile(product_type, name_of_product);		
		    		}
		    		else
		    		{
		    			return "not inserted";
		    		}	
		    		break;
		    }
	    }
		return "inserted n. " + i;
	}
    
	
    public String dao_delete(String product_type, String name_of_product, int product_quantity) throws IOException 
    {	    	
    	int quantity = 0;
		
		ListIterator<String>  list_iterator;
    	
    	int i = 0;
		
		for(i = 0; i < product_quantity; i++)
		{	
			switch (product_type)
		    {
		    	case "cancelleria":
		    		
		    		list_iterator = lista_cancelleria.listIterator(0); 
	    			
	    			while (list_iterator.hasNext())
	    			{
	    				if(list_iterator.next().equals(name_of_product))
	    				{
	    					quantity++;
	    				}
	    			}
	    			if(product_quantity > quantity)
	    			{
	    				System.out.println("there arent this quantity..");
	    				
	    				return "there arent this quantity of ";
	    			}
		    		
	    			else if(lista_cancelleria.remove(name_of_product))		
			    	{	
		    			deleteOnFile(product_type, name_of_product);	
		    			
			    		System.out.println("deleted one");
			    	}
			    	else
			    	{
			    		return "not deleted";
			    	}
		    		
		    		break;
		    		
		    	case "informatica":
		    		
		    		list_iterator = lista_informatica.listIterator(0); 
	    			
	    			while (list_iterator.hasNext())
	    			{
	    				if(list_iterator.next().equals(name_of_product))
	    				{
	    					quantity++;
	    				}
	    			}
	    			if(product_quantity > quantity)
	    			{
	    				System.out.println("there arent this quantity..");
	    				
	    				return "there arent this quantity of ";
	    			}
		    		
	    			else if(lista_informatica.remove(name_of_product))		
			    	{	
		    			deleteOnFile(product_type, name_of_product);	
		    			
			    		System.out.println("deleted one");
			    	}
			    	else
			    	{
			    		return "not deleted";
			    	}
		    		
		    		break;
		    			      		
		    	case "elettronica":
		    		
		    		list_iterator = lista_elettronica.listIterator(0); 
	    			
	    			while (list_iterator.hasNext())
	    			{
	    				if(list_iterator.next().equals(name_of_product))
	    				{
	    					quantity++;
	    				}
	    			}
	    			if(product_quantity > quantity)
	    			{
	    				System.out.println("there arent this quantity..");
	    				
	    				return "there arent this quantity of ";
	    			}
		    		
	    			else if(lista_elettronica.remove(name_of_product))		
			    	{	
		    			deleteOnFile(product_type, name_of_product);	
		    			
			    		System.out.println("deleted one");
			    	}
			    	else
			    	{
			    		return "not deleted";
			    	}
		    		
		    		break;
		    		
		    	case "ferramenta":
	
		    		list_iterator = lista_ferramenta.listIterator(0); 
	    			
	    			while (list_iterator.hasNext())
	    			{
	    				if(list_iterator.next().equals(name_of_product))
	    				{
	    					quantity++;
	    				}
	    			}
	    			if(product_quantity > quantity)
	    			{
	    				System.out.println("there arent this quantity..");
	    				
	    				return "there arent this quantity of ";
	    			}
	    			else if(lista_ferramenta.remove(name_of_product))		
			    	{	
		    			deleteOnFile(product_type, name_of_product);	
		    			
			    		System.out.println("deleted one");
			    	}
			    	else
			    	{
			    		return "not deleted";
			    	}
		    	
		    		break;
		    }
		}
		
		return "deleteded n. " + i;
    }

	

}