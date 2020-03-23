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

<c:forEach var="rate" items="${rates}">

${rate.name}

</c:forEach>

</main>

</div>

	<%-- import the footer --%>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />