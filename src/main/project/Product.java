package main.project;

public class Product {
	private ProductType type;
	private OfferType offer;
	private double price;

	public Product(ProductType productType,OfferType offerType,double price) {
		this.type = productType;
		this.offer = offerType;
		this.price = price;
	}

	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

	public OfferType getOffer() {
		return offer;
	}

	public void setOffer(OfferType offer) {
		this.offer = offer;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}