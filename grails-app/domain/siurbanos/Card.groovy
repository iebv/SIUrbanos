package siurbanos

class Card {
    String idCard //es unico, tok hacerlo
    double amount = 0
    double valorPasaje = 1500
    static belongsTo = [user:User]
    static hasMany = [recharges:Recharge,routes:Route]
    static constraints = {
        idCard (unique: true)
        //user (unique: true)
    }
    
   
    
    def recargar(monto){
        this.addToRecharges(new Recharge (dateRecharge: new Date(), amountRecharge: monto)) 
        this.amount += monto
        
        
    }
    
    def viajar(ruta){
        if(this.amount >= valorPasaje){
            this.addToRoutes(new Route(routeName: ruta, date: new Date()))
            this.amount -= valorPasaje           
        }else println "No tiene saldo para realizar el viaje"
    }
}
