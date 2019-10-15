package main.project;

import java.text.NumberFormat;
import java.util.EnumMap;
import java.util.List;
import java.util.Locale;

public class CheckOut {
	private EnumMap<ProductType, Product> productMap;

	CheckOut(List<Product> productList) {
		productMap = new EnumMap<ProductType, Product>(ProductType.class);
		for (Product product : productList) {
			productMap.put(product.getType(), product);
		}
	}

	public String calculateTotalPriceOfItemsInCart(List<ProductType> productsInCartList) {
		double price = 0.0;
		int productCount = 0;
		OfferType productOfferType;
		double productPrice;
		
		Locale currencyLocale = Locale.UK;
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(currencyLocale);
		
		for (ProductType type : productMap.keySet()) {
			productCount = (int)productsInCartList
							.stream()
							.filter(productType -> (productType == type)).count();
			productOfferType = productMap.get(type).getOffer();
			productPrice = productMap.get(type).getPrice();
			price += calculateTotalPriceForSimilarProductsAsPerOffer(productOfferType, productCount,productPrice);
		}
		return currencyFormat.format(price);
	}

	double calculateTotalPriceForSimilarProductsAsPerOffer(OfferType offerType, int count, double priceOfOneProduct) {
		
		long numberOfSimilarProductsAsPerOffer=count;
	
		if(offerType==null)
			offerType = OfferType.NONE;
		switch (offerType) {
			case B1G1:
					numberOfSimilarProductsAsPerOffer = (int) ((count / 2) + (count % 2));
					break;
			case B2G1:
					numberOfSimilarProductsAsPerOffer = (int) ((count / 3) + (count % 3)) * 2;
					break;
			case NONE:
					numberOfSimilarProductsAsPerOffer = count;
					break;
		}
		return priceOfOneProduct * numberOfSimilarProductsAsPerOffer;
	}

}
