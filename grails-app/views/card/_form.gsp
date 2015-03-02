<%@ page import="siurbanos.Card" %>



<div class="fieldcontain ${hasErrors(bean: cardInstance, field: 'idCard', 'error')} required">
	<label for="idCard">
		<g:message code="card.idCard.label" default="Id Card" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="idCard" required="" value="${cardInstance?.idCard}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: cardInstance, field: 'amount', 'error')} required">
	<label for="amount">
		<g:message code="card.amount.label" default="Amount" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="amount" value="${fieldValue(bean: cardInstance, field: 'amount')}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: cardInstance, field: 'recharges', 'error')} ">
	<label for="recharges">
		<g:message code="card.recharges.label" default="Recharges" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${cardInstance?.recharges?}" var="r">
    <li><g:link controller="recharge" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="recharge" action="create" params="['card.id': cardInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'recharge.label', default: 'Recharge')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: cardInstance, field: 'routes', 'error')} ">
	<label for="routes">
		<g:message code="card.routes.label" default="Routes" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${cardInstance?.routes?}" var="r">
    <li><g:link controller="route" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="route" action="create" params="['card.id': cardInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'route.label', default: 'Route')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: cardInstance, field: 'user', 'error')} required">
	<label for="user">
		<g:message code="card.user.label" default="User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="user" name="user.id" from="${siurbanos.User.list()}" optionKey="id" required="" value="${cardInstance?.user?.id}" class="many-to-one"/>

</div>

