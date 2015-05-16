import siurbanos.User
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_SIUrbanos_user_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/user/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: userInstance, field: 'idUser', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("user.idUser.label"),'default':("Id User")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("idUser"),'maxlength':("10"),'pattern':(userInstance.constraints.idUser.matches),'required':(""),'value':(userInstance?.idUser)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: userInstance, field: 'userName', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("user.userName.label"),'default':("User Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',19,['name':("userName"),'required':(""),'value':(userInstance?.userName)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: userInstance, field: 'password', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("user.password.label"),'default':("Password")],-1)
printHtmlPart(2)
invokeTag('field','g',28,['type':("password"),'name':("password"),'maxlength':("15"),'required':(""),'value':(userInstance?.password)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: userInstance, field: 'card', 'error'))
printHtmlPart(6)
invokeTag('message','g',34,['code':("user.card.label"),'default':("Card")],-1)
printHtmlPart(7)
invokeTag('select','g',37,['id':("card"),'name':("card.id"),'from':(siurbanos.Card.list()),'optionKey':("id"),'value':(userInstance?.card?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: userInstance, field: 'rol', 'error'))
printHtmlPart(8)
invokeTag('message','g',43,['code':("user.rol.label"),'default':("Rol")],-1)
printHtmlPart(7)
invokeTag('checkBox','g',46,['name':("rol"),'value':(userInstance?.rol)],-1)
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1426007932192L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
