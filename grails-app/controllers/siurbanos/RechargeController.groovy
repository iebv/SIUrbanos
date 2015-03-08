package siurbanos



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class RechargeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    
    def beforeInterceptor = [action:this.&auth, 
                           except:["historialRecargas"]]
                       
    def auth() {
        String usuario = session?.user?.rol
     
        if( !(usuario== "admin") ){
            flash.message = "Acceso denegado."
            redirect(uri:"/")
            return false
        }
        
    }

    
     def historialRecargas(){
        
        //def rechargesList = Recharge.find("from Recharge as r where r.card = '${session.user.id}'")
        List<Recharge> rechargesList = Recharge.findAllByCard(session.user.card)      
        [recharges: rechargesList]
        
        
    }
    
 
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Recharge.list(params), model:[rechargeInstanceCount: Recharge.count()]
    }

    def show(Recharge rechargeInstance) {
        respond rechargeInstance
    }

    def create() {
        respond new Recharge(params)
    }

    @Transactional
    def save(Recharge rechargeInstance) {
        if (rechargeInstance == null) {
            notFound()
            return
        }

        if (rechargeInstance.hasErrors()) {
            respond rechargeInstance.errors, view:'create'
            return
        }

        rechargeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'recharge.label', default: 'Recharge'), rechargeInstance.id])
                redirect rechargeInstance
            }
            '*' { respond rechargeInstance, [status: CREATED] }
        }
    }

    def edit(Recharge rechargeInstance) {
        respond rechargeInstance
    }

    @Transactional
    def update(Recharge rechargeInstance) {
        if (rechargeInstance == null) {
            notFound()
            return
        }

        if (rechargeInstance.hasErrors()) {
            respond rechargeInstance.errors, view:'edit'
            return
        }

        rechargeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Recharge.label', default: 'Recharge'), rechargeInstance.id])
                redirect rechargeInstance
            }
            '*'{ respond rechargeInstance, [status: OK] }
        }
    }

   
    @Transactional
    def delete(Recharge rechargeInstance) {

        if (rechargeInstance == null) {
            notFound()
            return
        }

        rechargeInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Recharge.label', default: 'Recharge'), rechargeInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'recharge.label', default: 'Recharge'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
