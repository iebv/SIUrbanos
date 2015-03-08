package siurbanos



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CardController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Card.list(params), model:[cardInstanceCount: Card.count()]
    }
    
    def comprar(){
        
    }
    def show(Card cardInstance) {
        respond cardInstance
    }

    def create() {
        respond new Card(params)
    }

    @Transactional
    def save() {
        def usuario = User.find("from User as u where u.idUser = '${params.idUser}'")
        def idCard = usuario.idUser
        def card = new Card(idCard: idCard)
        card.recargar(20000)
        card.recargar(10000)
        println card
        usuario.card = card
        usuario.save(flush:true)
        card.save(flush:true)
        session.user?.card = card
        redirect(action:'menu', params:[idUser:usuario.idUser])
    }
    
    def recargar(){
        
        if(params.montoRecarga!=null){
            def card = Card.findByIdCard(session.user.card.idCard)
            card.recargar(Double.parseDouble(params.montoRecarga))
            card.save(flush:true)
            session.user.card = card
        }
        
    }

    def menu(){
        
    }
    def edit(Card cardInstance) {
        respond cardInstance
    }

    @Transactional
    def update(Card cardInstance) {
        if (cardInstance == null) {
            notFound()
            return
        }

        if (cardInstance.hasErrors()) {
            respond cardInstance.errors, view:'edit'
            return
        }

        cardInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Card.label', default: 'Card'), cardInstance.id])
                redirect cardInstance
            }
            '*'{ respond cardInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Card cardInstance) {

        if (cardInstance == null) {
            notFound()
            return
        }

        cardInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Card.label', default: 'Card'), cardInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'card.label', default: 'Card'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
