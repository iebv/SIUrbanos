import siurbanos.User
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SIUrbanos_userindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/user/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("login_bar")],-1)
printHtmlPart(2)
invokeTag('set','g',8,['var':("entityName"),'value':(message(code: 'user.label', default: 'User'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',9,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',10,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('message','g',12,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(6)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(7)
invokeTag('message','g',15,['code':("default.home.label")],-1)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',16,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',16,['class':("create"),'action':("create")],2)
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
invokeTag('sortableColumn','g',28,['property':("idUser"),'title':(message(code: 'user.idUser.label', default: 'Id User'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',30,['property':("userName"),'title':(message(code: 'user.userName.label', default: 'User Name'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',32,['property':("password"),'title':(message(code: 'user.password.label', default: 'Password'))],-1)
printHtmlPart(14)
invokeTag('message','g',34,['code':("user.card.label"),'default':("Card")],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',36,['property':("rol"),'title':(message(code: 'user.rol.label', default: 'Rol'))],-1)
printHtmlPart(16)
loop:{
int i = 0
for( userInstance in (userInstanceList) ) {
printHtmlPart(17)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(18)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: userInstance, field: "idUser"))
})
invokeTag('link','g',44,['action':("show"),'id':(userInstance.id)],3)
printHtmlPart(19)
expressionOut.print(fieldValue(bean: userInstance, field: "userName"))
printHtmlPart(19)
expressionOut.print(fieldValue(bean: userInstance, field: "password"))
printHtmlPart(19)
expressionOut.print(fieldValue(bean: userInstance, field: "card"))
printHtmlPart(19)
expressionOut.print(fieldValue(bean: userInstance, field: "rol"))
printHtmlPart(20)
i++
}
}
printHtmlPart(21)
invokeTag('paginate','g',60,['total':(userInstanceCount ?: 0)],-1)
printHtmlPart(22)
})
invokeTag('captureBody','sitemesh',63,[:],1)
printHtmlPart(23)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1424983974315L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
