<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Poker Online</title>
</head>
<body>

	<div class="container">
		<%@ include file="../header.jsp"%>

		<div class="jumbotron">
			<div class="container">
				<h1 class="display-4">Partita</h1>
				<p>
					<a class="btn btn-primary btn-lg"
						href="${pageContext.request.contextPath}/utente/play/homePlay"
						role="button">Vai al Gioco &raquo;</a>
				</p>
			</div>

		</div>
		<div class="jumbotron">
			<div class="container">
				<h1 class="display-4">Gestione Tavoli</h1>
				<p>
					<a class="btn btn-primary btn-lg"
						href="${pageContext.request.contextPath}/utente/tavolo/search"
						role="button">Gestisci i tuoi Tavoli &raquo;</a>
				</p>
			</div>
		</div>

		<c:if test="${sessionScope.userInfo != null && sessionScope.userInfo.isAdmin()}"> 
			<div class="jumbotron">
				<div class="container">
					<h1 class="display-4">Gestione Utenti</h1>
					<p>
						<a class="btn btn-primary btn-lg"
							href="${pageContext.request.contextPath}/admin/search"
							role="button">Vai alla Gestione Utenti &raquo;</a>
					</p>
				</div>
			</div>
		</c:if>




		<%@ include file="../footer.jsp"%>
	</div>
</body>
</html>