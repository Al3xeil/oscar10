<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<t:mainLayout>
	<jsp:body>
		<div class="container">
		    <c:if test="${competence != null}">
				<div class="left-threequarters">
				  <form:form class="form-horizontal" method="PUT" 
				  			modelAttribute="competence">
				  		<form:hidden path="id" value="${competence.id}"/>
					  <div class="form-group">
					    <label class="control-label col-sm-2" for="text">Name:</label>
					    <div class="col-sm-5">
					    	<form:input type="text" path="name" class="form-control" value="${competence.name}"/>
					    </div>
					  </div>
					  <div class="form-group">
					    <label class="control-label col-sm-2" for="text">Description</label>
					    <div class="col-sm-5"> 
					    	<form:input type="text" path="description" class="form-control" value="${competence.description}"/>
					    </div>
					  </div>
					  	<div class="form-group">
					        <label class="col-sm-2 control-label">Type</label>
					        <div class="col-xs-5 selectContainer">
					            <select class="form-control" name="type">
					            	<c:forEach var="type" items="${types}">
					            		<c:choose>
										    <c:when test="${type.id == competence.type.id}">
										        <option value="${type.id}" selected="selected">${type.name}</option>
										    </c:when>    
										    <c:otherwise>
										        <option value="${type.id}">${type.name}</option>
										    </c:otherwise>
										</c:choose>
					                </c:forEach>
					            </select>
					        </div>
				    	</div>
				    	<div class="form-group">
					        <label class="col-sm-2 control-label">Category</label>
					        <div class="col-xs-5 selectContainer">
					            <select class="form-control" name="category">
					            	<c:forEach var="category" items="${categories}">
					            		<c:choose>
										    <c:when test="${category.id == competence.category.id}">
										        <option value="${category.id}" selected="selected">${category.name}</option>
										    </c:when>    
										    <c:otherwise>
										        <option value="${category.id}">${category.name}</option>
										    </c:otherwise>
										</c:choose>
					                </c:forEach>
					            </select>
					        </div>
				    	</div>
				    	<div class="form-group">
					        <label class="col-sm-2 control-label">Status</label>
					        <div class="col-xs-5 selectContainer">
					            <select class="form-control" name="status">
					            	<c:forEach var="status" items="${statusAll}">
					            		<c:choose>
										    <c:when test="${status.id == competence.status.id}">
										        <option value="${status.id}" selected="selected">${status.name}</option>
										    </c:when>    
										    <c:otherwise>
										        <option value="${status.id}">${status.name}</option>
										    </c:otherwise>
										</c:choose>
					                </c:forEach>
					            </select>
					        </div>
				    	</div>
					  <div class="form-group"> 
					    <div class="col-sm-offset-2 col-sm-10">
					      <button type="submit" class="btn btn-default">Submit</button>
					      <button type="button" onclick="location.href='${contextPath}/competence/'" class="btn btn-default">Return</button>
					    </div>
					  </div>
					</form:form>
				</div>
		    </c:if>
		</div>
	</jsp:body>
</t:mainLayout>