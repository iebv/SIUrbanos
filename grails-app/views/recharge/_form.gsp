<%@ page import="siurbanos.Recharge" %>



<div class="fieldcontain ${hasErrors(bean: rechargeInstance, field: 'amountRecharge', 'error')} required">
	<label for="amountRecharge">
		<g:message code="recharge.amountRecharge.label" default="Amount Recharge" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="amountRecharge" value="${fieldValue(bean: rechargeInstance, field: 'amountRecharge')}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: rechargeInstance, field: 'card', 'error')} required">
	<label for="card">
		<g:message code="recharge.card.label" default="Card" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="card" name="card.id" from="${siurbanos.Card.list()}" optionKey="id" required="" value="${rechargeInstance?.card?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: rechargeInstance, field: 'dateRecharge', 'error')} required">
	<label for="dateRecharge">
		<g:message code="recharge.dateRecharge.label" default="Date Recharge" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateRecharge" precision="day"  value="${rechargeInstance?.dateRecharge}"  />

</div>

