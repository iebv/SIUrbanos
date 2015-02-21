package siurbanos

class Index2Controller {
    
    def index() { 
        render view: '/subscribe', model: [idUser: params.user, password: params.password]
    }
}
