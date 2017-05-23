<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<t:mainLayout>
	<jsp:body>
	    <form:form method="POST" modelAttribute="userForm" class="form-signin">
	        <h2 class="form-signin-heading">Create your account</h2>
	        <spring:bind path="username">
	            <div class="form-group ${status.error ? 'has-error' : ''}">
	                <form:input type="text" path="username" class="form-control" placeholder="Username"
	                            autofocus="true"></form:input>
	                <form:errors path="username"></form:errors>
	            </div>
	        </spring:bind>
	
	        <spring:bind path="password">
	            <div class="form-group ${status.error ? 'has-error' : ''}">
	                <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
	                <form:errors path="password"></form:errors>
	            </div>
	        </spring:bind>
	
	        <spring:bind path="passwordconFirm">
	            <div class="form-group ${status.error ? 'has-error' : ''}">
	                <form:input type="password" path="passwordconFirm" class="form-control"
	                            placeholder="Confirm your password"></form:input>
	                <form:errors path="passwordconFirm"></form:errors>
	            </div>
	        </spring:bind>
	
	        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
	    </form:form>
	</jsp:body>
</t:mainLayout>
</body>
</html>