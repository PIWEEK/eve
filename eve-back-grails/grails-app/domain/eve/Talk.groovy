package eve

class Talk{
    String name
    Date startDate = null
    Date endDate = null
    String description = ""
    String hashtag = ""
    String tags = ""
    String roomName = ""
    long maxAtendees = 0
    Track track = null
    Date lastUpdate = new Date()

    static belongsTo = [event: Event]
    static hasMany = [ speakers: Speaker ]


    static constraints = {
        track nullable: true
        startDate nullable: true
        endDate nullable: true
        description nullable: true, blank: true
        hashtag nullable: true, blank: true
        tags nullable: true, blank: true
        roomName nullable: true, blank: true
    }

    static mapping = {
        autoTimestamp true
    }

    Map asMap() {
        return [
            "id": this.id,
            "event_id": this.event.id,
            "track_id": this.track?this.track.id:"",
            "speakers": this.speakers?this.speakers.id.join():"",
            "name": this.name,
            "startDate": Utils.formatDate(this.startDate),
            "endDate": Utils.formatDate(this.endDate),
            "description": this.description,
            "hashtag": this.hashtag,
            "tags": this.tags,
            "roomName": this.roomName,
            "maxAtendees": this.maxAtendees
        ]
    }
}
