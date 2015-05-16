import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SIUrbanos_layoutslogin_bar_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/login_bar.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(3)
expressionOut.print(resource(dir: 'css', file: 'bootstrap.css'))
printHtmlPart(4)
invokeTag('layoutHead','g',13,[:],-1)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',14,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
out.print(java.net.InetAddress.getLocalHost().getCanonicalHostName())
printHtmlPart(7)
out.print(request.getSession().getId())
printHtmlPart(8)

Long counter = (Long) request.getSession().getAttribute("counter");
                            if (counter == null) {
                                counter = 0l;
                            }
                            counter++;
                            request.getSession().setAttribute("counter", counter);

printHtmlPart(9)
expressionOut.print(counter)
printHtmlPart(10)
if(true && (session.user)) {
printHtmlPart(11)
}
else {
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (flash.message)) {
printHtmlPart(14)
expressionOut.print(flash.message)
printHtmlPart(15)
}
printHtmlPart(16)
invokeTag('layoutBody','g',91,[:],-1)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',92,[:],1)
printHtmlPart(17)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1431727659032L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
