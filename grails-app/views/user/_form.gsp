<%@ page import="siurbanos.User" %>



<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'idUser', 'error')} required">
	<label for="idUser">
		<g:message code="user.idUser.label" default="Id User" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="idUser" required="" value="${userInstance?.idUser}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'userName', 'error')} required">
	<label for="userName">
		<g:message code="user.userName.label" default="User Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="userName" required="" value="${userInstance?.userName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="user.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="password" name="password" required="" value="${userInstance?.password}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'card', 'error')} ">
	<label for="card">
		<g:message code="user.card.label" default="Card" />
		
	</label>
	<g:select id="card" name="card.id" from="${siurbanos.Card.list()}" optionKey="id" value="${userInstance?.card?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'rol', 'error')} ">
	<label for="rol">
		<g:message code="user.rol.label" default="Rol" />
		
	</label>
	<g:checkBox name="rol" value="${userInstance?.rol}" />

</div>

