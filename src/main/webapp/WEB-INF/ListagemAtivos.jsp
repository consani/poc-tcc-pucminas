<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<c:set var="context" value="${pageContext.request.contextPath}" />

<head>
<meta charset="UTF-8" />
<title>Listagem de Ativos</title>
<link rel="stylesheet" type="text/css" href="${context}/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="${context}/css/style.css" />
</head>
<body>

	<nav class="navbar navbar-inverse navbar-static-top"></nav>

	<div class="panel panel-default container-fluid">
		<div class="panel-heading row">
			<div class="clearfix">
				<h1 class="panel-title col-xs-10 consani-titulo-panel">Listagem de Ativos</h1>
				<a class="btn btn-link col-xs-1 consani-link-panel pull-right" href="<c:url value="/logout" />">Logout</a>
				<sec:authorize access="hasRole('ADMIN')">
					<a class="btn btn-link col-xs-1 consani-link-panel pull-right" href="${context}/ativos/novo">Novo</a>
				</sec:authorize>
			</div>
		</div>

		<div class="panel-body">

			<form method="GET" class="form-horizontal" action="${context}/ativos">
				<div class="form-group">
					<div class="col-sm-4">
						<div class="input-group">
							<input class="form-control"	
										  placeholder="Busca por descricao..." 
										  autofocus="autofocus"
										  name="descricao"/>
								
								<span class="input-group-btn">
								<button type="submit" class="btn btn-default">
									<i class="glyphicon glyphicon-search"></i>
								</button>
							</span>
						</div>
					</div>
				</div>
			</form>


			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th class="text-center col-md-1">#</th>
						<th class="text-center col-md-2">Descricao</th>
						<th class="text-center col-md-2">Categoria</th>
						<th class="text-center col-md-2">Fornecedor</th>
						<th class="text-center col-md-1">Data de Fabricacao</th>
						<th class="text-center col-md-1">Valor Unitario</th>
						<th class="text-center col-md-1">Validade (meses)</th>
						<sec:authorize access="hasRole('ADMIN')">
						<th class="col-md-1"></th>
						</sec:authorize>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ativos}" var="ativo">
						<tr>
							<td class="text-center">${ativo.codigo}</td>
							<td class="text-left">${ativo.descricao}</td>
							<td class="text-center">${ativo.categoria.nome}</td>
							<td class="text-center">${ativo.fornecedor}</td>
							<td class="text-center"><fmt:formatDate
									value="${ativo.dataFabricacao}" type="date" pattern="dd/MM/yyyy" /></td>
							<td class="text-right"><fmt:formatNumber
									value="${ativo.valorUnitario}" type="currency" /></td>
							<td class="text-right"><fmt:formatNumber
									value="${ativo.prazoValidade}" type="number" /></td>
							<sec:authorize access="hasRole('ADMIN')">
							<td class="text-center"><a class="btn btn-link btn-xs"
								data-toggle="modal" data-target="#confirmaRemocaoModal"
								data-whatever="${ativo.codigo}"> <span
									class="glyphicon glyphicon-remove"></span>
							</a></td>
							</sec:authorize>
						</tr>
					</c:forEach>
					<c:if test="${ativos.isEmpty()}">
						<tr>
							<td class="text-center" colspan="7"><i>NENHUM ATIVO
									FOI ENCONTRADO.</i></td>
						</tr>
					</c:if>
				</tbody>
			</table>
		</div>

		<div class="modal fade" id="confirmaRemocaoModal" tabindex="-1"
			data-keyboard="false" data-backdrop="static">
			<div class="modal-dialog">
				<form action="ativos" method="POST">
					<input type="hidden" name="_method" value="DELETE" />

					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title">Confirmacao</h4>
						</div>

						<div class="modal-body">
							<span>Deseja realmente remover o ativo ?</span>
						</div>

						<div class="modal-footer">
							<button type="button" class="btn btn-link" data-dismiss="modal">Cancelar</button>
							<button type="submit" class="btn btn-primary">Confirmar</button>
						</div>
					</div>
				</form>
			</div>
		</div>

	</div>
	<script src="${context}/js/jquery-3.1.1.min.js"></script>
	<script src="${context}/js/bootstrap.min.js"></script>
	<script src="${context}/js/ativos.js"></script>

</body>
</html>

