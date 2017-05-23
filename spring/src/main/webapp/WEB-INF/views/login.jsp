<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<t:mainLayout>
	<jsp:body>
	    <form method="POST" action="${contextPath}/login" class="form-signin">
	        <h2 class="form-heading">Log in</h2>
	
	        <div class="form-group ${error != null ? 'has-error' : ''}">
	            <span>${message}</span>
	            <input name="username" type="text" class="form-control" placeholder="username"
	                   autofocus="true"/>
	            <input name="password" type="password" class="form-control" placeholder="password"/>
	            <span>${error}</span>
	            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	
	            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
	            <h4 class="text-center"><a href="${contextPath}/registration/">Create an account</a></h4>
	        </div>
	    </form>
	</jsp:body>
</t:mainLayout>
</body>
</html>