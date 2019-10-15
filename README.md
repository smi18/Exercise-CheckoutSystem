#Checkout System - A system to calculate the price of products in the shopping cart.

##Requirements
	Java 8 or higher
	
## Usage
	* Class ProductType - enum for products (like Apple, Orange). You will need to change this class, if you want to introduce a new product into the system.
	
	* EnumMap<ProductType, Double> priceMap = new EnumMap<ProductType, Double>(ProductType.class);
	  priceMap.put(ProductType.APPLE, 0.60);
	  priceMap.put(ProductType.ORANGE, 0.25);
		
	  CheckOut checkOut = new CheckOut(priceMap);
	  ArrayList<ProductType> itemsInCart = new ArrayList<ProductType>();
	  itemsInCart.add(ProductType.APPLE);
	  itemsInCart.add(ProductType.ORANGE);
	  double price = checkOut.calculatePrice(itemsInCart(;
	  