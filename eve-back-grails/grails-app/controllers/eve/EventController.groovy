package eve

import grails.converters.JSON

class EventController {
    def list(){
        render Event.list()*.asMap() as JSON
    }

    def detail(long id){
        def event = Event.get(id)
        if (event){
            render event.asDetailMap() as JSON
        } else {
            response.status = 404
            render ""
        }

    }

    def defaultError() {
        response.status = 500
        render ""
    }


}
