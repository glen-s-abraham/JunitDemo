package com.glen.JunitDemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ProductDAO {
	private List<Product> products = new ArrayList<>();
	
	private int getIndex(Long id)
	{
		for(int i=0;i<count();i++)
			if(products.get(i).getId()==id) return i;
		return -1;
	}
	
	public boolean addProduct(Long id,String name,Double qty,Double price)
	throws IllegalArgumentException
	{
		if(id<0 || id==null||name.equals(null)||name.length()<3||qty<0||price<0)
			throw new IllegalArgumentException("Invalid data values");
		products.add(new Product(id,name,qty,price));
		return true;
	}
	
	public boolean deleteProduct(Long id) {
		int index=getIndex(id);
		
		if(index!=-1) {	
			products.remove(index);
			return true;
		}	
		return false;
				
	}
	
	public Product findProductById(Long id) {
		int index=getIndex(id);
		if(index!=-1)return products.get(index);
		return null;
	}
	
	public int count() {
		return products.size();
	}
}

