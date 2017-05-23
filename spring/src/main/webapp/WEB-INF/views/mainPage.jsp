<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<t:mainLayout>
	<jsp:body>
		<div class="container">
		    <c:if test="${pageContext.request.userPrincipal.name != null}">
				<div class="left-half">
				  <h2>My Skills</h2>
				  <div class="table-responsive">
						<table class="table table-bordered table-hover">
						    <thead>
						      <tr>
						        <th>Name</th>
						        <th>Description</th>
						        <th>Rating</th>
						      </tr>
						    </thead>
						    <tbody>
						    	<c:forEach var="listValue" items="${userForm.competenceRating}">
							      <tr class="clickable-row">
							        <td><a href="${contextPath}/competence/${listValue.competence.id}">${listValue.competence.name}</a></td>
							        <td>${listValue.competence.description}</td>
							        <td>
							        <input type="hidden" class="rating" value=${listValue.valueRating} data-start="0" data-stop="4"/>
							        </td>
							      </tr>
						     	</c:forEach>
						    </tbody>
						  </table>
					  </div>
					  <button class="account">
					      <span class="plus-text">Add Skills</span>
					  </button>
				</div>
		    </c:if>
		</div>
	</jsp:body>
</t:mainLayout>