<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- Import the header --%>
<c:import url="/WEB-INF/jsp/common/header.jsp">
	<%--Set the page title by passing a parameter into the page --%>
	<c:param name="title">The Broughton Foundation</c:param>
</c:import>

<div class="container">

<h1 class="title">Venue Reservation System</h1>

<p class="subtitle">Select Rate</p>

<main id="main-content">
<form method="POST">
<div class="field has-addons">

  <div class="control is-expanded">
    <div class="select is-fullwidth">

      <select name="rate">
      <c:forEach var="rate" items="${rates }">
        <option rate="${rate.name}">${rate.name}</option>
        </c:forEach>
      </select>
    </div>
  </div>
  <div class="control">
    <button type="submit" class="button is-primary">Choose</button>
  </div>
  
</div>
 </form>



</main>

</div>

	<%-- import the footer --%>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />