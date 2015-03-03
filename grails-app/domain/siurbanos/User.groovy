package siurbanos

//import javax.smartcardio.Card

class User {
    String idUser
    String userName
    String password
    String rol = "user" //Administrador 1 usuario 0
    Card card 
    
    static constraints = {
        idUser(blank:false, size: 1..10, matches: "[1-9][0-9]*", unique:true)
        userName(blank:false)        
        //email email:true,blank:false
        password(password:true, size: 5..15)
        card(nullable:true)
        
    }
    
   
}
