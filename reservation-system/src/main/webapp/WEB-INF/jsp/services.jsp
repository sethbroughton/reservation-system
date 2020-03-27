<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%-- Import the header --%>
<c:import url="/WEB-INF/jsp/common/header.jsp">
	<%--Set the page title by passing a parameter into the page --%>
	<c:param name="title">The Broughton Foundation</c:param>
</c:import>

<div class="container">

	<h1 class="title">Venue Reservation System</h1>

	<p class="subtitle">Select Additional Services</p>

	<main id="main-content">
		<form method="POST">
		<c:forEach items = "${services }" var="service">
			<div class="field is-horizontal">
				<div class="field-label">
					<label class="label"><c:out value = "${service.name }"/></label>
				</div>
				<div class="field-body">
					<div class="field">
						<div class="control">
							<label class="checkbox"> <input type="checkbox">
								<fmt:formatNumber value="${service.price }"
								type="currency" />
							</label>
						</div>
					</div>
				</div>
			</div>
			</c:forEach>
			<div class="control">
					<button type="submit" class="button is-primary">Submit</button>
				</div>
		</form>
	</main>

</div>

<%-- import the footer --%>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />