
import siurbanos.Card
import siurbanos.Recharge
import siurbanos.User

class BootStrap {

    def init = { servletContext ->
       agregarTarjeta(new User(idUser:"123", userName:"123", password:"12345", rol:"user"))
       //new User(idUser:"1111111111", userName:"Diez Unos", password:"123").save()
       new User(idUser:"1234567890", userName:"Administrador", password:"admin", rol:"admin").save()
    }
    
    def agregarTarjeta(usuario){
        def idCard = usuario.idUser
        def card = new Card(idCard: idCard)
        recargar(card, 20000)
        recargar(card, 10000)
        card.save(flush:true)
        usuario.card = card
        usuario.save(flush:true)
    }
    
    def recargar(card, monto){
        def recarga = new Recharge (dateRecharge: new Date(), amountRecharge: monto)
        card.amount += recarga.amountRecharge
        recarga.save(flush:true)
        card.addToRecharges(recarga)
        
    }
    def destroy = {
    }
}
