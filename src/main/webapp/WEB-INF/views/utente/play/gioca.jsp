<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gioca</title>
</head>
<body>

	<div class="container">

		<%@ include file="../../header.jsp"%>

		<div class="page-header">
			<h3>Pagina di Gioco</h3>
		</div>
		<br><br><br>
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Credito attuale</dt>
				<dd class="col-sm-9">${creditoAttuale}</dd>
			</dl>
			<br><br><br>
		</div>
		<div class="form-group">        
	      <div class="col-sm-offset-2 col-sm-10">
	        <a href="gioca?creditoAttuale=${creditoAttuale}" class="btn btn-primary btn-md">Gioca un'altra mano</a>
	      </div>
	    </div>
	    <div>
	      <div class="col-sm-offset-2 col-sm-10">
	        <a href="lascia" class="btn btn-primary btn-md">Lascia</a>
	      </div>
	    </div>
	</div>

</body>
</html>