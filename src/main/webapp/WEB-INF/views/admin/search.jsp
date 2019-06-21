<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ricerca Utente</title>
</head>
<body>

<div class="container">

   <%@ include file="../header.jsp" %>
      
    <div class="page-header">
	  <h3>Ricerca Utente</h3>
	</div>

      	<form:form class="form-horizontal" action="admin/search" method="post" commandName="utenteCommand">
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="nomeId">Nome:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="nomeId" name="nome" >
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="cognomeId">Cognome:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="cognomeId" name="cognome" >
			 	</div>
  			</div>
			<div class="form-group">
      			<label class="control-label col-sm-2" for="usernameId">Username:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="usernameId" name="username" >
			 	</div>
  			</div>
			<div class="form-group">
      			<label class="control-label col-sm-2" for="passwordId">Password:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="passwordId" name="password" >
			 	</div>
  			</div>
  			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-primary btn-md">Effettua Ricerca</button>
		        <a href="admin/insert" class="btn btn-primary btn-md">Inserisci nuovo Utente</a>
		      </div>
		    </div>
		</form:form>
		
    </div><!-- /.container -->



</body>
</html>