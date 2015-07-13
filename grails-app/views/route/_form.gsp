<%@ page import="siurbanos.Route" %>



<div class="fieldcontain ${hasErrors(bean: routeInstance, field: 'card', 'error')} required">
	<label for="card">
		<g:message code="route.card.label" default="Card" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="card" name="card.id" from="${siurbanos.Card.list()}" optionKey="id" required="" value="${routeInstance?.card?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: routeInstance, field: 'date', 'error')} required">
	<label for="date">
		<g:message code="route.date.label" default="Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="date" precision="day"  value="${routeInstance?.date}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: routeInstance, field: 'routeName', 'error')} required">
	<label for="routeName">
		<g:message code="route.routeName.label" default="Route Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="routeName" required="" value="${routeInstance?.routeName}"/>

</div>

