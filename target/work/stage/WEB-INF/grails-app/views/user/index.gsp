
<%@ page import="siurbanos.User" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
                <meta name="layout" content="login_bar">
		<g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-user" class="content scaffold-list" role="main">
			<h1>Lista de Usuarios</h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
                                <table class="table"  style="background: #006dba" >
			<thead>
					<tr>
                                            
						<g:sortableColumn property="idUser" title="${message(code: 'user.idUser.label', default: 'Id User')}" />
					
						<g:sortableColumn property="userName" title="${message(code: 'user.userName.label', default: 'User Name')}" />
					
						<g:sortableColumn property="password" title="${message(code: 'user.password.label', default: 'Password')}" />
					
						<th><g:message code="user.card.label" default="Card" /></th>
					
						<g:sortableColumn property="rol" title="${message(code: 'user.rol.label', default: 'Rol')}" />
					
					</tr>
				</thead>
                                <tbody>
				<g:each in="${userInstanceList}" status="i" var="userInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${userInstance.id}">${fieldValue(bean: userInstance, field: "idUser")}</g:link></td>
					
						<td>${fieldValue(bean: userInstance, field: "userName")}</td>
					
						<td>${fieldValue(bean: userInstance, field: "password")}</td>
					
						<td>${fieldValue(bean: userInstance, field: "card")}</td>
					
						<td>${fieldValue(bean: userInstance, field: "rol")}</td>
					
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${userInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
