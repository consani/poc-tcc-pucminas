<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>

<c:set var="context" value="${pageContext.request.contextPath}" />

<head>
<meta charset="UTF-8" />
<title>Cadastro de Ativo</title>
<link rel="stylesheet" type="text/css" href="${context}/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="${context}/css/style.css" />
<link rel="stylesheet" type="text/css"	href="${context}/css/bootstrap-datepicker.standalone.min.css" />
</head>
<body>

	<nav class="navbar navbar-inverse navbar-static-top"></nav>

	<spring:form class="form-horizontal" method="POST" action="${context}/ativos" modelAttribute="ativo">

		<c:if test="${!empty mensagem}">
			<div class="alert alert-success">
				<span>${mensagem}</span>
			</div>
		</c:if>

		<div class="panel panel-default container-fluid">
			<div class="panel-heading row">
				<div class="clearfix">
					<h1 class="panel-title col-xs-9 consani-titulo-panel">Novo</h1>
					<a class="btn btn-link col-xs-1 consani-link-panel pull-right" href="<c:url value="/logout" />">Logout</a>
					<a class="btn btn-link col-xs-2 consani-link-panel pull-right" href="${context}/ativos">Listagem</a>
				</div>
			</div>
			<div class="panel-body">

				<input type="hidden" value="${ativo.codigo}" />

				<div class="form-group">
					<label for="descricao" class="col-sm-2 control-label">Descricao</label>
					<div class="col-sm-4">
						<spring:input type="text" class="form-control" id="descricao"
							name="descricao" path="descricao" />
						<spring:errors path="descricao" cssClass="error" />
					</div>
				</div>
				<div class="form-group">
					<label for="categoria" class="col-sm-2 control-label">Categoria</label>
					<div class="col-sm-2">
						<select class="form-control" name="categoria">
							<c:forEach items="${todasCategorias}" var="categoria">
								<option value="${categoria}">${categoria.nome}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				
				<div class="form-group">
					<label for="fornecedor" class="col-sm-2 control-label">Fornecedor</label>
					<div class="col-sm-6">
						<spring:input type="text" class="form-control" id="fornecedor"
							name="fornecedor" path="fornecedor" />
						<spring:errors path="fornecedor" cssClass="error" />
					</div>
				</div>
				
				<div class="form-group">
					<label for="dataFabricacao" class="col-sm-2 control-label">Data de fabricacao</label>
					<div class="col-sm-2">
						<spring:input type="text" class="form-control" id="dataFabricacao"
							name="dataFabricacao" path="dataFabricacao" data-provide="datepicker"
							data-date-format="dd/mm/yyyy" data-date-language="pt-BR"
							data-date-autoclose="true" data-date-todayHighlight="true"
							data-date-orientation="bottom" />
						<spring:errors path="dataFabricacao" cssClass="error" />
					</div>
				</div>
				
				<div class="form-group">
					<label for="valorUnitario" class="col-sm-2 control-label">Valor Unitario</label>
					<div class="col-sm-2">
						<spring:input type="text" class="form-control javascript-moeda" id="valorUnitario"
							name="valorUnitario" path="valorUnitario" />
						<spring:errors path="valorUnitario" cssClass="error" />
					</div>
				</div>

				<div class="form-group">
					<label for="prazoValidade" class="col-sm-2 control-label">Prazo de Validade:</label>
					<div class="col-sm-2">
						<input type="number" class="form-control" id="prazoValidade" name="prazoValidade" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-primary">Salvar</button>
					</div>
				</div>
			</div>
		</div>
	</spring:form>

	<script src="${context}/js/jquery-3.1.1.min.js"></script>
	<script src="${context}/js/bootstrap.min.js"></script>
	<script src="${context}/js/bootstrap-datepicker.min.js"></script>
	<script src="${context}/js/bootstrap-datepicker.pt-BR.min.js"></script>
	<script src="${context}/js/jquery.maskMoney.min.js"></script>
	<script src="${context}/js/ativos.js"></script>
</body>
</html>




