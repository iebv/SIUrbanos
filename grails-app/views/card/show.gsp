
<%@ page import="siurbanos.Card" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'card.label', default: 'Card')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-card" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-card" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list card">
			
				<g:if test="${cardInstance?.idCard}">
				<li class="fieldcontain">
					<span id="idCard-label" class="property-label"><g:message code="card.idCard.label" default="Id Card" /></span>
					
						<span class="property-value" aria-labelledby="idCard-label"><g:fieldValue bean="${cardInstance}" field="idCard"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${cardInstance?.amount}">
				<li class="fieldcontain">
					<span id="amount-label" class="property-label"><g:message code="card.amount.label" default="Amount" /></span>
					
						<span class="property-value" aria-labelledby="amount-label"><g:fieldValue bean="${cardInstance}" field="amount"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${cardInstance?.recharges}">
				<li class="fieldcontain">
					<span id="recharges-label" class="property-label"><g:message code="card.recharges.label" default="Recharges" /></span>
					
						<g:each in="${cardInstance.recharges}" var="r">
						<span class="property-value" aria-labelledby="recharges-label"><g:link controller="recharge" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${cardInstance?.routes}">
				<li class="fieldcontain">
					<span id="routes-label" class="property-label"><g:message code="card.routes.label" default="Routes" /></span>
					
						<g:each in="${cardInstance.routes}" var="r">
						<span class="property-value" aria-labelledby="routes-label"><g:link controller="route" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${cardInstance?.user}">
				<li class="fieldcontain">
					<span id="user-label" class="property-label"><g:message code="card.user.label" default="User" /></span>
					
						<span class="property-value" aria-labelledby="user-label"><g:link controller="user" action="show" id="${cardInstance?.user?.id}">${cardInstance?.user?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:cardInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${cardInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
