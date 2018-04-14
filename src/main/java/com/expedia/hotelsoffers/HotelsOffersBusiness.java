package com.expedia.hotelsoffers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * this class provides the needed methods to get the hotels offers
 *
 */
public class HotelsOffersBusiness {

	private static final String HOTEL_DEALS_URL = "https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel";

	/**
	 * this method collects information about hotels offers which filtered by the search filters.
	 * 
	 * @param searchFilters the submitted filters to be considered in the search
	 * 
	 * @return list of offers information
	 * 
	 */
	public List<OfferInfoDTO> getOffersInfo(Map<String,String> searchFilters){
		
		List<OfferInfoDTO> hotelsOffers = new ArrayList<>();
		JSONArray offers = requestOffers(searchFilters);
		
		for(Object hotelOffer : offers){
			
			JSONObject offerAsJSON = (JSONObject)hotelOffer;
			OfferInfoDTO hotelInfoDTO = new OfferInfoDTO();
			JSONObject hotelInfo = offerAsJSON.getJSONObject("hotelInfo");
			JSONObject hotelpricing = offerAsJSON.getJSONObject("hotelPricingInfo");
			
			hotelInfoDTO.setHotelName(hotelInfo.getString("hotelName"));
			hotelInfoDTO.setImageURL(hotelInfo.getString("hotelImageUrl"));
			hotelInfoDTO.setDestinationShortName(hotelInfo.getString("hotelDestination"));
			hotelInfoDTO.setDestinationlongName(hotelInfo.getString("hotelLongDestination"));
			hotelInfoDTO.setStarRate(hotelInfo.getFloat("hotelStarRating"));
			
			hotelInfoDTO.setNewPrice(hotelpricing.getLong("averagePriceValue"));
			hotelInfoDTO.setCurrency(hotelpricing.getString("currency"));
			hotelInfoDTO.setOldPrice(hotelpricing.getLong("originalPricePerNight"));
			hotelInfoDTO.setPercentSavings(hotelpricing.getLong("percentSavings"));
			
			hotelInfoDTO.setDealURL(offerAsJSON.getJSONObject("hotelUrls").getString("hotelSearchResultUrl"));
			
			hotelsOffers.add(hotelInfoDTO);
		}
		
		return(hotelsOffers);
	}

	/**
	 * request the hotels offers form a JSON API (URL) that presents a bunch of Hotel deals
	 * 
	 * @param searchFilters to be added as a query parameters to the JSON API URL
	 * 
	 * @return JSON array represents the offers
	 */
	private JSONArray requestOffers(Map<String, String> searchFilters) {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(HOTEL_DEALS_URL);
		for(String searchFilter : searchFilters.keySet()){
			webTarget = webTarget.queryParam(searchFilter,searchFilters.get(searchFilter));	
		}
		Response response = webTarget.request(MediaType.APPLICATION_JSON).get();
		String responseAsText = response.readEntity(String.class);
		JSONObject responseAsJSON = new JSONObject(responseAsText);
		JSONObject offers = responseAsJSON.getJSONObject("offers");
	
		if(offers.length()>0) {
			return offers.getJSONArray("Hotel");	
		}else {
			return new JSONArray();
		}
	}
}
