import siurbanos.Card
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SIUrbanos_card_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/card/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: cardInstance, field: 'idCard', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("card.idCard.label"),'default':("Id Card")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("idCard"),'required':(""),'value':(cardInstance?.idCard)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: cardInstance, field: 'amount', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("card.amount.label"),'default':("Amount")],-1)
printHtmlPart(2)
invokeTag('field','g',19,['name':("amount"),'value':(fieldValue(bean: cardInstance, field: 'amount')),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: cardInstance, field: 'recharges', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("card.recharges.label"),'default':("Recharges")],-1)
printHtmlPart(6)
for( r in (cardInstance?.recharges) ) {
printHtmlPart(7)
createTagBody(2, {->
expressionOut.print(r?.encodeAsHTML())
})
invokeTag('link','g',31,['controller':("recharge"),'action':("show"),'id':(r.id)],2)
printHtmlPart(8)
}
printHtmlPart(9)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'recharge.label', default: 'Recharge')]))
})
invokeTag('link','g',34,['controller':("recharge"),'action':("create"),'params':(['card.id': cardInstance?.id])],1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: cardInstance, field: 'routes', 'error'))
printHtmlPart(11)
invokeTag('message','g',43,['code':("card.routes.label"),'default':("Routes")],-1)
printHtmlPart(6)
for( r in (cardInstance?.routes) ) {
printHtmlPart(7)
createTagBody(2, {->
expressionOut.print(r?.encodeAsHTML())
})
invokeTag('link','g',49,['controller':("route"),'action':("show"),'id':(r.id)],2)
printHtmlPart(8)
}
printHtmlPart(9)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'route.label', default: 'Route')]))
})
invokeTag('link','g',52,['controller':("route"),'action':("create"),'params':(['card.id': cardInstance?.id])],1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: cardInstance, field: 'user', 'error'))
printHtmlPart(12)
invokeTag('message','g',61,['code':("card.user.label"),'default':("User")],-1)
printHtmlPart(2)
invokeTag('select','g',64,['id':("user"),'name':("user.id"),'from':(siurbanos.User.list()),'optionKey':("id"),'required':(""),'value':(cardInstance?.user?.id),'class':("many-to-one")],-1)
printHtmlPart(13)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1426007938543L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
