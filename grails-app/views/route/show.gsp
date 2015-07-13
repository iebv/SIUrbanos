
<%@ page import="siurbanos.Route" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'route.label', default: 'Route')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-route" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-route" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list route">
			
				<g:if test="${routeInstance?.card}">
				<li class="fieldcontain">
					<span id="card-label" class="property-label"><g:message code="route.card.label" default="Card" /></span>
					
						<span class="property-value" aria-labelledby="card-label"><g:link controller="card" action="show" id="${routeInstance?.card?.id}">${routeInstance?.card?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${routeInstance?.date}">
				<li class="fieldcontain">
					<span id="date-label" class="property-label"><g:message code="route.date.label" default="Date" /></span>
					
						<span class="property-value" aria-labelledby="date-label"><g:formatDate date="${routeInstance?.date}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${routeInstance?.routeName}">
				<li class="fieldcontain">
					<span id="routeName-label" class="property-label"><g:message code="route.routeName.label" default="Route Name" /></span>
					
						<span class="property-value" aria-labelledby="routeName-label"><g:fieldValue bean="${routeInstance}" field="routeName"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:routeInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${routeInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
