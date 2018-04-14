package com.expedia.hotelsoffers;

/**
 * Data Transfer Object sets and gets the required information about offers
 *
 */
public class OfferInfoDTO {

	private String hotelName;
	private String imageURL;
	private String lengthOfStay;
	private String dealURL;
	private String destinationShortName;
	private String destinationlongName;
	private String currency;
	private long newPrice;
	private long oldPrice;
	private long percentSavings;
	private float starRate;

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public long getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(long price) {
		this.newPrice = price;
	}

	public String getLengthOfStay() {
		return lengthOfStay;
	}

	public void setLengthOfStay(String lengthOfStay) {
		this.lengthOfStay = lengthOfStay;
	}

	public String getDealURL() {
		return dealURL;
	}

	public void setDealURL(String dealURL) {
		this.dealURL = dealURL;
	}

	public String getDestinationShortName() {
		return destinationShortName;
	}

	public void setDestinationShortName(String destinationShortName) {
		this.destinationShortName = destinationShortName;
	}

	public String getDestinationlongName() {
		return destinationlongName;
	}

	public void setDestinationlongName(String destinationlongName) {
		this.destinationlongName = destinationlongName;
	}

	public long getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(long oldPrice) {
		this.oldPrice = oldPrice;
	}

	public long getPercentSavings() {
		return percentSavings;
	}

	public void setPercentSavings(long percentSavings) {
		this.percentSavings = percentSavings;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public float getStarRate() {
		return starRate;
	}

	public void setStarRate(float starRate) {
		this.starRate = starRate;
	}

}
