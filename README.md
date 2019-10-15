#Checkout System - A system to calculate the price of products in the shopping cart.

##Requirements
	Java 8 or higher
	
## Usage
	* Class ProductType - enum for products (like Apple, Orange). You will need to change this class, if you want to introduce a new product into the system.
	* Class OfferType - enum for offers (like Buy One Get One Free, Buy 2 Get 3 Free). You will need to change this class, if you want to introduce new offers.
	
	* ArrayList<Product> productList = new ArrayList<Product>();
	  productList.add(new Product(ProductType.APPLE,OfferType.B2G1,0.60));
	  productList.add(new Product(ProductType.ORANGE,OfferType.NONE,0.25));
	  //Passing a list of products to the checkout system.
	  CheckOut checkOut = new CheckOut(productList);
		
	  ArrayList<ProductType> itemsInCartList = new ArrayList<ProductType>();
	  itemsInCartList.add(ProductType.APPLE);
	  itemsInCartList.add(ProductType.APPLE);
	  itemsInCartList.add(ProductType.APPLE); 
	  double price = checkOut.calculateTotalPriceOfItemsInCart(itemsInCartList);
	  
	  // Price is formatted as per the locale of UK.
	  Locale currencyLocale = Locale.UK;
	  NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(currencyLocale);
	  currencyFormat.format(price);
		