<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dettaglio Utente</title>
</head>
<body>

	<div class="container">

		<%@ include file="../header.jsp"%>

		<div class="page-header">
			<h3>Pagina di Rimozione</h3>
		</div>
		<c:if test="${erroreTavoliCreati != null}">
			<div class="alert alert-danger">
				${erroreTavoliCreati}</div></c:if>
				
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Id</dt>
				<dd class="col-sm-9">${utenteCommand.id }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Nome</dt>
				<dd class="col-sm-9">${utenteCommand.nome}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Cognome</dt>
				<dd class="col-sm-9">${utenteCommand.cognome}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Username</dt>
				<dd class="col-sm-9">${utenteCommand.username}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Password</dt>
				<dd class="col-sm-9">${utenteCommand.password}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Stato Utenza</dt>
				<dd class="col-sm-9">${utenteCommand.statoUtenza.descrizione}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Ruoli</dt>
				<dd class="col-sm-9">
					<c:forEach items="${utenteCommand.ruoli}" var="ruolo"
						varStatus="loop">
				${ruolo.descrizione} 
				<c:if test="${utenteCommand.ruoli.size()-1 > loop.index}">, </c:if>
					</c:forEach>
				</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Data di registrazione</dt>
				<dd class="col-sm-9">${utenteCommand.dataRegistrazione}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Esperienza accumulata</dt>
				<dd class="col-sm-9">${utenteCommand.esperienzaAccumulata }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Credito</dt>
				<dd class="col-sm-9">${utenteCommand.creditoAccumulato}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Tavoli creati</dt>
				<dd class="col-sm-9">
					<c:forEach items="${utenteCommand.tavoliCreati}" var="tavolo"
						varStatus="loop">
				${tavolo.denominazione} 
				<c:if test="${utenteCommand.tavoliCreati.size()-1 > loop.index}">, </c:if>
					</c:forEach>
				</dd>
			</dl>
		</div>
		<div class="form-group">        
	      <div class="col-sm-offset-2 col-sm-10">
	          <a href="delete?idUtente=${utenteCommand.id}" class="btn btn-primary btn-md">Rimuovi</a> <a href="list" class="btn btn-primary btn-md">Torna alla lista</a>
	      </div>
	    </div>

	</div>

</body>
</html>