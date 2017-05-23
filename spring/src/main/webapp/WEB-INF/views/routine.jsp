<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Welcome</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css"
  href="http://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.min.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>
		
		<div class="container">
		  <h2>Routine ${routine.name} 's Exercises</h2>
			<table class="table table-bordered table-hover">
			    <thead>
			      <tr>
			        <th>Name</th>
			        <th>Description</th>
			        <th>Repetitions Default</th>
			      </tr>
			    </thead>
			    <tbody>
			    	<c:forEach var="routineExercise" items="${routine.routineExercice}">
				      <tr class="clickable-row">
				        <td><a href="${contextPath}/exercise/${routineExercise.exercice.id}">${routineExercise.exercice.name}</a></td>
				        <td>${routineExercise.exercice.description}</td>
				        <td>${routineExercise.exercice.defaultReps}</td>
				      </tr>
			     	</c:forEach>
			    </tbody>
			  </table>
			  <button class="account">
			      <h1 class="plus">
			        <i class="icon icon-plus-sign"></i>
			      </h1>
			      <span class="plus-text">Add Exercise</span>
			  </button>
		</div>
    </c:if>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>