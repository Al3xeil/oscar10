 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form id="logoutForm" method="POST" action="${contextPath}/logout">
   <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
 <nav id="header" class="navbar navbar-fixed-top">
     <div id="header-container" class="container navbar-container">
         <div class="navbar-header">
             <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                 <span class="sr-only">Toggle navigation</span>
                 <span class="icon-bar"></span>
                 <span class="icon-bar"></span>
                 <span class="icon-bar"></span>
             </button>
             <a id="brand" class="navbar-brand" href="/">Oscar 10</a>
         </div>
         <div id="navbar" class="collapse navbar-collapse">
             <ul class="nav navbar-nav">
                 <li class="active"><a href="/">My Skills</a></li>
                 <li><a href="/competence/">Competence Rating</a></li>
                 <li><a href="/profile/">Profile</a></li>
                 <li><a href="/project/">Projects</a></li>
             </ul>
             <c:if test="${not empty pageContext.request.userPrincipal}">
	             <h4 class="welcome">
	             	Welcome ${pageContext.request.userPrincipal.name} | 
	             	<a onclick="document.forms['logoutForm'].submit()">Logout</a>
	             </h4>
             </c:if>
         </div><!-- /.nav-collapse -->
     </div><!-- /.container -->
 </nav><!-- /.navbar -->