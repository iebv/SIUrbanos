import siurbanos.Recharge
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SIUrbanos_rechargehistorialRecargas_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/recharge/historialRecargas.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("menu_bar")],-1)
printHtmlPart(2)
invokeTag('javascript','g',7,['src':("tabla-historial-1.js")],-1)
printHtmlPart(2)
invokeTag('javascript','g',8,['src':("tabla-historial-2.js")],-1)
printHtmlPart(3)
expressionOut.print(resource(dir: 'css', file: 'tabla-historial.css'))
printHtmlPart(4)
createTagBody(2, {->
createClosureForHtmlPart(5, 3)
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(6)
})
invokeTag('captureHead','sitemesh',12,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
for( recharge in (recharges) ) {
printHtmlPart(8)
expressionOut.print(recharge.card.idCard)
printHtmlPart(9)
expressionOut.print(recharge.amountRecharge)
printHtmlPart(10)
invokeTag('formatDate','g',28,['type':("datetime"),'style':("MEDIUM"),'date':(recharge.dateRecharge)],-1)
printHtmlPart(11)
}
printHtmlPart(12)
})
invokeTag('captureBody','sitemesh',45,[:],1)
printHtmlPart(13)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1425765671361L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
