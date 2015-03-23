package eve

class Track{
    String name
    static belongsTo = [event: Event]
    Date lastUpdate = new Date()

    Map asMap() {
        return [
            "id": this.id,
            "event_id": this.event.id,
            "name": this.name
        ]
    }

    static mapping = {
        autoTimestamp true
    }
}
