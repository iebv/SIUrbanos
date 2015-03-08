import siurbanos.Recharge
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SIUrbanos_recharge_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/recharge/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: rechargeInstance, field: 'amountRecharge', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("recharge.amountRecharge.label"),'default':("Amount Recharge")],-1)
printHtmlPart(2)
invokeTag('field','g',10,['name':("amountRecharge"),'value':(fieldValue(bean: rechargeInstance, field: 'amountRecharge')),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: rechargeInstance, field: 'card', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("recharge.card.label"),'default':("Card")],-1)
printHtmlPart(2)
invokeTag('select','g',19,['id':("card"),'name':("card.id"),'from':(siurbanos.Card.list()),'optionKey':("id"),'required':(""),'value':(rechargeInstance?.card?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: rechargeInstance, field: 'dateRecharge', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("recharge.dateRecharge.label"),'default':("Date Recharge")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',28,['name':("dateRecharge"),'precision':("day"),'value':(rechargeInstance?.dateRecharge)],-1)
printHtmlPart(6)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1425353272160L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
