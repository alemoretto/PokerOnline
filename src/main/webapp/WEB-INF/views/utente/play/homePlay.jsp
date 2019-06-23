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
		<%@ include file="../../header.jsp"%>


		<div class="jumbotron">
			<div class="container">
				<h1 class="display-4">Gioco</h1>
				<c:if test="${sessionScope.userInfo != null && !sessionScope.userInfo.isInGioco()}">
				<p>
					<a class="btn btn-primary btn-lg"
						href="${pageContext.request.contextPath}/utente/play/search"
						role="button">Cerca un tavolo &raquo;</a>
				</p>
				</c:if>
				<c:if test="${sessionScope.userInfo != null && sessionScope.userInfo.isInGioco()}">
				<p>
					<a class="btn btn-primary btn-lg"
						href="${pageContext.request.contextPath}/utente/play/riprendi"
						role="button">Riprendi la partita &raquo;</a>
				</p>
				</c:if>
			</div>

		</div>

		<div class="jumbotron">
			<div class="container">
				<h1 class="display-4">Ricarica credito</h1>
				<p>
					<a class="btn btn-primary btn-lg"
						href="${pageContext.request.contextPath}/utente/play/prepareRicarica"
						role="button">Vai alla Ricarica Credito &raquo;</a>
				</p>
			</div>
		</div>




	</div>
</body>
</html>