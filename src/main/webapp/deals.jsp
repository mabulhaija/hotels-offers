<!DOCTYPE html>
<%@page import="com.expedia.hotelsoffers.OfferInfoDTO"%>
<%@page import="java.util.List"%>
<html>
<title>Hotel Deals</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<body>

<h1 align="center" style="background-color: #e2cb1d;color: #3314ad;">Welcome To Expedia Hotels Offers</h1>
	<div class="w3-container w3-padding-16" id="contact">
		<h3 class="w3-border-bottom w3-border-light-grey w3-padding-16">Filters</h3>

		<form action="" method="get">
			<table style="width:100%;">
				<tr>
					<td><input class="w3-input" type="text"
						placeholder="Destination name" name="destinationName"></td>
					<td><input class="w3-input w3-section" type="number"
						placeholder="Length of stay" name="lengthOfStay"></td>
				</tr>
				<tr>
					<td><input class="w3-input w3-section" type="text"
						placeholder="Maximum trip start date (YYYY-MM-DD)" name="maxTripStartDate" pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))"></td>

					<td><input class="w3-input w3-section" type="text"
						placeholder="Minimum trip start date (YYYY-MM-DD)" name="minTripStartDate" pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))"></td>

				</tr>
				<tr>
					<td><input class="w3-input w3-section" type="number"
						placeholder="Maximum star rating" name="maxStarRating"></td>
					<td><input class="w3-input" type="number"
						placeholder="Minimum star rating" name="minStarRating"></td>
				</tr>
				<tr>
					<td><input class="w3-input w3-section" type="number"
						placeholder="Maximum total rate" name="maxTotalRate"></td>
					<td><input class="w3-input w3-section" type="number"
						placeholder="Minimum total rate" name="minTotalRate"></td>
				</tr>
				<tr>
					<td><input class="w3-input w3-section" type="number"
						placeholder="Maximum guest rating" name="maxGuestRating"></td>
					<td><input class="w3-input w3-section" type="number"
						placeholder="Minimum guest rating" name="minGuestRating"></td>
				</tr>
				<tr>
					<td><button class="w3-button w3-black w3-section"
							type="submit">SEARCH</button></td>
				</tr>
			</table>
		</form>
	</div>


	<div class="w3-container w3-padding-32" id="projects">
		<h3 class="w3-border-bottom w3-border-light-grey w3-padding-16">Offers</h3>
	</div>

	<%
		List<OfferInfoDTO> offers = (List<OfferInfoDTO>) request.getAttribute("offers");
		if (offers == null || offers.isEmpty()) {%>
		<p align="center" style="color: red">there are no offers match the applied filters</p>
		<%} else{ %>
	
	<div class="w3-row-padding">
		<%
			for (OfferInfoDTO offerInfo : offers) {
		%>



		<div class="w3-col l3 m6 w3-margin-bottom">

			<img src="<%=offerInfo.getImageURL()%>"
				alt="<%=offerInfo.getHotelName()%>" style="width: 100%">
			<h4><%=offerInfo.getHotelName()%></h4>
			<p style="color: blue">Rate <%=offerInfo.getStarRate()%>/5
			</p>
			<p class="w3-opacity"><%=offerInfo.getDestinationShortName()%></p>
			<p><%=offerInfo.getDestinationlongName()%></p>
			<p>
				<del><%=offerInfo.getOldPrice()%></del>
				<%=offerInfo.getCurrency()%>
			</p>
			<p>
				<%=offerInfo.getNewPrice()%>
				<%=offerInfo.getCurrency()%>
				<i style="color: red">save <%=offerInfo.getPercentSavings()%>%
				</i>
			</p>
			
				<a class="w3-button w3-light-grey w3-block" onclick="window.open(decodeURIComponent('<%=offerInfo.getDealURL()%>'))">more details</a>
			
		</div>
		<%
			}
		%>
		<%
			}
		%>


	</div>

</body>
</html>
