
import siurbanos.User

class BootStrap {

    def init = { servletContext ->
       new User(idUser:"123", userName:"123", password:"123").save()
        
        
    }
    def destroy = {
    }
}
