package siurbanos

//import javax.smartcardio.Card

class User {
    String idUser
    String userName
    String password
    boolean rol
    Card card
    
    static constraints = {
        idUser(blank:false)
        userName(blank:false)        
        //email email:true,blank:false
        password(password:true)
        card(nullable:true)
        
    }
}
