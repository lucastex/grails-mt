package grails.mt

class AgendaController {

    def index() {

        def shows = Show.findAll()
        [shows: shows]
    }
}
