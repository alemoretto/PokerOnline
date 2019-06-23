<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina dei risultati</title>
</head>
<body>
	<div class="container">

		<%@ include file="../../header.jsp"%>

		<div class="page-header">
			<h3>Tavoli disponibili</h3>
		</div>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Denominazione</th>
					<th>Puntata minima</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listTavoli }" var="tavoloItem">
					<tr>
						<td>${tavoloItem.denominazione }</td>
						<td>${tavoloItem.cifraMin }</td>
						<td><a
							href="show?idTavolo=${tavoloItem.id }"
							class="btn btn-info">Dettaglio</a> <a
							href="siediti?idTavolo=${tavoloItem.id }"
							class="btn btn-info">Siediti</a></td>
							
					</tr>
				</c:forEach>


			</tbody>

		</table>

	</div>


</body>
</html>