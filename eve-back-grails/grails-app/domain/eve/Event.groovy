package eve

class Event{
    String name
    Date startDate = null
    Date endDate = null
    String hashtag = ""
    String logo = ""
    String tags = ""
    Date lastUpdate = new Date()

    static hasMany = [ speakers: Speaker, talks: Talk, tracks: Track]


    static constraints = {
        startDate nullable: true
        endDate nullable: true
        hashtag blank: true
        logo blank: true
        tags blank: true
    }

    static mapping = {
        autoTimestamp true
    }

    Map asMap(){
        def updates = [this.lastUpdate]
        updates.addAll(speakers?speakers.lastUpdate:[])
        updates.addAll(talks?talks.lastUpdate:[])
        updates.addAll(tracks?tracks.lastUpdate:[])
        def update = Utils.formatDate(updates.max())

        return [
            "id": this.id,
            "name": this.name,
            "startDate": Utils.formatDate(this.startDate),
            "endDate": Utils.formatDate(this.endDate),
            "hashtag": this.hashtag,
            "logo": this.hashtag,
            "tags": this.hashtag,
            "lastUpdate": update
        ]
    }

    Map asDetailMap(){
        return [
            "tracks": this.tracks?this.tracks*.asMap():[],
            "speakers": this.speakers?this.speakers*.asMap():[],
            "talks": this.talks?this.talks*.asMap():[],
        ]
    }

}
