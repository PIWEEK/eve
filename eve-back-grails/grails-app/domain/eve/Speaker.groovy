package eve

class Speaker{
    String name
    String twitter = ""
    String bio = ""
    String photo = ""
    Date lastUpdate = new Date()


    static belongsTo = [event: Event]

    static constraints = {
        twitter nullable: false, blank: true
        bio nullable: false, blank: true
        photo nullable: false, blank: true
    }

    static mapping = {
        autoTimestamp true
    }

    Map asMap() {
        return [
            "id": this.id,
            "event_id": this.event.id,
            "name": this.name,
            "twitter": this.name,
            "bio": this.name,
            "photo": this.name,
        ]
    }
}
