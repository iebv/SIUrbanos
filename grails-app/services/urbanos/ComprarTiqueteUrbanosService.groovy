package urbanos

import grails.transaction.Transactional
import siurbanos.Card
import siurbanos.User
import javax.jws.soap.*
import javax.jws.*
import javax.xml.ws.*
import javax.xml.bind.annotation.*
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.ParameterStyle;

@WebService (targetNamespace="http://SIUrbanos/")
@SOAPBinding(style=Style.RPC, parameterStyle=ParameterStyle.BARE)
class ComprarTiqueteUrbanosService {
    static expose = ['cxfjax']
    @WebMethod(operationName = "ExistenciaUsuario", action="http://SIUrbanos/ExistenciaUsuario")
    public boolean ExistenciaUsuario(@WebParam(name = "id") String id, @WebParam(name = "password") String password) {
        def user = User.find("from User as u where u.idUser = '${id}' and u.password = '${password}'")
        if (user){
            agregarViaje(user,"c11")
            return true
        }
        else return false
    }
    
    @WebMethod(operationName = "CrearUsuario", action="http://SIUrbanos/CrearUsuario")
    public boolean CrearUsuario (@WebParam(name = "id") String id, @WebParam(name = "password") String password){
        def user = new User(idUser:id, userName:id, password:password, rol:"user")
        if(user){
            agregarTarjeta(user)
            agregarRecarga(user,200000)
            agregarViaje(user,"k6")
            return true
        } 
        return false
    }
    
    @WebMethod(operationName = "agregarTarjeta", action="http://SIUrbanos/agregarTarjeta")
    def agregarTarjeta(usuario){
        def idCard = usuario.idUser
        def card = new Card(idCard: idCard)
        card.save(flush:true)
        usuario.card = card
        usuario.save(flush:true)
    }
    
    @WebMethod(operationName = "agregarRecarga", action="http://SIUrbanos/agregarRecarga")
    def agregarRecarga(usuario,monto){
        def card1 = usuario.card
        card1.recargar(monto)
        card1.save(flush:true)
    }
    
    @WebMethod(operationName = "agregarViaje", action="http://SIUrbanos/agregarViaje")
    def agregarViaje(usuario,ruta){
        def card1 = usuario.card
        card1.viajar(ruta)
        card1.save(flush:true)
    }
    
   
}
