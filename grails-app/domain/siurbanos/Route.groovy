package siurbanos

class Route {
    String routeName
    Date date
    static belongsTo = [card:Card]
    static constraints = {
        routeName blank:false
    }
}
