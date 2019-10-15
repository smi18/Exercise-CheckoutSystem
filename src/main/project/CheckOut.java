package main.project;

import java.util.EnumMap;
import java.util.List;

public class CheckOut {
	private EnumMap<ProductType, Double> priceMap ;
	
	CheckOut(EnumMap<ProductType, Double> map) {
		priceMap = map;
	}
	
	public double calculatePrice(List<ProductType> items) {
		double price = 0.0;
		for (ProductType item : items) {
			if(item!=null) 
				price += priceMap.get(item);
		}
		return price;
	}
}
