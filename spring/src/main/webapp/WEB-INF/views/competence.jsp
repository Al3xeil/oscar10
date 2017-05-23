<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<t:mainLayout>
	<jsp:body>
		<div class="container">
		    <c:if test="${competences != null}">
				<div class="left-threequarters">
				  <h2>List all Skills</h2>
				  <div class="table-responsive">
						<table class="table table-bordered table-hover">
						    <thead>
						      <tr>
						        <th>Name</th>
						        <th>Description</th>
						        <th>Type</th>
						        <th>Category</th>
						        <th>Status</th>
						        <th>CU(s)</th>
						      </tr>
						    </thead>
						    <tbody>
						    	<c:forEach var="listValue" items="${competences}">
							      <tr class="clickable-row">
							        <td><a href="${contextPath}/competence/${listValue.id}">${listValue.name}</a></td>
							        <td><a href="${contextPath}/competence/${listValue.id}">${listValue.description}</a></td>
							        <td><a href="${contextPath}/competence/${listValue.id}">${listValue.type.name}</a></td>
							        <td><a href="${contextPath}/competence/${listValue.id}">${listValue.category.name}</a></td>
							        <td><a href="${contextPath}/competence/${listValue.id}">${listValue.status.name}</a></td>
							        <td>
							        	<c:if test="${listValue.competenceUnitMapping != null}">
								        	<c:forEach var="cus" items="${listValue.competenceUnitMapping}">
								        		${cus.name},
								        	</c:forEach>
								        </c:if>
							        </td>
							      </tr>
						     	</c:forEach>
						    </tbody>
						  </table>
					  </div>
					  <br>
					  <form:form class="form-horizontal" method="POST" 
					  			modelAttribute="competence">
						  <div class="form-group">
						    <label class="control-label col-sm-2" for="email">Name:</label>
						    <div class="col-sm-10">
						    	<form:input type="text" path="name" class="form-control" placeholder="Enter name"
	                            autofocus="true"></form:input>
						    </div>
						  </div>
						  <div class="form-group">
						    <label class="control-label col-sm-2" for="pwd">Description</label>
						    <div class="col-sm-10"> 
						    	<form:input type="text" path="description" class="form-control" placeholder="Enter description"></form:input>
						    </div>
						  </div>
						  <div class="form-group">
					        <label class="col-xs-3 control-label">Type</label>
					        <div class="col-xs-5 selectContainer">
					            <select class="form-control" name="type">
					            	<option value="">Choose a type</option>
					            	<c:forEach var="type" items="${types}">
					                	<option value="${type.id}">${type.name}</option>
					                </c:forEach>
					            </select>
					        </div>
					    </div>
						  <div class="form-group"> 
						    <div class="col-sm-offset-2 col-sm-10">
						      <button type="submit" class="btn btn-default">Submit</button>
						    </div>
						  </div>
						</form:form>
				</div>
		    </c:if>
		</div>
	</jsp:body>
</t:mainLayout>