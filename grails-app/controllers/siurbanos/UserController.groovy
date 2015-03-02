package siurbanos



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class UserController {
    static scaffold = User
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def beforeInterceptor = [action:this.&auth, 
                           except:["login", "logout","save"]]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond User.list(params), model:[userInstanceCount: User.count()]
    }
    
    def login() {
        println User.list()
        println User.list()[0].card.idCard
        println Card.list()
        
        def user = User.findAll("from User as u where u.idUser = '${params.id}' and u.password = '${params.password}'")
        
        if(user){
            session.user = user
            flash.message = "Hello ${user.userName}!"
            render "Bienvenido ${user.userName}"      
        }else{
            flash.message = "El usuario o la contraseña son incorrectos"
            redirect(uri:'/')
            //render "El usuario o la contraseña son incorrectos"
        }
    }
    def logout(){
        session.user = null
        session.invalidate()
        redirect (uri:'/')
    }
    def show(User userInstance) {
        respond userInstance
    }

    def create() {
        respond new User(params)
    }

    
    def auth() {
        String usuario = session?.user?.rol.toString()
        usuario = usuario.substring(1,usuario.size()-1)
        println usuario
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

        userInstance.save flush:true
        redirect (action:'login', params:[id:params.idUser, password: params.password]) //Cuando se registra un usuario se redirecciona al login
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
