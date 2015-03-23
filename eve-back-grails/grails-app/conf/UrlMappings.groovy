class UrlMappings {

    static mappings = {
        name eventsList: "/event" { controller = 'event'; action = 'list' }
        name eventDetail: "/event/$id" { controller = 'event'; action = 'detail' }


        "500"(controller: 'event', action: 'defaultError')
    }
}
