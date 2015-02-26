
import siurbanos.User

class BootStrap {

    def init = { servletContext ->
       new User(idUser:"123", userName:"123", password:"12345", rol:"user").save()
       //new User(idUser:"1111111111", userName:"Diez Unos", password:"123").save()
       new User(idUser:"1234567890", userName:"Administrador", password:"admin", rol:"admin").save()
    }
    def destroy = {
    }
}
