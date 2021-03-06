
import siurbanos.Card
import siurbanos.Recharge
import siurbanos.User
import Beans.Login

class BootStrap {

    def init = { servletContext ->
        
        Login conection = new Login();
        
        //Usuario administrador
        def admin = new User(idUser:"1234567890", userName:"Administrador", password:"admin", rol:"admin").save()
        conection.addUserLDAP("1234567890","Administrador","admin");

        
        //Usuario regular
        def user_1 = new User(idUser:"123", userName:"123", password:"12345", rol:"user")
        agregarTarjeta(user_1)
        agregarRecarga(user_1,2000)
        agregarViaje(user_1,"c11")
        agregarViaje(user_1,"c11")
        conection.addUserLDAP("123","123","12345");

        
        def user_2 = new User(idUser:"1234", userName:"1234", password:"12345", rol:"user")
        agregarTarjeta(user_2)
        agregarRecarga(user_2,20000)
        agregarViaje(user_2,"c11")
        agregarViaje(user_2,"c11")
        conection.addUserLDAP("1234","1234","12345");
        
       
    }
    
    def agregarTarjeta(usuario){
        def idCard = usuario.idUser
        def card = new Card(idCard: idCard)
        card.save(flush:true)
        usuario.card = card
        usuario.save(flush:true)
    }
    
    def agregarRecarga(usuario,monto){
        def card1 = usuario.card
        card1.recargar(monto)
        card1.save(flush:true)
    }
    
    def agregarViaje(usuario,ruta){
        def card1 = usuario.card
        card1.viajar(ruta)
        card1.save(flush:true)
    }
    def destroy = {
    }
}
