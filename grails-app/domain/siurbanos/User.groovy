package siurbanos

//import javax.smartcardio.Card

class User {
    String idUser
    String userName
    String password
    boolean rol
    Card card
    
    static constraints = {
        idUser(blank:false, size: 1..10, matches: "[0-9]+", unique:true)
        userName(blank:false)        
        //email email:true,blank:false
        password(password:true, size: 5..15)
        card(nullable:true)
        
    }
}
