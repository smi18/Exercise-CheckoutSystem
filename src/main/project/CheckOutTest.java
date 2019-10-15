package main.project;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.EnumMap;

import org.junit.jupiter.api.Test;

class CheckOutTest {

	@Test
	void testCalculatePriceWithOnlyOneProductInTheListReturnsPriceOfOneProduct() {
		EnumMap<ProductType, Double> priceMap = new EnumMap<ProductType, Double>(ProductType.class);
		priceMap.put(ProductType.APPLE, 0.60);
		priceMap.put(ProductType.ORANGE, 0.25);
		
		CheckOut checkOut = new CheckOut(priceMap);
		ArrayList<ProductType> list = new ArrayList<ProductType>();
		list.add(ProductType.APPLE);
		assertEquals(new Double(checkOut.calculatePrice(list)), new Double(0.60));
	}

	@Test
	void testCalculatePriceWithDifferentProductsInTheListReturnsTotalPriceOfAllProducts() {
		EnumMap<ProductType, Double> priceMap = new EnumMap<ProductType, Double>(ProductType.class);
		priceMap.put(ProductType.APPLE, 0.60);
		priceMap.put(ProductType.ORANGE, 0.25);
		
		CheckOut checkOut = new CheckOut(priceMap);
		ArrayList<ProductType> list = new ArrayList<ProductType>();
		list.add(ProductType.APPLE);
		list.add(ProductType.APPLE);
		list.add(ProductType.APPLE);
		list.add(ProductType.APPLE);
		list.add(ProductType.ORANGE);
		assertEquals(new Double(checkOut.calculatePrice(list)), new Double(0.60*4+0.25));
	}
	
	@Test
	void testCalculatePriceWithNullProductInTheListReturnsTotalPriceOfAllProducts() {
		EnumMap<ProductType, Double> priceMap = new EnumMap<ProductType, Double>(ProductType.class);
		priceMap.put(ProductType.APPLE, 0.60);
		priceMap.put(ProductType.ORANGE, 0.25);
		
		CheckOut checkOut = new CheckOut(priceMap);
		ArrayList<ProductType> list = new ArrayList<ProductType>();
		list.add(ProductType.APPLE);
		list.add(ProductType.APPLE);
		list.add(ProductType.APPLE);
		list.add(ProductType.APPLE);
		list.add(ProductType.ORANGE);
		list.add(null);
		assertEquals(new Double(checkOut.calculatePrice(list)), new Double(0.60*4+0.25));
	}
	
	@Test
	void testCalculatePriceWithOnlyNullInTheList() {
		EnumMap<ProductType, Double> priceMap = new EnumMap<ProductType, Double>(ProductType.class);
		priceMap.put(ProductType.APPLE, 0.60);
		priceMap.put(ProductType.ORANGE, 0.25);
		
		CheckOut checkOut = new CheckOut(priceMap);
		ArrayList<ProductType> list = new ArrayList<ProductType>();
		list.add(null);
		assertEquals(new Double(checkOut.calculatePrice(list)), new Double(0));
	}
}
