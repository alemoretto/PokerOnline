<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dettaglio Tavolo</title>
</head>
<body>

	<div class="container">

		<%@ include file="../../header.jsp"%>

		<div class="page-header">
			<h3>Pagina di Rimozione</h3>
		</div>
		<c:if test="${erroreTavoloPieno != null}">
			<div class="alert alert-danger">
				${erroreTavoloPieno}</div></c:if>
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Id</dt>
				<dd class="col-sm-9">${tavoloCommand.id }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Denominazione</dt>
				<dd class="col-sm-9">${tavoloCommand.denominazione }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Data di creazione</dt>
				<dd class="col-sm-9">${tavoloCommand.dataCreazione }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Esperienza minima</dt>
				<dd class="col-sm-9">${tavoloCommand.esperienzaMin }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Puntata minima</dt>
				<dd class="col-sm-9">${tavoloCommand.cifraMin }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Giocatori</dt>
				<dd class="col-sm-9">
				<c:forEach items="${tavoloCommand.giocatori}" var="giocatoreItem" varStatus="loop">
				${giocatoreItem.username }
				<c:if test="${tavoloCommand.giocatori.size()-1 > loop.index}">, </c:if>
				</c:forEach>
				</dd>
			</dl>
		</div>
		<div class="form-group">        
	      <div class="col-sm-offset-2 col-sm-10">
	        <a href="delete?idTavolo=${tavoloCommand.id}" class="btn btn-primary btn-md">Rimuovi</a>  <a href="list" class="btn btn-primary btn-md">Torna alla lista</a>
	      </div>


	    </div>

	</div>

</body>
</html>