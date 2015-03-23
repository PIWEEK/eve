package eve

class Utils{
    static String formatDate(Date date){
        return date?date.format("yyyy-MM-dd'T'HH:mm:ss.SSS+0000"):""
    }
}
