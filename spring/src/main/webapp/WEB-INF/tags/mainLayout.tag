<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html lang="en"
	xmlns:c="http://java.sun.com/jsp/jstl/core"  
	xmlns:spring="http://www.springframework.org/tags" 
	xmlns:jsp="http://java.sun.com/JSP/Page">
	
	<head>
	    <meta charset="utf-8"/>
	    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
	    <meta name="viewport" content="width=device-width, initial-scale=1"/>
	    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	    <meta name="description" content=""/>
	    <meta name="author" content=""/>
	
	    <title>Log in with your account</title>
	
		<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.css" rel="stylesheet">
		<link href="${contextPath}/resources/css/bootstrap-rating.css" rel="stylesheet">
		<link href="${contextPath}/resources/css/font-awesome.css" rel="stylesheet">
		<style>
	      .custom-heart {
	        font-size: 2.5em;
	        color: red;
	      }
	    </style>
		<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    	<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    	
    	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
		<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${contextPath}/resources/js/bootstrap-rating.js"></script>
		
		<script type="text/javascript">
			
		</script>
	</head>

	<%-- <jsp:directive.attribute name="title" required="true" rtexprvalue="true" /> --%>
	<body>
		<div style="padding-top: 50px;">
		 <jsp:include page="${contextPath}/WEB-INF/tags/menu.jsp"/>
		 <jsp:doBody />
		 <jsp:include page="${contextPath}/WEB-INF/tags/footer.jsp"/>
		</div>
	</body>
</html>