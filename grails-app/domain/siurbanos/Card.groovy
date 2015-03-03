package siurbanos

class Card {
    String idCard //es unico, tok hacerlo
    double amount = 0
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
}
