
<%@ page import="siurbanos.Recharge" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="menu_bar">
		<g:set var="entityName" value="${message(code: 'recharge.label', default: 'Recharge')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-recharge" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-recharge" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="amountRecharge" title="${message(code: 'recharge.amountRecharge.label', default: 'Amount Recharge')}" />
					
						<th><g:message code="recharge.card.label" default="Card" /></th>
					
						<g:sortableColumn property="dateRecharge" title="${message(code: 'recharge.dateRecharge.label', default: 'Date Recharge')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${recharges}" status="i" var="rechargeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${rechargeInstance.id}">${fieldValue(bean: rechargeInstance, field: "amountRecharge")}</g:link></td>
					
						<td>${fieldValue(bean: rechargeInstance, field: "card")}</td>
					
						<td><g:formatDate date="${rechargeInstance.dateRecharge}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${rechargeInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
