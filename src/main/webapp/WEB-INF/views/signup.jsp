<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="js/validate.js"></script>
<title>Sign Up</title>
</head>
<body>

	<div class="container">


		<%@ include file="header.jsp"%>


		<div class="page-header">
			<h3>Registrati</h3>
		</div>

			<form:form class="form-horizontal" action="signup" method="post" commandName="utenteCommand">
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="nomeId">Nome:</label>
	    		<div class="col-sm-4">
					<form:input class="form-control" path="nome" id="nomeId" />
					<form:errors path="nome" cssStyle="color:red;"/>
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="cognomeId">Cognome:</label>
	    		<div class="col-sm-4">
					<form:input class="form-control" path="cognome" id="cognomeId" />
					<form:errors path="cognome" cssStyle="color:red;"/>
			 	</div>
  			</div>
			<div class="form-group">
      			<label class="control-label col-sm-2" for="usernameId">Username:</label>
	    		<div class="col-sm-4">
					<form:input class="form-control" path="username" id="usernameId" />
					<form:errors path="username" cssStyle="color:red;"/>
					<c:if test="${erroreUsername != null }">
					<div style="color:red">${erroreUsername }</div>
					</c:if>
			 	</div>
  			</div>
			<div class="form-group">
      			<label class="control-label col-sm-2" for="passwordId">Password:</label>
	    		<div class="col-sm-4">
					<form:input class="form-control" path="password" id="passwordId" />
					<form:errors path="password" cssStyle="color:red;"/>
			 	</div>
  			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="ripetiPasswordInputId">Ripeti Password:</label>
				<div class="col-sm-4">
					<input class="form-control" type="password" id="ripetiPasswordInputId"
						name="ripetiPasswordInput" placeholder="Ripeti Password"
						onfocus="resetStyle(id)">
					<div id="ripetiPasswordInputErrorId" style="display: none; color: red"></div>
				</div>
			</div>

			<br>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-md">Registrati</button>
				</div>
			</div>
		</form:form>



	</div>
	<!-- /.container -->

</body>
</html>