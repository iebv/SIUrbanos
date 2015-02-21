package siurbanos

class Recharge {
    Date dateRecharge
    double amountRecharge
    
    static belongsTo = [card:Card]
    static constraints = {
    }
}
