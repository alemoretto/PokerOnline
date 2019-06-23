<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ricerca un Tavolo</title>
</head>
<body>

<div class="container">

   <%@ include file="../../header.jsp" %>
      
    <div class="page-header">
	  <h3>Ricerca un Tavolo</h3>
	</div>

      	<form:form class="form-horizontal" action="list" method="post" commandName="tavoloCommand">
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="denominazioneId">Denominazione:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="denominazioneId" name="denominazione" >
			 	</div>
  			</div>
  			
			<div class="form-group">
      			<label class="control-label col-sm-2" for="cifraMinId">Puntata minima:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="number" id="cifraMinId" name="cifraMin" >
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="dataCreazioneId">Creato il:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="date" id="dataCreazioneId" name="dataCreazione" >
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="creatoreId">Da:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="creatoreId" name="creatore.username" >
			 	</div>
  			</div>
<!--   			<div class="form-group"> -->
<!--       			<label class="control-label col-sm-2" for="playersId">Partecipanti:</label> -->
<!-- 	    		<div class="col-sm-4"> -->
<!-- 					<input class="form-control" type="text" id="playersId" name="players" > -->
<!-- 			 	</div> -->
<!--   			</div> -->
  			
<!--   			<div class="form-group"> -->
<!--       			<label class="control-label col-sm-2" for="giocatoriId">Partecipanti:</label> -->
<!-- 	    		<div class="col-sm-4"> -->
<!-- 					<input class="form-control" type="text" id="giocatoriId" name="giocatori" > -->
<!-- 			 	</div> -->
<!--   			</div>			 -->
  			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-primary btn-md">Effettua Ricerca</button>
		      </div>
		    </div>
		</form:form>
		
			
			<form class="form-horizontal" action="listByGiocatori" method="post">
			<div class="form-group">
      			<label class="control-label col-sm-2" for="playersId">Partecipanti:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="playersId" name="players" >
			 	</div>
  			</div>
  			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-primary btn-md">Cerca per Giocatori</button>
		      </div>
		    </div>
  			</form>
  			
    </div><!-- /.container -->



</body>
</html>