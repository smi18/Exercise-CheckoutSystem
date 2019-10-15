package main.project;

import static org.junit.Assert.assertEquals;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import org.junit.jupiter.api.Test;

class CheckOutTest {

	@Test
	void testCalculatePriceWithOnlyOneProductInTheListReturnsPriceOfOneProduct() {
		ArrayList<Product> productList = new ArrayList<Product>();
		productList.add(new Product(ProductType.APPLE,null,0.60));
		productList.add(new Product(ProductType.ORANGE,null,0.25));
		CheckOut checkOut = new CheckOut(productList);
		
		ArrayList<ProductType> itemsInCartList = new ArrayList<ProductType>();
		itemsInCartList.add(ProductType.APPLE);
		
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.UK);
		Double price = 0.60;
		assertEquals(checkOut.calculateTotalPriceOfItemsInCart(itemsInCartList), currencyFormat.format(price));
	}

	@Test 
	void testCalculatePriceWithB1G1OfferReturnsTotalPriceOfAllProducts()
	{ 
		ArrayList<Product> productList = new ArrayList<Product>();
		productList.add(new Product(ProductType.APPLE,OfferType.B1G1,0.60));
		productList.add(new Product(ProductType.ORANGE,null,0.25));
		CheckOut checkOut = new CheckOut(productList);
	  
		ArrayList<ProductType> itemsInCartList = new ArrayList<ProductType>();
		itemsInCartList.add(ProductType.APPLE);
		itemsInCartList.add(ProductType.APPLE);
		itemsInCartList.add(ProductType.APPLE); 
		itemsInCartList.add(ProductType.ORANGE);
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.UK);
		Double price = (0.60*2)+0.25;
		assertEquals(checkOut.calculateTotalPriceOfItemsInCart(itemsInCartList), currencyFormat.format(price));
	  }
	  
	@Test 
	void testCalculatePriceWithNullProductInTheListReturnsTotalPriceOfAllProducts() 
	{
		ArrayList<Product> productList = new ArrayList<Product>();
		productList.add(new Product(ProductType.APPLE,OfferType.B2G1,0.60));
		productList.add(new Product(ProductType.ORANGE,OfferType.NONE,0.25));
		CheckOut checkOut = new CheckOut(productList);
		
		ArrayList<ProductType> itemsInCartList = new ArrayList<ProductType>();
		itemsInCartList.add(ProductType.APPLE);
		itemsInCartList.add(ProductType.APPLE);
		itemsInCartList.add(ProductType.APPLE); 
		itemsInCartList.add(null);
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.UK);
		Double price = 0.60*2;
		assertEquals(checkOut.calculateTotalPriceOfItemsInCart(itemsInCartList),currencyFormat.format(price));	
	}
	
	 @Test void testCalculatePriceWithOnlyNullInTheList() 
	 { 
		 ArrayList<Product> productList = new ArrayList<Product>();
		 productList.add(new Product(ProductType.APPLE,OfferType.B1G1,0.60));
		 productList.add(new Product(ProductType.ORANGE,OfferType.B1G1,0.25));
		 CheckOut checkOut = new CheckOut(productList);
			
		 ArrayList<ProductType> itemsInCartList = new ArrayList<ProductType>();
		 itemsInCartList.add(null);
		 itemsInCartList.add(null);
		 itemsInCartList.add(null);
		 NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.UK);
		 assertEquals(checkOut.calculateTotalPriceOfItemsInCart(itemsInCartList), currencyFormat.format(0));
	 } 
}