
import siurbanos.User

class BootStrap {

    def init = { servletContext ->
       new User(idUser:"123", userName:"123", password:"123").save()
       new User(idUser:"1111111111", userName:"Diez Unos", password:"123").save()
        
    }
    def destroy = {
    }
}
