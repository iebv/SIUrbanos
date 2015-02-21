package siurbanos

class Card {
    String IDCard //es unico, tok hacerlo
    double amount
    //static hasOne = [user:User]
    static hasMany = [recharges:Recharge,routes:Route]
    static constraints = {
        IDCard (unique: true)
        //user (unique: true)
    }
}
