<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci un nuovo Utente</title>
</head>
<body>

<div class="container">

   <%@ include file="../header.jsp" %>
      
    <div class="page-header">
	  <h3>Inserisci un nuovo Utente</h3>
	</div>

      	<form:form class="form-horizontal" action="save" method="post" commandName="utenteCommand">
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
      			<label class="control-label col-sm-2" for="esperienzaAccumulataId">Esperienza di gioco:</label>
	    		<div class="col-sm-4">
					<form:input class="form-control" path="esperienzaAccumulata" id="esperienzaAccumulataId" />
					<form:errors path="esperienzaAccumulata" cssStyle="color:red;"/>
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="creditoAccumulatoId">Credito:</label>
	    		<div class="col-sm-4">
					<form:input class="form-control" path="creditoAccumulato" id="creditoAccumulatoId" />
					<form:errors path="creditoAccumulato" cssStyle="color:red;"/>
			 	</div>
  			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="statoUtenzaId">Stato Utenza:</label>
				<div class="col-sm-4">
					<form:errors path="statoUtenza" cssStyle="color:red;" />
					<form:select path="statoUtenza.id">
					<option value="-1">Seleziona lo stato dell'utenza</option>
						<form:options items="${listStatiUtenza}" itemValue="id" />
					</form:select>
				</div>
			</div>
			
	<!--	
					<div class="form-group">
				<label class="control-label col-sm-2" for="ruoliId">Ruolo:</label>
				<div class="col-sm-4">
 				<c:forEach items="${listRuoli}" var="ruoloItem">
 						<form:checkbox path="ruoli" value="${ruoloItem.id}" />${ruoloItem.descrizione}<br>
 					</c:forEach>
						<form:checkboxes path="ruoli" items="${listRuoli}" itemValue="id" />
					<form:errors path="ruoli" cssStyle="color:red;" />
				</div>
			</div>  
			
	-->
			<div class="form-group">
				<label class="control-label col-sm-2" for="statoUtenzaId">Ruolo:</label>
				<div class="col-sm-4">
					<c:forEach items="${listRuoli}" var="ruoloItem">
						<input type="checkbox" name="ruoliInput" value="${ruoloItem.id}"
							<c:forEach items="${utenteCommand.ruoli}" var="ruolo"> 
						<c:if test="${ruolo.id == ruoloItem.id}">checked="checked"</c:if>	
					</c:forEach>>
					${ruoloItem.descrizione}<br>
					</c:forEach>
					<form:errors path="ruoli" cssStyle="color:red;" />
				</div>
			</div>

			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-primary btn-md">Inserisci</button>
		      </div>
		    </div>
		</form:form>
		
    </div><!-- /.container -->



</body>
</html>