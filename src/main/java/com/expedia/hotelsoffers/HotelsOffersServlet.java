package com.expedia.hotelsoffers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HotelsOffersServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String DESTINATION_NAME_PARAM = "destinationName";
	private static final String MIN_TRIP_START_DATE_PARAM = "minTripStartDate";
	private static final String MAX_TRIP_START_DATE_PARAM = "maxTripStartDate";
	private static final String MIN_START_RATING_PARAM = "minStarRating";
	private static final String MAX_START_RATING_PARAM = "maxStarRating";
	private static final String MIN_TOTAL_RATE_PARAM = "minTotalRate";
	private static final String MAX_TOTAL_RATE_PARAM = "maxTotalRate";
	private static final String MIN_GUEST_RATING_PARAM = "minGuestRating";
	private static final String MAX_GUEST_RATING_PARAM = "maxGuestRating";
	private static final String LENGTH_OF_STAY_PARAM = "lengthOfStay";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Map<String, String> searchFilters = getRequestParameters(req);
		req.setAttribute("offers",new HotelsOffersBusiness().getOffersInfo(searchFilters));
		RequestDispatcher dispatcher = req.getRequestDispatcher("deals.jsp");
		dispatcher.forward(req, resp);

	}

	private Map<String, String> getRequestParameters(HttpServletRequest req) {
		Map<String, String> searchFilters = new HashMap<>();
		String destinationName = req.getParameter(DESTINATION_NAME_PARAM);
		String minTripStartDate = req.getParameter(MIN_TRIP_START_DATE_PARAM);
		String maxTripStartDate = req.getParameter(MAX_TRIP_START_DATE_PARAM);
		String minStarRating = req.getParameter(MIN_START_RATING_PARAM);
		String maxStarRating = req.getParameter(MAX_START_RATING_PARAM);
		String minTotalRate = req.getParameter(MIN_TOTAL_RATE_PARAM);
		String maxTotalRate = req.getParameter(MAX_TOTAL_RATE_PARAM);
		String minGuestRating = req.getParameter(MIN_GUEST_RATING_PARAM);
		String maxGuestRating = req.getParameter(MAX_GUEST_RATING_PARAM);
		String lengthOfStay = req.getParameter(LENGTH_OF_STAY_PARAM);
		
		
		if (destinationName != null && !destinationName.isEmpty()) {
			searchFilters.put(DESTINATION_NAME_PARAM, destinationName);
		}
		if (minTripStartDate != null && !minTripStartDate.isEmpty()) {
			searchFilters.put(MIN_TRIP_START_DATE_PARAM, minTripStartDate);
		}
		if (maxTripStartDate != null && !maxTripStartDate.isEmpty()) {
			searchFilters.put(MAX_TRIP_START_DATE_PARAM, maxTripStartDate);
		}
		
		if (minStarRating != null && !minStarRating.isEmpty()) {
			searchFilters.put(MIN_START_RATING_PARAM, minStarRating);
		}
		if (maxStarRating != null && !maxStarRating.isEmpty()) {
			searchFilters.put(MAX_START_RATING_PARAM, maxStarRating);
		}
		if (minTotalRate != null && !minTotalRate.isEmpty()) {
			searchFilters.put(MIN_TOTAL_RATE_PARAM, minTotalRate);
		}
		if (maxTotalRate != null && !maxTotalRate.isEmpty()) {
			searchFilters.put(MAX_TOTAL_RATE_PARAM, maxTotalRate);
		}
		if (minGuestRating != null && !minGuestRating.isEmpty()) {
			searchFilters.put(MIN_GUEST_RATING_PARAM, minGuestRating);
		}
		if (maxGuestRating != null && !maxGuestRating.isEmpty()) {
			searchFilters.put(MAX_GUEST_RATING_PARAM, maxGuestRating);
		}
		if (lengthOfStay != null && !lengthOfStay.isEmpty()) {
			searchFilters.put(LENGTH_OF_STAY_PARAM, lengthOfStay);
		}
		return searchFilters;
	}

}
