package siurbanos

import Beans.Login

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.grails.plugins.wsClient_service.WebService

@Transactional(readOnly = true)
class UserController {
    static scaffold = User
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    WebService webService = new WebService()
    
    def beforeInterceptor = [action:this.&auth, 
        except:["login", "logout","save","loginLDAP"]]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond User.list(params), model:[userInstanceCount: User.count()]
    }
    
    def login() {
        
        def user = User.find("from User as u where u.idUser = '${params.id}' and u.password = '${params.password}'")
   
        if(user){
            session.user = user
            if(user.card == null && user.rol != "admin"){ 
                forward(controller:"card", action:"comprar", params:[idUser: user.idUser]) //Es como redirect pero ocultando la url de los parametros
            } else forward(controller:"card", action:"menu")      
            flash.message = "El usuario o la contraseña son incorrectos"
            redirect(uri:'/')
            //render "El usuario o la contraseña son incorrectos"
        }
    }
    
    def loginLDAP(){
            
        Login conection = new Login();
            
        String mensajeLDAP = conection.login(params.id,params.password);
        System.out.println(mensajeLDAP);
        if(!mensajeLDAP.equals("Login exitoso")){
            flash.message = mensajeLDAP
            redirect(uri:'/')            
        }
        else{
            flash.message = mensajeLDAP
            forward (action:'login', params:[id:params.idUser, password: params.password])
            
        }       
    }    
        
    def logout(){
        session.user = null
        session.invalidate()
        redirect (uri:'/')
    }
    
    def busService(){
        def wsdlURL = "http://localhost:9080/UrbanosESBWSDLService/UrbanosESBWSDLPort?wsdl"
        def proxy = webService.getClient(wsdlURL)
        def result = proxy.UrbanosESBWSDL(user.id, user.password)
    }
    def show(User userInstance) {
        respond userInstance
    }

    def create() {
        respond new User(params)
    }

    
    def auth() {
        String usuario = session?.user?.rol
     
        if( !(usuario== "admin") ){
            flash.message = "Acceso denegado."
            redirect(uri:"/")
            return false
        }
        
    }
    @Transactional
    def save(User userInstance) {
        if (userInstance == null) {
            notFound()
            return
        }

        if (userInstance.hasErrors()) {
            respond userInstance.errors, view:'/index2'
            return
        }

        userInstance.save(flush:true)
        Login conection = new Login();
        conection.addUserLDAP(params.idUser, params.userName , params.password);
        forward (action:'login', params:[id:params.idUser, password: params.password]) //Cuando se registra un usuario se redirecciona al login
        //        request.withFormat {
        //            form multipartForm {
        //                flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])
        //                redirect userInstance
        //            }
        //            '*' { respond userInstance, [status: CREATED] }
        //        }
    }

    def edit(User userInstance) {
        respond userInstance
    }

    @Transactional
    def update(User userInstance) {
        if (userInstance == null) {
            notFound()
            return
        }

        if (userInstance.hasErrors()) {
            respond userInstance.errors, view:'edit'
            return
        }

        userInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'User.label', default: 'User'), userInstance.id])
                redirect userInstance
            }
            '*'{ respond userInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(User userInstance) {

        if (userInstance == null) {
            notFound()
            return
        }

        userInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'User.label', default: 'User'), userInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
