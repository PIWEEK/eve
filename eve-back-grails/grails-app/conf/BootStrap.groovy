import grails.util.Environment
import eve.*

class BootStrap {



    def addDataToEvent(Event event){
        event.addToTracks(new Track(name:"Track 1"))
        event.addToTracks(new Track(name:"Track 2"))
        event.addToTracks(new Track(name:"Track 3"))

        event.addToSpeakers(new Speaker(
            name: "Jane Doe",
            twitter: "jane3000",
            bio: "asdf asdf",
            photo: "https://randomuser.me/api/portraits/med/women/83.jpg"
            )
        )

        event.addToSpeakers(new Speaker(
            name: "Bob Smith",
            twitter: "bob",
            bio: "qwery qwerty",
            photo: "https://randomuser.me/api/portraits/med/men/26.jpg"
            )
        )

        event.addToTalks(new Talk(name: "Awesome talk 1"))
    }

    def init = { servletContext ->
        if(Environment.current == Environment.DEVELOPMENT){
            if (System.getProperty('loadFixtures')) {
                Event event = new Event(
                    name: "Codemotion",
                    startDate: new Date(),
                    endDate: new Date(),
                    hashtag: "#codemotion",
                    logo: "http://2014.codemotion.es/img/logo_white.png",
                    tags: "groovy, python"
                ).save(failOnError: true)

                addDataToEvent(event)




                event = new Event(
                    name: "Greach",
                    startDate: new Date(),
                    endDate: new Date(),
                    hashtag: "#greach",
                    logo: "http://greachconf.com//wp-content/uploads/2013/12/logo_greach.png",
                    tags: "groovy, grails"
                ).save(failOnError: true)

                addDataToEvent(event)

                event = new Event(
                    name: "PyConEs",
                    startDate: new Date(),
                    endDate: new Date(),
                    hashtag: "#greach",
                    logo: "https://pbs.twimg.com/profile_images/2956564769/6d23da4aa4bfc47ba11453615c1dace4_400x400.png",
                    tags: "python, django"
                ).save(failOnError: true)

                addDataToEvent(event)
            }
        }
    }
    def destroy = {
    }
}
