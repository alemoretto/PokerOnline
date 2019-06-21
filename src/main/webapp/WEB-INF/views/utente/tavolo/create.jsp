<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci un nuovo Tavolo</title>
</head>
<body>

<div class="container">

   <%@ include file="../../header.jsp" %>
      
    <div class="page-header">
	  <h3>Inserisci un nuovo Tavolo</h3>
	</div>

      	<form:form class="form-horizontal" action="save" method="post" commandName="tavoloCommand">
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="denominazioneId">Denominazione:</label>
	    		<div class="col-sm-4">
					<form:input class="form-control" path="denominazione" id="denominazioneId" />
					<form:errors path="denominazione" cssStyle="color:red;"/>
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="esperienzaMinId">Esperienza minima:</label>
	    		<div class="col-sm-4">
					<form:input class="form-control" path="esperienzaMin" id="esperienzaMinId" />
					<form:errors path="esperienzaMin" cssStyle="color:red;"/>
			 	</div>
  			</div>
			<div class="form-group">
      			<label class="control-label col-sm-2" for="cifraMinId">Puntata minima:</label>
	    		<div class="col-sm-4">
					<form:input class="form-control" path="cifraMin" id="cifraMinId" />
					<form:errors path="cifraMin" cssStyle="color:red;"/>
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