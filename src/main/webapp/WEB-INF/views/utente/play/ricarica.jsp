<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ricarica Credito</title>
</head>
<body>

<div class="container">

   <%@ include file="../../header.jsp" %>
      
    <div class="page-header">
	  <h3>Ricarica credito</h3>
	</div>

		<form class="form-horizontal" action="ricarica" method="post">
      	
  			<div class="form-group">
      			<label class="control-label col-sm-2" >Credito:</label>
	    		<div class="col-sm-4">
	    		<input type="number" name="nuovoCredito" value="${creditoAccumulato}">
					<c:if test="${erroreRicarica != null}">	
					<div style="color:red;">${erroreRicarica}</div> 
					</c:if>
			 	</div>
  			</div>

			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-primary btn-md">Ricarica</button>
		      </div>
		    </div>
		</form>
		
<%--       	<form:form class="form-horizontal" action="ricarica" method="post" commandName="utenteCommand"> --%>
      	
<!--   			<div class="form-group"> -->
<!--       			<label class="control-label col-sm-2" for="creditoAccumulatoId">Credito:</label> -->
<!-- 	    		<div class="col-sm-4"> -->
<%-- 					<form:input class="form-control" path="creditoAccumulato" id="creditoAccumulatoId" /> --%>
<%-- 					<form:errors path="creditoAccumulato" cssStyle="color:red;"/> --%>
<!-- 			 	</div> -->
<!--   			</div> -->

<!-- 			<div class="form-group">         -->
<!-- 		      <div class="col-sm-offset-2 col-sm-10"> -->
<!-- 		        <button type="submit" class="btn btn-primary btn-md">Ricarica</button> -->
<!-- 		      </div> -->
<!-- 		    </div> -->
<%-- 		</form:form> --%>
		
    </div><!-- /.container -->



</body>
</html>