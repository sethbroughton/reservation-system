<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- Import the header --%>
<c:import url="/WEB-INF/jsp/common/header.jsp">
	<%--Set the page title by passing a parameter into the page --%>
	<c:param name="title">The Broughton Foundation</c:param>
</c:import>

<div class="container">

	<h1 class="title">Venue Reservation System</h1>

	<p class="subtitle">Select a venue</p>

	<main id="main-content">

		<c:forEach var="venue" items="${venues}">
			<div id="venue-detail">
				<a class="venue-image" href="venueDetail?id=${venue.id }"> <c:url
						var="imgVenue" value="/img/${venue.imageName }" /> <img
					src="${imgVenue}" />
				</a> <a href="venueDetail?id=${venue.id }">${venue.name}</a>
			</div>

		</c:forEach>

	</main>
</div>



<%-- import the footer --%>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />