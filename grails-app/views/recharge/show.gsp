
<%@ page import="siurbanos.Recharge" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'recharge.label', default: 'Recharge')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-recharge" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-recharge" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list recharge">
			
				<g:if test="${rechargeInstance?.amountRecharge}">
				<li class="fieldcontain">
					<span id="amountRecharge-label" class="property-label"><g:message code="recharge.amountRecharge.label" default="Amount Recharge" /></span>
					
						<span class="property-value" aria-labelledby="amountRecharge-label"><g:fieldValue bean="${rechargeInstance}" field="amountRecharge"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${rechargeInstance?.card}">
				<li class="fieldcontain">
					<span id="card-label" class="property-label"><g:message code="recharge.card.label" default="Card" /></span>
					
						<span class="property-value" aria-labelledby="card-label"><g:link controller="card" action="show" id="${rechargeInstance?.card?.id}">${rechargeInstance?.card?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${rechargeInstance?.dateRecharge}">
				<li class="fieldcontain">
					<span id="dateRecharge-label" class="property-label"><g:message code="recharge.dateRecharge.label" default="Date Recharge" /></span>
					
						<span class="property-value" aria-labelledby="dateRecharge-label"><g:formatDate date="${rechargeInstance?.dateRecharge}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:rechargeInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${rechargeInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
