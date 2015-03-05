package siurbanos

class Route {
    String routeName
    Date date
    static belongsTo = [card:Card]
    static constraints = {
        //El nombre de la ruta no puede ser nulo y estara definido en  determinadas rutas que le demos.
        routeName (blank:false,inList:["14","c11"])
        
    }
}
