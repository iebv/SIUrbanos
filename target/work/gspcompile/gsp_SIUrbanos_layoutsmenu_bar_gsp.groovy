import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SIUrbanos_layoutsmenu_bar_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/menu_bar.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',3,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
expressionOut.print(resource(dir: 'css', file: 'menu.css'))
printHtmlPart(3)
invokeTag('layoutHead','g',7,[:],-1)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
out.print(java.net.InetAddress.getLocalHost().getCanonicalHostName())
printHtmlPart(6)
out.print(request.getSession().getId())
printHtmlPart(7)
if(true && (session.user)) {
printHtmlPart(8)
}
else {
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
expressionOut.print(createLink(controller:'card', action:'menu'))
printHtmlPart(14)
expressionOut.print(createLink(controller:'card', action:'recargar'))
printHtmlPart(15)
expressionOut.print(createLink(controller:'recharge', action:'historialRecargas'))
printHtmlPart(16)
expressionOut.print(createLink(controller:'route', action:'historialRutas'))
printHtmlPart(17)
invokeTag('layoutBody','g',78,[:],-1)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',79,[:],1)
printHtmlPart(18)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1431728283196L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
